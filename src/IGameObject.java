public interface IGameObject {
    public double getXPosition();
    public double getYPositionUpper();
    public double getYPositionLower();
    public void displayObject(int i);
    public boolean checkCollision(GameObject gameObject);
    public void updateObjectPosition(float gameSpeed);
    public int getRandomLane();
}
