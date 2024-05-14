import processing.core.PApplet;
import processing.core.PConstants;
import processing.opengl.*;

public class Main extends PApplet {
    Game game = new Game("Vaporwave Rhythm Racer");
    public void settings(){
        size(1920,1080);
//        fullScreen();
    }

    public void setup() {
//        game.setup();
    }

    public void draw() {
        background(255);
        game.draw();
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);
    }
}