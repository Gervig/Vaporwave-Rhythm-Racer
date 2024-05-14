import processing.core.PApplet;

public class TwoDGraphics extends Graphics {
    private PApplet pApplet;
    private int w;
    private int h;
    private final int cols = 20;
    private final int rows = 30;
    private int gridFill;
    private int gridStroke;
    private final int scl = 15;
    private int[][] landscape;

    public TwoDGraphics(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public void createLandscape() {
        landscape = new int[cols][rows];
    }

    public void drawGrid() {
        createLandscape();
        // colors the stroke
        stroke(50, 50,255);
        // decides the width of the lines
        strokeWeight(5);
        for(int i = 0; i <= cols; i++){
            line(0,i*scl, 1080, i*scl);
        }
        for(int j = 0; j <= rows; j++){
            line(j*scl,0, j*scl, 1920);
        }
    }
}
