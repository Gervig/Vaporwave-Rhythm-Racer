public class Obstacle extends CollisionObject {
    private int damage;
    private int speedUpTimer;

    public Obstacle(int damage, int speedUpTimer) {
        super("Obstacle", 0);
        // Constructor code here
    }

    @Override
    public void onCollision() {

    }

    @Override
    public void playSound() {

    }

    // Define other methods as per your diagram
}