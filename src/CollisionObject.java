public abstract class CollisionObject {
    protected String name;
    protected double yPosition;

    public CollisionObject(String name, double yPosition) {
        // Constructor code here
    }

    public abstract void onCollision();

    public abstract void playSound();

    public double getYPosition() {
        return yPosition;
    }

    public void setYPosition(double yPosition) {
        this.yPosition = yPosition;
    }



}