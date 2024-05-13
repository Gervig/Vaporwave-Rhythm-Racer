import processing.core.PApplet;
import processing.core.PGraphics;

public class Graphics extends PApplet{
//    private PApplet pApplet = new PApplet();
//    private Vaporwave vaporwave;
    public Graphics() {
        // Constructor code here
    }

    public void drawGraphics() {
//        Game.pApplet.background(255);
        Game.pg.background(255);
        Game.pg.lights();
        Game.vaporwave.drawSky();
        // test if rotateCamera can be called in setup
        Game.vaporwave.rotateCamera();
        Game.vaporwave.generateNoiseMap();
        Game.vaporwave.drawGrid();
        // calls the draw moon for each of our moon objects in the moons array
        for (Moon m : Game.vaporwave.getMoons()) {
            m.drawMoon();
        }
        Game.vaporwave.drawSky();
        Game.vaporwave.drawGradient(1700, Game.pApplet.height, Game.vaporwave.getStartColor(), Game.vaporwave.getEndColor());
        Game.vaporwave.drawSun();
    }
}