import processing.core.*;

public class Moon {
    private int moonColor;
    private int startX;
    private float moonSpeed;
    private int t = 0;
    private int size;
    private int moonHeight;
    private int moonEDFC;
    private PApplet pApplet;

    public Moon(int startX, int size, float moonSpeed, int moonHeight, int moonEDFC) {
        this.startX = startX;
        this.size = size;
        this.moonSpeed = moonSpeed;
        this.moonHeight = moonHeight;
        this.moonEDFC = moonEDFC;
        this.moonColor = pApplet.color(160, 255, 255); // You may need to handle color initialization differently depending on your environment
    }

    public void drawMoon() {
        // Implementation here
    }
}
