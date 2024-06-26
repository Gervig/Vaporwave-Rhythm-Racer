import processing.core.PApplet;

public class Player extends GameObject {
    private int health;
    private int carYPos = (int) (pApplet.height * 7);
    private int carWidth = 96;
    private int carHeight = 144;
    private int maxHealth = 3;
    private boolean superPower;
    private int invincibilityTimer = 0;
    int mouseXPos = pApplet.mouseX;

    // constructor
    public Player(PApplet pApplet, int health) {
        super(pApplet);
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void displayHealth() {

    }

    public int getHealth() {
        return health;
    }


    public void changeHealth(int amount) {
        this.health += amount;
    }

    public void changeScorePoints() {

    }

    public int[] getPlayerPos() {
        int[] playerPos = new int[2];
        this.getXPosition();
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
    public void displayObject(int i) {
//        pApplet.rectMode(0);
        this.getXPosition();
        switch (this.health) {
            case 0:
                // fill with black
                pApplet.fill(50, 0, 0);
                break;
            case 1:
                // fill with red
                pApplet.fill(250, 0, 150);
                break;
            case 2:
                // fill with yellow
                pApplet.fill(200, 200, 100);
                break;
            case 3:
                // fill with red
                pApplet.fill(50, 250, 150);
                break;
        }
        // a is x, b is y, c is width, d is height and r is radius of the corners (gives the rectangle round corners)
        pApplet.rect(mouseXPos - 48, carYPos, carWidth, carHeight, 28);
//        drawWheels(mouseXPos,carYPos);
        if (invincibilityTimer > 0) {
            pApplet.fill(255);
            pApplet.textSize(32);
            pApplet.text(invincibilityTimer, (int)getXPosition()-carWidth/4, (int) getYPositionUpper() + carHeight / 2);
        }
    }

    public int getInvincibilityTimer() {
        return invincibilityTimer;
    }

    public void setInvincibilityTimer(int invincibilityTimer) {
        this.invincibilityTimer = invincibilityTimer;
    }

    int testCounter = 0;

    @Override
    public boolean checkCollision(GameObject gameObject) {
        int objectPosition = (int) gameObject.getXPosition();
        if (this.getPlayerPos()[0] <= objectPosition && objectPosition <= this.getPlayerPos()[1]) {
            if (gameObject instanceof HealthBlock) {
                if (this.getHealth() < 3) {
                    this.changeHealth(1);
                }
            } else if (gameObject instanceof Invincibility) {
                invincibilityTimer = 300;
            } else if (invincibilityTimer > 0) {
                Main.score += 10;
            } else {
                this.changeHealth(-1);
            }
            Main.removeGameObject(gameObject);
//            System.out.println("You got hit");
            return true;
        }
        if (this.getPlayerPos()[0] <= objectPosition + 40 && objectPosition + 48 <= this.getPlayerPos()[1]) {
            if (gameObject instanceof HealthBlock) {
                if (this.getHealth() < 3) {
                    this.changeHealth(1);
                }
            } else if (gameObject instanceof Invincibility) {
                invincibilityTimer = 300;
            } else if (invincibilityTimer > 0) {
                Main.score += 10;
            } else {
                this.changeHealth(-1);
            }
            Main.removeGameObject(gameObject);
//            System.out.println("You got hit");
            return true;
        }
        return false;
    }

    @Override
    public void updateObjectPosition(float gameSpeed) {
    }

    @Override
    public int getRandomLane() {
        return 0;
    }

    @Override
    public double getXPosition() {
        mouseXPos = pApplet.mouseX;
        int leftBound = pApplet.width / 2 - 96;
        int rightBound = pApplet.width / 2 + 144;
        if (mouseXPos <= leftBound) {
            mouseXPos = leftBound;
        } else if (mouseXPos >= rightBound) {
            mouseXPos = rightBound;
        }
        return mouseXPos;
    }

    @Override
    public double getYPositionUpper() {
        return carYPos;
    }

    @Override
    public double getYPositionLower() {
        return carYPos + carHeight;
    }


    // Define other methods as per your diagram
}