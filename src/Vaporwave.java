import processing.core.*;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PConstants;
import processing.opengl.*;
import static java.lang.Math.sqrt;
import static processing.core.PApplet.sq;

public class Vaporwave extends PApplet{
//    private int startColor;
//    private int endColor;
//    private int gridFill;
//    private int gridStroke;
//    private int sunColor;
//    private float noiseMapSpeed;
//    private int scl = 15;
//    private int centerY = Game.pApplet.height / 2;
//    private int centerX = Game.pApplet.width / 2;
//    private int cols;
//    private int rows;
//    private int w;
//    private int h;
//    private float sunRadius = 100;
//    private float hillHeight = 10;
//    private float moving = 0;
//    private float[][] landscape;
//    private Moon[] moons = new Moon[16];
//
//    public Vaporwave() {
//        startColor = Game.pApplet.color(225, 24, 200);
//        this.startColor = startColor;
//        endColor = Game.pApplet.color(0, 185, 230);
//        this.endColor = endColor;
//        gridFill = Game.pApplet.color(80, 20, 120);
//        this.gridFill = gridFill;
//        gridStroke = Game.pApplet.color(100, 100, 250);
//        this.gridStroke = gridStroke;
//        sunColor = Game.pApplet.color(255, 245, 190);
//        this.sunColor = sunColor;
//        this.centerY = centerY;
//        this.centerX = centerX;
//        this.cols = cols;
//        this.rows = rows;
//        this.w = w;
//        this.h = h;
//    }
//    public Moon[] getMoons() {
//        return moons;
//    }
//
////    public void createMoonObjects() {
////        for (int i = 0; i < moons.length; i++) {
////            moons[i] = new Moon();
////        }
////    }
//
////    public void createLandscape() {
////        landscape = new float[cols][rows];
////    }
//
////    public void lights() {
////        // Implementation here
////        Game.pApplet.lights();
////    }
//
////    public void drawSky() {
////        //define the start and end colors of the sky
////        drawGradient(1700, Game.pApplet.height, startColor, endColor);
////
////        drawSun();
////    }
//
////    public void drawSun() {
////        Game.pg.shapeMode(Game.pApplet.CENTER);
////        Game.pg.stroke(sunColor);
////
////        // to see the background through the sun in horizontal lines, and without having to painstakenly draw parts of the background on top of the sun, we instead draw it line by line in a for loop
////        // we can calculate the x coordinates of the startng and ending point with some clever use of maths:
////        // 1. y - centerY calculates the vertical distance from the center
////        // 2. then we square the circle's radius
////        // 3. then we square the vertical distance, and subtract it from the square of the circle's radius. the result is the distance from the center to the start/endpoint, squared
////        // 4. we take the square root of that value, giving us the actual distance, essentially undoing the two square-operations we did before.
////        // 5. we add/subtract this result from the center to get the end/startpoint.
////        // 6. draw the line :)!
////        for (int y = (centerY - (int)sunRadius); y <= centerY + sunRadius; y++) {
////            if (!(y > centerY+35 && y<centerY+45 || y > centerY+60 && y<centerY+75 ||  y > centerY+80 && y<centerY+95 || y > centerY+100 && y<centerY+102)) {
////                float x1 = centerX - (float)sqrt(sq(sunRadius) - sq(y - centerY));
////                float x2 = centerX + (float)sqrt(sq(sunRadius) - sq(y - centerY));
////                Game.pg.line(x1, y-170, x2, y-170);
////            }
////        }
////    }
//
////    public void rotateCamera() {
////        // Implementation here
////        //rotate the camera to tilt the landscape
////        Game.pg.translate(Game.pApplet.width/2, Game.pApplet.height/2);
////        //camera test
//////        Game.pg.camera(-100, 100, -200, 0, 0, 0, 0, 1, 0);
//////        Game.pg.rotateX((float) (Math.PI / 2.5));
////    }
//
////    public void generateNoiseMap() {
////        // "moving" sets the speed of the landscape
////        moving -= 0.008;
////
////        // magnitude of hills
////        hillHeight = 10;
////
////        // perlin noise map generation. perlin noise is preffered over purely random values because there is less chaos, in perlin noise maps, adjacent values are near eachother, which makes them great for simulating landscapes.
////        // xoff and yoff help set the offset on the noise map. if there wasn no increasing offset to the the vertex's "linked" Z coordinate, the landscape would not simulate movement. yoff is multiplied by "moving", allowing us to
////        // control the speed of the y axis movement.
////        // now, we can use a nested for loop to determine Z values for the grid in each draw iteration.
////        float yoff = moving;
////        for (int y = 0; y < rows; y++) {
////            float xoff = 0;
////            for (int x = 0; x< cols; x++) {
////                // a triple conditional is used to divide the landscape into a left, right and center part, where hillHeight is tied to different values.
////                if ( x < 37) {
////                    landscape [x] [y] = PApplet.map(Game.pApplet.noise(xoff, yoff), 0, 1, 0, hillHeight *(38-x));
////                } else if ( x > 43) {
////                    landscape [x] [y] = PApplet.map(Game.pApplet.noise(xoff, yoff), 0, 1, hillHeight *(-43+x), 0);
////                } else {
////                    landscape [x] [y] = PApplet.map(Game.pApplet.noise(xoff, yoff), 0, 1, 0, 0);
////                }
////                // the offsets will increase in each loop to make sure the entire grid is not tied to the same Z value
////                xoff += 0.1;
////            }
////            yoff += 0.1;
////            // hold to speed up, draws two triangles to show a fast forward effect.
////            if (Game.pApplet.mousePressed) {
////                moving -= 0.001;
////                Game.pApplet.fill(255);
////                Game.pApplet.triangle(Game.pApplet.width-50, 50, Game.pApplet.width-50, 90, Game.pApplet.width-30, 70);
////                Game.pApplet.triangle(Game.pApplet.width-80, 50, Game.pApplet.width-80, 90, Game.pApplet.width-60, 70);
////            }
////        }
////    }
//
////    public void drawGrid() {
////        Game.pg.translate(-w/2, -h/2 +350, -70);
////        for (int y = 0; y < rows-1; y++) {
////            // we draw a triangle vertex, using the unchanging values for x and y, and the changing Z values from the landscape double array.
////            Game.pg.beginShape(Game.pApplet.TRIANGLE_STRIP);
////            for (int x = 0; x< cols; x++) {
////                Game.pg.stroke(gridStroke);
////                Game.pg.fill(gridFill);
////                Game.pg.vertex(x*scl, y*scl, landscape[x][y]);
////                Game.pg.vertex(x*scl, (1+y)*scl, landscape[x][y+1]);
////            }
////            Game.pg.endShape();
////        }
////    }
//
////    public void setColorSettings(){
////        Game.pApplet.colorMode(Game.pApplet.RGB);
////    }
//
////    public void drawGradient(float startY, float endY, int colorStart, int colorEnd) {
////        // loops, drawing a line at each y coordiante, since there is no way to outright draw gradients within processing.
////        for (int y = (int)startY; y < 20*(int)endY; y++) {
////
////
////            // maps y's position within startY and endY within a range of 0-1
////            float inter = PApplet.map(y, startY, endY*10, 0, 1);
////
////            // interpolates the color values relative to the mapped "inter", which is shwoing how far we are between startX and startY, helping us in picking a corresponding color
////            int colorC = Game.pApplet.lerpColor(colorStart, colorEnd, inter);
////            Game.pg.stroke(colorC);
////
////            // the values here are bit high since we need it far into the background.
////            Game.pg.line(-82110, 11111+y, 5*Game.pApplet.width, y+900, -1000, -1000);
////        }
////    }
//
////    public void defineSizeConstants(){
////        //The height, width and number of rows and columns on the grid is dependant on the window size
////        w = (int)(Game.pApplet.width*1.2);
////        h = (Game.pApplet.height*5);
////        cols = w/scl;
////        rows = h/scl;
////    }
//
////    public float getNoiseMapSpeed() {
////        return noiseMapSpeed;
////    }
////
////    public void setNoiseMapSpeed(float speed) {
////        this.noiseMapSpeed = speed;
////    }
////
////    public void changeNoiseMapSpeed(float delta) {
////        this.noiseMapSpeed += delta;
////    }
////
////    public int getCenterY() {
////        return centerY;
////    }
////
////    public int getCenterX() {
////        return centerX;
////    }
////
////    public int getStartColor() {
////        return startColor;
////    }
////
////    public int getEndColor() {
////        return endColor;
////    }
////
////    public void setStartColor(int startColor) {
////        this.startColor = startColor;
////    }
////
////    public void setEndColor(int endColor) {
////        this.endColor = endColor;
////    }
}