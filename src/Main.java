import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;

public class
Main extends PApplet {
    //    Game game = new Game("Vaporwave Rhythm Racer", this);
//    Graphics graphics = new Graphics(this);
    float gameSpeed = (float) 0.05;
    static ArrayList<GameObject> gameObjectsList = new ArrayList<>();
    TwoDGraphics twoDGraphics = new TwoDGraphics(this);
    Player player = new Player(this, 3);
//    GameObject block = new Block(this);

    float obstacleDelay = 0;

    float obstacleCounter = 0;

    int testCounter = 0;

    public void settings() {
        size(1920, 1080);
        fullScreen();
    }

    @Override
    public void setup() {
    }

    @Override
    public void draw() {

        if(player.getHealth() == 0){
            //TODO quit program
            this.exit();
        }

        background(255);
        twoDGraphics.drawGradient();
        twoDGraphics.drawGrid(gameSpeed);
        generateObstacles();
        for (int i = gameObjectsList.size()-1; i > -1; i--) {

            gameObjectsList.get(i).updateObjectPosition(gameSpeed);
            gameObjectsList.get(i).displayObject(gameObjectsList.get(i).getRandomLane());
            //TODO make collision work
            if (gameObjectsList.get(i).getYPositionLower() >= player.getYPositionUpper() && gameObjectsList.get(i).getYPositionUpper() <= player.getYPositionLower()) {
                player.checkCollision(gameObjectsList.get(i));
            }
        }

//        for (GameObject g : gameObjectsList) {
//            g.updateObjectPosition(gameSpeed);
//            g.displayObject(g.getRandomLane());
//            //TODO make collision work
//            if(g.getYPositionLower() >= player.getYPositionUpper() && g.getYPositionUpper() <= player.getYPositionLower()) {
//                player.checkCollision(g);
//            }
//        }
        player.displayObject(0);
//        game.gameDraw();
    }

//    public void generateObstacles1() {
//        for (int i = 600; i % this.frameCount == 0; i += 0) {
//            GameObject block = new Block(this);
//            gameObjectsList.add(block);
//            int randomLane = (int) this.random(1, 3);
//            block.displayObject(randomLane);
//        }
//    }

    public void generateObstacles() {
        if (obstacleCounter >= obstacleDelay) {
            Block block = new Block(this);
            gameObjectsList.add(block);
            obstacleDelay = this.random(10, 60);
            obstacleCounter = 0;
        }
        obstacleCounter += gameSpeed*5;
    }
    public static void removeGameObject(GameObject gameObject) {
        GameObject objectToRemove = null;
        for(GameObject o: gameObjectsList) {
            if (o == gameObject){
                objectToRemove = o;
                break;
            }
        }
        if(objectToRemove!=null) {
            gameObjectsList.remove(objectToRemove);
        }
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);
    }
}