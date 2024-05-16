import processing.core.PApplet;

import java.util.ArrayList;

public class
Main extends PApplet {
    //    Game game = new Game("Vaporwave Rhythm Racer", this);
//    Graphics graphics = new Graphics(this);
    float gameSpeed = (float) 0.051;
    int speedCounter = 0;
    static float score = 0;

    int scoreScreenCounter = 0;
    static ArrayList<GameObject> gameObjectsList = new ArrayList<>();
    TwoDGraphics twoDGraphics = new TwoDGraphics(this);
    Player player = new Player(this, 3);
//    GameObject block = new Block(this);

    float invincibilityDelay = 0;
    float getInvincibilityCounter = 0;
    float blockDelay = 0;
    float healthDelay = 0;
    float blockCounter = 0;
    float healthBlockCounter = 0;

    int testCounter = 0;

    public void settings() {
        size(600, 800);
        fullScreen();
    }

    @Override
    public void setup() {

    }

    @Override
    public void draw() {

        if (player.getHealth() < 0) {
            //TODO highscore stuff, death screen, retry, main menu !!!
            background(0);
            text("You died! \nYour score: " + score, this.width / 2 - 100, this.height / 2 - 200);
            scoreScreenCounter++;
            if (scoreScreenCounter > 600) {
                exit();
            }
        } else {

            if (speedCounter > 100) {
                gameSpeed += 0.01;
                speedCounter = 0;
            } else {
                speedCounter++;
            }
            player.setInvincibilityTimer(player.getInvincibilityTimer() - 1);
            background(255);
            twoDGraphics.drawGradient();
            twoDGraphics.drawGrid(gameSpeed);
            twoDGraphics.drawBounds();
            generatePowerUps();
            generateBlocks();
            for (int i = gameObjectsList.size() - 1; i > -1; i--) {

                gameObjectsList.get(i).updateObjectPosition(gameSpeed);
                gameObjectsList.get(i).displayObject(gameObjectsList.get(i).getRandomLane());
                if (gameObjectsList.get(i).getYPositionLower() >= player.getYPositionUpper() && gameObjectsList.get(i).getYPositionUpper() <= player.getYPositionLower()) {
                    player.checkCollision(gameObjectsList.get(i));
                } else if (gameObjectsList.get(i).getYPositionUpper() > this.height) {
                    removeGameObject(gameObjectsList.get(i));
                }
            }
            player.displayObject(0);
            displayScore();
        }
    }

    public void generatePowerUps() {
        if (healthBlockCounter >= healthDelay) {
            HealthBlock healthBlock = new HealthBlock(this);
            gameObjectsList.add(healthBlock);
            healthDelay = this.random(100, 600);
            healthBlockCounter = 0;
        }
        if (getInvincibilityCounter >= invincibilityDelay) {
            Invincibility invincibilityBlock = new Invincibility(this);
            gameObjectsList.add(invincibilityBlock);
            invincibilityDelay = this.random(100, 600);
            getInvincibilityCounter = 0;
        }
        healthBlockCounter += gameSpeed * 5;
        getInvincibilityCounter += gameSpeed;
    }

    public void generateBlocks() {
        if (blockCounter >= blockDelay) {
            Block block = new Block(this);
            gameObjectsList.add(block);
            blockDelay = this.random(10, 60);
            blockCounter = 0;
        }
        blockCounter += gameSpeed * 5;
    }

    public static void removeGameObject(GameObject gameObject) {
        GameObject objectToRemove = null;
        for (GameObject o : gameObjectsList) {
            if (o == gameObject) {
                objectToRemove = o;
                break;
            }
        }
        if (objectToRemove != null) {
            gameObjectsList.remove(objectToRemove);
        }
    }

    public void displayScore() {
        fill(255);
        textSize(32);
        score += gameSpeed;
        text(score, 10, 50);
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);
    }
}