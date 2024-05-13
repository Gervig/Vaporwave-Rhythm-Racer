public class Graphics {
    private Vaporwave vaporwave;
    public Graphics() {
        // Constructor code here
    }

    public void drawGraphics() {
        // Method code here
        vaporwave.lights();
        vaporwave.drawSky();
        vaporwave.drawSun();
        vaporwave.generateNoiseMap();
        vaporwave.drawGrid();
    }
}