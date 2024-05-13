import processing.core.PApplet;

public class Main extends PApplet {
    Game game = new Game("Vaporwave Rhythm Racer");

    public void setup() {
        game.setup();
    }

    public void draw() {
        game.draw();
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);
    }
}