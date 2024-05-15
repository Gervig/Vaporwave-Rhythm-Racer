import processing.core.PApplet;

public class Graphics{
    PApplet pApplet;
    private double speed = 0.05;
    private TwoDGraphics twoDGraphics = new TwoDGraphics(pApplet);
    public Graphics(PApplet pApplet) {
    this.pApplet = pApplet;
        // Constructor code here
    }

    public void drawGraphics() {
        twoDGraphics.drawGradient();
        twoDGraphics.drawGrid(speed);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}