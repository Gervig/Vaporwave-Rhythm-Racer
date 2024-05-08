import processing.core.PApplet;

public class Main extends PApplet {
    Game game = new Game("Vaporwave Rhythm Racer");
    PApplet pApplet = new PApplet();

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);
    }
}