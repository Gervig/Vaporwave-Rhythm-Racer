import processing.core.PApplet;

import java.util.ArrayList;

public class Game {
    PApplet pApplet;
    private String name;
    private boolean gameRunning;
    private boolean mainMenuRunning;
    private boolean settingsMenuRunning;
    private boolean leaderboardsMenuRunning;
    private boolean exitGameMenuRunning;
    private ArrayList<Integer> highScores;
    GameObject player = new Player(pApplet, 3);
    Graphics graphics = new Graphics(pApplet);

    // extra feature for later
//    public AudioPlayer audioPlayer;
    public Obstacle block;
    public Obstacle speedUp;
    public PowerUp heal;
    public PowerUp slowTime;
    public PowerUp superTime;
//    public static Vaporwave vaporwave = new Vaporwave();

    // constructor
    public Game(String name, PApplet pApplet) {
        this.name = name;
    }

    public void gameDraw() {
        graphics.drawGraphics();
//        player.displayObject();
    }

    public void setup() {
    }

    public void runStartMenu() {

    }

    public void settingsMenu() {

    }

    public void runGameChecks() {

    }

    public void continueGame() {

    }

    public void playerDeath() {

    }

    public void quitProgram() {

    }
}
