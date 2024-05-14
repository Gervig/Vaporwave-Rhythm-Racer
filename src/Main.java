import processing.core.PApplet;

public class Main extends PApplet {
//    Game game = new Game("Vaporwave Rhythm Racer");
    TwoDGraphics grid = new TwoDGraphics(this);
    Player player = new Player(this, 3);
//    TwoDGraphics testGrid = new TwoDGraphics(this);

    public void settings() {
        size(1920, 1080);
        fullScreen();
    }

    public void setup() {
    }

    public void draw() {
        background(255);
        grid.drawGradient();
        grid.drawGrid((float)0.05);
        player.displayShape();
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);
    }
}