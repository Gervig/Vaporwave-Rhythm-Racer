import processing.core.PApplet;

public abstract class AGraphics {
    public PApplet pApplet;

    public AGraphics(PApplet pApplet) {
        this.pApplet = pApplet;
    }
    public abstract void displayGraphics();


}
