public abstract class GameObject {
    private double xPosition;
    private double zPosition;

    // constructor
    public GameObject(double xPosition, double zPosition) {
        this.xPosition = xPosition;
        this.zPosition = zPosition;
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getZPosition() {
        return zPosition;
    }
}