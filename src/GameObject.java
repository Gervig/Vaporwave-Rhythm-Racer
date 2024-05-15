import processing.core.PApplet;

public abstract class GameObject implements IGameObject {
    PApplet pApplet;

    // constructor
    public GameObject(PApplet pApplet) {
        this.pApplet = pApplet;
    }

}