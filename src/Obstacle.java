public class Obstacle extends CollisionObject {
    private int damage;
    private int speedUpTimer;

    public Obstacle(int damage, int speedUpTimer) {
        super("Obstacle", 0);
        this.damage = damage;
        this.speedUpTimer = speedUpTimer;
    }

    @Override
    public void onCollision() {

    }

    @Override
    public void playSound() {

    }

    public int getDamage() {
        return damage;
    }

    public int getSpeedUpTimer() {
        return speedUpTimer;
    }
    // Define other methods as per your diagram
}
