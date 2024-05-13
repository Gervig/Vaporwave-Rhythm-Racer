import processing.core.PApplet;

import java.util.ArrayList;

public class Game {
    private String name;
    private boolean gameRunning;
    private boolean mainMenuRunning;
    private boolean settingsMenuRunning;
    private boolean leaderboardsMenuRunning;
    private boolean exitGameMenuRunning;
    private ArrayList<Integer> highScores;

    // extra feature for later
//    public AudioPlayer audioPlayer;

    PApplet pApplet;
    public Player player;
    public Obstacle block;
    public Obstacle speedUp;
    public PowerUp heal;
    public PowerUp slowTime;
    public PowerUp superTime;
    public Graphics graphics;
    public Vaporwave vaporwave;

// constructor
    public Game(String name) {
        this.name = name;
    }

    public void draw(){

    }

    public void setup(){
    pApplet.size(1000,600);
//    vaporwave.defineSizeConstants();
    vaporwave.createMoonObjects();
    vaporwave.createLandscape();
    }

    public void runStartMenu(){

    }

    public void settingsMenu(){

    }

    public void runGameChecks(){

    }

    public void continueGame(){

    }

    public void playerDeath(){

    }

    public void quitProgram(){

    }
}
