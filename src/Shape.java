import processing.core.PApplet;

public abstract class Shape implements IShape{
    PApplet pApplet;

    public Shape(PApplet pApplet) {
        this.pApplet = pApplet;
    }


}
