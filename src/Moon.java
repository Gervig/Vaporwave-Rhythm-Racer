import processing.core.*;

public class Moon extends PApplet{
//    private PApplet pApplet = new PApplet();
//    private int moonColor;
//    private int startX;
//    private float moonSpeed;
//    private int t = 0;
//    private int size;
//    private int moonHeight;
//    private int moonEDFC;
//
//    public Moon() {
//        // the starting position, size and speed are each generated randomly for each new moon, inside the constructor
//        startX = (int) Game.pApplet.random(0, (float) (Game.pApplet.width * 1.22));
//        size = (int) Game.pApplet.random(10, 40);
//        moonSpeed = Game.pApplet.random(2, 5);
//        if (size % 2 == 0) {
//            moonSpeed *= -1;
//        }
//        moonHeight = (int) Game.pApplet.random(0, (float) Game.pApplet.height / 4);
//        // EDFC = Extra Distance From Camera
//        moonEDFC = (int) Game.pApplet.random(0, 400);
//    }
//
//    public void drawMoon() {
//        // Implementation here
//
//        // pushmatrix saves the current camera position
//        Game.pg.pushMatrix();
//        // make them bounce on the edges by reversing their speed whenever they get out of bounds.
//        if (t + startX > Game.pApplet.width * 1.22 || t + startX < 0) {
//            moonSpeed *= -1;
//        }
//        // move the camera position slightly before drawing each moon, simluating movement
//        Game.pg.translate(t + startX, 1200 - moonEDFC, 180 + moonHeight);
//
//        // multiply the moon speed by 5, to compliment the fast forward function for the landscape.
//        if (Game.pApplet.mousePressed) {
//            t += moonSpeed * 5;
//        } else {
//            t += moonSpeed;
//        }
//
//        Game.pg.stroke(moonColor);
//        Game.pg.fill(moonColor);
//        Game.pg.sphere(size);
//        // popmatrix will reset the camera position after the moon is drawn, this avoid messing everything else up with the contantly changing camera
//        // yes, there is no better way to do this in processing. i looked.
//        Game.pg.popMatrix();
//    }
}
