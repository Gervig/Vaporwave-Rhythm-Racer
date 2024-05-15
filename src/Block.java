import processing.core.PApplet;

public class Block extends GameObject {
    private int yPosition;
    private int blockWidth = 40;
    private float blockHeight;
    private int randomLane;


    public Block(PApplet pApplet) {
        super(pApplet);
        this.yPosition = 0;
        this.randomLane = (int)pApplet.random(1,3);
        this.blockHeight = pApplet.random(40, 200);
    }

    @Override
    public double getXPosition() {
        return 0;
    }

    @Override
    public double getYPositionUpper() {
        return 0;
    }

    @Override
    public double getYPositionLower() {
        return 0;
    }

    @Override
    public int getRandomLane() {
        return randomLane;
    }

    public void displayObject(int lane) {
        lane = this.getRandomLane();
        if (lane == 1){
            pApplet.rect(pApplet.width-96, yPosition, blockWidth, blockHeight);
        }
        if(lane == 2) {
            pApplet.rect(pApplet.width, yPosition, blockWidth, blockHeight);
        }
        if(lane == 3){
            pApplet.rect(pApplet.width+96, yPosition, blockWidth, blockHeight);
        }
    }

    @Override
    public boolean checkCollision(GameObject gameObject) {
        return false;
    }

    @Override
    public void updateObjectPosition(float gameSpeed) {
        this.yPosition += gameSpeed;
    }
}
