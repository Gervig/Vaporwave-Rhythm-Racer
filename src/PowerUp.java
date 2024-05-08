public class PowerUp extends CollisionObject {
    private int healing;
    private int superTimer;
    private int slowTimer;

    public PowerUp(String name, double yPosition, int healing, int superTimer, int slowTimer) {
        super(name, yPosition);
        this.healing = healing;
        this.superTimer = superTimer;
        this.slowTimer = slowTimer;
    }

    @Override
    public void onCollision() {

    }

    @Override
    public void playSound() {

    }

    public int getHealing() {
        return healing;
    }

    public int getSuperTimer() {
        return superTimer;
    }

    public int getSlowTimer() {
        return slowTimer;
    }

    // Define other methods as per your diagram
}