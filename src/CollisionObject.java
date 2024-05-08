public abstract class CollisionObject {
    private String name;
    private double yPosition;

    public CollisionObject(String name, double yPosition) {
        this.name = name;
        this.yPosition = yPosition;
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