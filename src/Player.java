public class Player {
    private int health;
    private int maxHealth;
    private int scorePoints;
    private boolean superPower;

    // constructor
    public Player(int health) {
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void resetScorePoints() {
        this.scorePoints = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getScorePoints() {
        return scorePoints;
    }

    public void changeHealth(){

    }

    public void changeScorePoints(){

    }

    // Define other methods as per your diagram
}