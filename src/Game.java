import processing.core.*;
import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Game {
//    public PApplet pApplet = new PApplet();
    private String name;
    private boolean gameRunning;
    private boolean mainMenuRunning;
    private boolean settingsMenuRunning;
    private boolean leaderboardsMenuRunning;
    private boolean exitGameMenuRunning;
    private ArrayList<Integer> highScores;

    // extra feature for later
//    public AudioPlayer audioPlayer;

    public Player player;
    public Obstacle block;
    public Obstacle speedUp;
    public PowerUp heal;
    public PowerUp slowTime;
    public PowerUp superTime;
    public Graphics graphics = new Graphics();
//    public static Vaporwave vaporwave = new Vaporwave();

    // constructor
    public Game(String name) {
        this.name = name;
    }

    public void draw() {
        graphics.drawGraphics();
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
