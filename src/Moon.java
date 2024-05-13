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
        // the starting position, size and speed are each generated randomly for each new moon, inside the constructor
        startX = (int) pApplet.random(0, (float) (pApplet.width * 1.22));
        this.startX = startX;
        size = (int) pApplet.random(10, 40);
        this.size = size;
        moonSpeed = pApplet.random(2, 5);
        if (size % 2 == 0) {
            moonSpeed *= -1;
        }
        this.moonSpeed = moonSpeed;
        moonHeight = (int) pApplet.random(0, (float) pApplet.height / 4);
        this.moonHeight = moonHeight;
        // EDFC = Extra Distance From Camera
        moonEDFC = (int) pApplet.random(0, 400);
        this.moonEDFC = moonEDFC;
        this.moonColor = pApplet.color(160, 255, 255); // You may need to handle color initialization differently depending on your environment
    }

    public void drawMoon() {
        // Implementation here

        // pushmatrix saves the current camera position
        pApplet.pushMatrix();
        // make them bounce on the edges by reversing their speed whenever they get out of bounds.
        if (t + startX > pApplet.width * 1.22 || t + startX < 0) {
            moonSpeed *= -1;
        }
        // move the camera position slightly before drawing each moon, simluating movement
        pApplet.translate(t + startX, 1200 - moonEDFC, 180 + moonHeight);

        // multiply the moon speed by 5, to compliment the fast forward function for the landscape.
        if (pApplet.mousePressed) {
            t += moonSpeed * 5;
        } else {
            t += moonSpeed;
        }

        pApplet.stroke(moonColor);
        pApplet.fill(moonColor);
        pApplet.sphere(size);
        // popmatrix will reset the camera position after the moon is drawn, this avoid messing everything else up with the contantly changing camera
        // yes, there is no better way to do this in processing. i looked.
        pApplet.popMatrix();
    }
}
