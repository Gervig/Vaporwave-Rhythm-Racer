import processing.core.PApplet;

public class TwoDGraphics extends Graphics{
    private PApplet pApplet;
    private int w;
    private int h;
    private int cols;
    private int rows;
    private int gridFill;
    private int gridStroke;
    private final int scl = 15;
    private float[][] landscape;

    public TwoDGraphics(PApplet pApplet) {
        this.pApplet = pApplet;
    }
    public void createLandscape() {
        landscape = new float[cols][rows];
    }
    public void drawGrid() {
        translate(-w/2, -h/2 +350, -70);
        for (int y = 0; y < rows-1; y++) {
            // we draw a triangle vertex, using the unchanging values for x and y, and the changing Z values from the landscape double array.
            pApplet.beginShape(pApplet.TRIANGLE_STRIP);
            for (int x = 0; x< cols; x++) {
                pApplet.stroke(gridStroke);
                pApplet.fill(gridFill);
                pApplet.vertex(x*scl, y*scl, landscape[x][y]);
                pApplet.vertex(x*scl, (1+y)*scl, landscape[x][y+1]);
            }
            pApplet.endShape();
        }
    }
}
