import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PConstants;
import processing.opengl.*;
import static java.lang.Math.sqrt;
import static processing.core.PApplet.sq;

public class Main extends PApplet {
    //    Game game = new Game("Vaporwave Rhythm Racer");
    private int startColor = color(225, 24, 200);
    private int endColor = color(0, 185, 230);
    private int gridFill = color(80, 20, 120);
    private int gridStroke = color(100, 100, 250);
    private int sunColor = color(100, 100, 250);
    private float noiseMapSpeed;
    private int scl = 15;
    private int centerY = height / 2;
    private int centerX = width / 2;
    private int cols;
    private int rows;
    private int w;
    private int h;
    private float sunRadius = 100;
    private float hillHeight = 10;
    private float moving = 0;
    private float[][] landscape;
    private Moon[] moons = new Moon[16];

    public void settings(){
        size(1000,600, P3D);
    }

    public void setup() {
        createMoonObjects();
        createLandscape();
    }

    public void draw() {
//        camera(-100, 100, -200, 0, 0, 0, 0, 1, 0);
        drawGraphics();
    }
    public void drawGraphics() {
        background(255);
        lights();
        drawSky();
        // test if rotateCamera can be called in setup
        rotateCamera();
        generateNoiseMap();
        drawGrid();
        // calls the draw moon for each of our moon objects in the moons array
        for (Moon m : moons) {
            m.drawMoon();
        }
    }
    public void createMoonObjects() {
        for (int i = 0; i < moons.length; i++) {
            moons[i] = new Moon();
        }
    }
    public float getNoiseMapSpeed() {
        return noiseMapSpeed;
    }
    public void setNoiseMapSpeed(float speed) {
        this.noiseMapSpeed = speed;
    }

