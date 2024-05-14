import processing.core.PApplet;

public class Graphics extends AGraphics {
    float gridSpeed = 0;
    private int w;
    private int h;
    private final int cols = 40;
    private final int rows = 40;
    private int gridFill;
    private int gridStroke;
    private final int scl = 48;
    private int[][] landscape;

    public Graphics(PApplet pApplet) {
        super(pApplet);
    }

    public void createLandscape() {
        landscape = new int[cols][rows];
    }

    public void drawGrid(float speed) {
        // colors the stroke
        pApplet.stroke(50, 50, 255);
        // decides the width of the lines
        pApplet.strokeWeight(4);
        for (int i = 0; i <= cols; i++) {
            pApplet.line(0, i * scl+(int)gridSpeed, 1920, i * scl+(int)gridSpeed);
            // this actually determines the speed
            gridSpeed += speed;
            if (gridSpeed > 48){
                gridSpeed = 0;
            }
        }
        for (int j = 0; j <= rows; j++) {
            pApplet.line(j * scl, 0, j * scl, 1080);
        }
    }
    public void drawGradient() {
        int startY = 0;
        int endY = pApplet.height;
//        int colorStart = pApplet.color(225, 24, 200);
//        int colorEnd = pApplet.color(0, 185, 230);

        // loops, drawing a line at each y coordiante, since there is no way to outright draw gradients within processing.
        for (int y = startY; y < 20*endY; y++) {


            // maps y's position within startY and endY within a range of 0-1
//            float inter = PApplet.map(y, startY, endY*10, 0, 1);

            // interpolates the color values relative to the mapped "inter", which is shwoing how far we are between startX and startY, helping us in picking a corresponding color
//            int colorC = pApplet.lerpColor(colorStart, colorEnd, inter);

            //draws a background gradient
            pApplet.stroke(255-y, (float)(y*0.5), 40+y+y);

            // 1920 is width
            pApplet.strokeWeight(1);
            pApplet.line(0, y,pApplet.width, y);

            // the values here are bit high since we need it far into the background.
//            pApplet.line(-82110, 11111+y, 5*pApplet.width, y+900, -1000, -1000);
        }
    }

    @Override
    public void displayGraphics() {
    }
}
