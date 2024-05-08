public abstract class GameObject {
    protected double xPosition;
    protected double zPosition;

    public GameObject(double xPosition, double zPosition) {
        // Constructor code here
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getZPosition() {
        return zPosition;
    }
}