import processing.core.PApplet;
import processing.core.PGraphics;

public class Graphics extends PApplet{
    PApplet pApplet;
//    private PApplet pApplet;
    TwoDGraphics twoDGraphics = new TwoDGraphics(pApplet);
//    private Vaporwave vaporwave;
    public Graphics() {

        // Constructor code here
    }

    public void drawGraphics() {
        twoDGraphics.drawGrid();
    }
}