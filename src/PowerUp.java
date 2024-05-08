public class PowerUp extends CollisionObject {
    private int healing;
    private int superTimer;
    private int slowTimer;

    public PowerUp(int healing, int superTimer, int slowTimer) {
        super("PowerUp", 0);
        // Constructor code here
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