import processing.core.PApplet;

public class Main extends PApplet {
    Game game = new Game("Vaporwave Rhythm Racer");
//    TwoDGraphics testGrid = new TwoDGraphics(this);

    public void settings() {
        size(1920, 1080);
        fullScreen();
    }

    public void setup() {
    }

    public void draw() {
        game.draw();
//        player.displayShape();
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);
    }
}