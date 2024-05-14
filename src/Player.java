import processing.core.PApplet;

public class Player extends Shape {
    private int health;
    private int maxHealth;
    private int scorePoints;
    private boolean superPower;
    int mouseXPos = pApplet.mouseX;

    // constructor

    public Player(PApplet pApplet, int health) {
        super(pApplet);
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void resetScorePoints() {
        this.scorePoints = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getScorePoints() {
        return scorePoints;
    }

    public void changeHealth() {

    }

    public void changeScorePoints() {

    }

    public int[] getPlayerPos() {
        int[] playerPos = new int[2];
        playerPos[0] = mouseXPos - 48;
        playerPos[1] = mouseXPos + 48;
        return playerPos;
    }

    @Override
    public void displayShape() {
//        pApplet.rectMode(0);
        mouseXPos = pApplet.mouseX;
        int leftBound = pApplet.width / 2 - 96;
        int rightBound = pApplet.width / 2 + 96;
        if (mouseXPos <= leftBound) {
            mouseXPos = leftBound;
        } else if (mouseXPos >= rightBound) {
            mouseXPos = rightBound;
        }
        pApplet.rect(mouseXPos - 48, 700, 96, 144, 28);
    }

    // Define other methods as per your diagram
}