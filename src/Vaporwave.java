import processing.core.*;

public class Vaporwave {
    private PApplet pApplet;
    private int startColor;
    private int endColor;
    private int gridFill;
    private int gridStroke;
    private int sunColor;
    private float noiseMapSpeed;
    private int scl = 15;
    private int centerY = pApplet.height / 2;
    private int centerX = pApplet.width / 2;
    private int cols;
    private int rows;
    private int w;
    private int h;
    private float sunRadius = 100;
    private float hillHeight = 10;
    private float moving = 0;
    private float[][] landscape;
    private Moon[] moons = new Moon[16];



    public Vaporwave(int startColor, int endColor, int gridFill, int gridStroke, int sunColor, int centerY, int centerX, int cols, int rows, int w, int h) {
        startColor = pApplet.color(225, 24, 200);
        this.startColor = startColor;
        endColor = pApplet.color(0, 185, 230);
        this.endColor = endColor;
        gridFill = pApplet.color(80, 20, 120);
        this.gridFill = gridFill;
        gridStroke = pApplet.color(100, 100, 250);
        this.gridStroke = gridStroke;
        sunColor = pApplet.color(255, 245, 190);
        this.sunColor = sunColor;
        this.centerY = centerY;
        this.centerX = centerX;
        this.cols = cols;
        this.rows = rows;
        this.w = w;
        this.h = h;
    }
    public Moon[] getMoons() {
        return moons;
    }

    public void createMoonObjects() {
        // Implementation here
    }

    public void createLandscape() {
        // Implementation here
    }

    public void lights() {
        // Implementation here
        pApplet.lights();
    }

    public void drawSky() {
        // Implementation here
    }

    public void drawSun() {
        // Implementation here
    }

    public void rotateCamera() {
        // Implementation here
        //rotate the camera to tilt the landscape
        pApplet.translate(pApplet.width/2, pApplet.height/2);
        pApplet.rotateX((float) (Math.PI / 2.5));
    }

    public void generateNoiseMap() {
        // Implementation here
    }

    public void drawGrid() {
        // Implementation here
    }

    public void drawGradient(float startY, float endY, int colorStart, int colorEnd) {
        // Implementation here
    }

    public float getNoiseMapSpeed() {
        return noiseMapSpeed;
    }

    public void setNoiseMapSpeed(float speed) {
        this.noiseMapSpeed = speed;
    }

    public void changeNoiseMapSpeed(float delta) {
        this.noiseMapSpeed += delta;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getStartColor() {
        return startColor;
    }

    public int getEndColor() {
        return endColor;
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
    }
}
