import processing.core.PApplet;
import processing.core.PConstants;
import processing.opengl.*;

public class TwoDGraphics {
    PApplet pApplet;
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
        pApplet.stroke(50, 50, 255);
        // decides the width of the lines
        pApplet.strokeWeight(5);
        for (int i = 0; i <= cols; i++) {
            pApplet.line(0, i * scl, 1080, i * scl);
        }
        for (int j = 0; j <= rows; j++) {
            pApplet.line(j * scl, 0, j * scl, 1920);
        }
    }
}
