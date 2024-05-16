import processing.core.PApplet;

public class Block extends GameObject {
    private int yPosition;
    private int blockWidth = 40;
    private float blockHeight;
    private int randomLane;


    public Block(PApplet pApplet) {
        super(pApplet);
        this.yPosition = 0;
        this.randomLane = (int) pApplet.random(1, 4);
        this.blockHeight = pApplet.random(40, 200);
    }

    @Override
    public double getXPosition() {
        int xPosition = pApplet.width / 2;
        if (getRandomLane() == 1) {
            xPosition -= 96;
        }
        if (getRandomLane() == 3) {
            xPosition += 96;
        }
        return xPosition;
    }

    @Override
    public double getYPositionUpper() {
        return yPosition;
    }

    @Override
    public double getYPositionLower() {
        return yPosition + this.getBlockHeight();
    }

    @Override
    public int getRandomLane() {
        return randomLane;
    }

    public void displayObject(int lane) {
        pApplet.fill(255, 255, 255);
        lane = this.getRandomLane();
        if (lane == 1) {
            pApplet.rect(pApplet.width / 2 - 96, yPosition, blockWidth, blockHeight);
        }
        if (lane == 2) {
            pApplet.rect(pApplet.width / 2, yPosition, blockWidth, blockHeight);
        }
        if (lane == 3) {
            pApplet.rect(pApplet.width / 2 + 96, yPosition, blockWidth, blockHeight);
        }
    }

    @Override
    public boolean checkCollision(GameObject gameObject) {
        return false;
    }

    @Override
    public void updateObjectPosition(float gameSpeed) {
        this.yPosition += gameSpeed * 45;
    }

    public float getBlockHeight() {
        return blockHeight;
    }
}
