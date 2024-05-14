import processing.core.PApplet;

public class Player extends Shape {
    private int health;

    private int carYPos = (int)(pApplet.height*9);
    private int carWidth = 96;
    private int carHeight = 144;
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

    private void drawWheels(int x, int y) {
        //TODO position these rectangles to be where the wheels are supposed to be drawn

        // left front wheel
        pApplet.rect(5, 25, x, y, 28);
        // right front wheel
        pApplet.rect(5, 25, x, y, 28);
        // left back wheel
        pApplet.rect(5, 25, x, y, 28);
        // right back wheel
        pApplet.rect(5, 25, x, y, 28);

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
        // a is x, b is y, c is width, d is height and r is radius of the corners (gives the rectangle round corners)
        pApplet.rect(mouseXPos - 48, carYPos, carWidth, carHeight, 28);
//        drawWheels(mouseXPos,carYPos);
    }

    // Define other methods as per your diagram
}