    public void changeNoiseMapSpeed(float delta) {
        this.noiseMapSpeed += delta;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getStartColor() {
        return startColor;
    }

    public int getEndColor() {
        return endColor;
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
    }
    public void createLandscape() {
        landscape = new float[cols][rows];
    }
    public void drawSky() {
        //define the start and end colors of the sky
        drawGradient(1700, height, startColor, endColor);
        drawSun();
    }

    public void drawSun() {
        shapeMode(CENTER);
        stroke(sunColor);

        // to see the background through the sun in horizontal lines, and without having to painstakenly draw parts of the background on top of the sun, we instead draw it line by line in a for loop
        // we can calculate the x coordinates of the startng and ending point with some clever use of maths:
        // 1. y - centerY calculates the vertical distance from the center
        // 2. then we square the circle's radius
        // 3. then we square the vertical distance, and subtract it from the square of the circle's radius. the result is the distance from the center to the start/endpoint, squared
        // 4. we take the square root of that value, giving us the actual distance, essentially undoing the two square-operations we did before.
        // 5. we add/subtract this result from the center to get the end/startpoint.
        // 6. draw the line :)!
        for (int y = (centerY - (int)sunRadius); y <= centerY + sunRadius; y++) {
            if (!(y > centerY+35 && y<centerY+45 || y > centerY+60 && y<centerY+75 ||  y > centerY+80 && y<centerY+95 || y > centerY+100 && y<centerY+102)) {
                float x1 = centerX - (float)sqrt(sq(sunRadius) - sq(y - centerY));
                float x2 = centerX + (float)sqrt(sq(sunRadius) - sq(y - centerY));
                line(x1, y-170, x2, y-170);
            }
        }
    }
    public void rotateCamera() {
        //rotate the camera to tilt the landscape
        //camera test
//        camera(0,0,100,width/2, height,100,0,0,1);
        translate(width/2, height/2);
        rotateX((float) (Math.PI / 2.5));
//        camera(0, 0, 0, 0, 0, 0, 0, 1, 0);
//        camera(width/2, height/2, (height/2) / tan(PI/6), width/2, height/2, 0, 0, 1, 0);

    }
    public void drawGradient(float startY, float endY, int colorStart, int colorEnd) {
        // loops, drawing a line at each y coordiante, since there is no way to outright draw gradients within processing.
        for (int y = (int)startY; y < 20*(int)endY; y++) {


            // maps y's position within startY and endY within a range of 0-1
            float inter = map(y, startY, endY*10, 0, 1);

            // interpolates the color values relative to the mapped "inter", which is shwoing how far we are between startX and startY, helping us in picking a corresponding color
            int colorC = lerpColor(colorStart, colorEnd, inter);
            stroke(colorC);

            // the values here are bit high since we need it far into the background.
            line(-82110, 11111+y, 5*width, y+900, -1000, -1000);
        }
    }
    public void defineSizeConstants(){
        //The height, width and number of rows and columns on the grid is dependant on the window size
        w = (int)(width*1.2);
        h = (height*5);
        cols = w/scl;
        rows = h/scl;
    }
    public void setColorSettings(){
        colorMode(RGB);
    }
    public void drawGrid() {
        translate(-w/2, -h/2 +350, -70);
        for (int y = 0; y < rows-1; y++) {
            // we draw a triangle vertex, using the unchanging values for x and y, and the changing Z values from the landscape double array.
            beginShape(TRIANGLE_STRIP);
            for (int x = 0; x< cols; x++) {
                stroke(gridStroke);
                fill(gridFill);
                vertex(x*scl, y*scl, landscape[x][y]);
                vertex(x*scl, (1+y)*scl, landscape[x][y+1]);
            }
            endShape();
        }
    }
    public void generateNoiseMap() {
        // "moving" sets the speed of the landscape
        moving -= 0.008;

        // magnitude of hills
        hillHeight = 10;

        // perlin noise map generation. perlin noise is preffered over purely random values because there is less chaos, in perlin noise maps, adjacent values are near eachother, which makes them great for simulating landscapes.
        // xoff and yoff help set the offset on the noise map. if there wasn no increasing offset to the the vertex's "linked" Z coordinate, the landscape would not simulate movement. yoff is multiplied by "moving", allowing us to
        // control the speed of the y axis movement.
        // now, we can use a nested for loop to determine Z values for the grid in each draw iteration.
        float yoff = moving;
        for (int y = 0; y < rows; y++) {
            float xoff = 0;
            for (int x = 0; x< cols; x++) {
                // a triple conditional is used to divide the landscape into a left, right and center part, where hillHeight is tied to different values.
                if ( x < 37) {
                    landscape [x] [y] = map(noise(xoff, yoff), 0, 1, 0, hillHeight *(38-x));
                } else if ( x > 43) {
                    landscape [x] [y] = map(noise(xoff, yoff), 0, 1, hillHeight *(-43+x), 0);
                } else {
                    landscape [x] [y] = map(noise(xoff, yoff), 0, 1, 0, 0);
                }
                // the offsets will increase in each loop to make sure the entire grid is not tied to the same Z value
                xoff += 0.1;
            }
            yoff += 0.1;
            // hold to speed up, draws two triangles to show a fast forward effect.
            if (mousePressed) {
                moving -= 0.001;
                fill(255);
                triangle(width-50, 50, width-50, 90, width-30, 70);
                triangle(width-80, 50, width-80, 90, width-60, 70);
            }
        }
    }

    public class Moon {
        private int moonColor;
        private int startX;
        private float moonSpeed;
        private int t = 0;
        private int size;
        private int moonHeight;
        private int moonEDFC;

        public Moon() {
            // the starting position, size and speed are each generated randomly for each new moon, inside the constructor
            startX = (int) random(0, (float) (width * 1.22));
            size = (int) random(10, 40);
            moonSpeed = random(2, 5);
            if (size % 2 == 0) {
                moonSpeed *= -1;
            }
            moonHeight = (int) random(0, (float) height / 4);
            // EDFC = Extra Distance From Camera
            moonEDFC = (int) random(0, 400);
        }
        public void drawMoon() {
            // pushmatrix saves the current camera position
            pushMatrix();
            // make them bounce on the edges by reversing their speed whenever they get out of bounds.
            if (t + startX > width * 1.22 || t + startX < 0) {
                moonSpeed *= -1;
            }
            // move the camera position slightly before drawing each moon, simluating movement
            translate(t + startX, 1200 - moonEDFC, 180 + moonHeight);

            // multiply the moon speed by 5, to compliment the fast forward function for the landscape.
            if (mousePressed) {
                t += moonSpeed * 5;
            } else {
                t += moonSpeed;
            }

            stroke(moonColor);
            fill(moonColor);
            sphere(size);
            // popmatrix will reset the camera position after the moon is drawn, this avoid messing everything else up with the contantly changing camera
            // yes, there is no better way to do this in processing. i looked.
            popMatrix();
        }

    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);
    }
}