import processing.core.PApplet;
import processing.core.PConstants;
import processing.opengl.*;

public class Main extends PApplet {
    Game game = new Game("Vaporwave Rhythm Racer");

    public void setup() {
        game.setup();
    }

    public void draw() {
        game.draw();
    }
    public void settings(){
        size(1000,600, OPENGL);
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);
    }
}