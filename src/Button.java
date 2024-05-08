public class Button {
    private boolean showButton;
    private int width;
    private int height;
    private int xPosition;
    private int yPosition;
    private boolean buttonPressed;

    public Button(int width, int height, int xPosition, int yPosition) {
        this.width = width;
        this.height = height;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void drawButton(int x, int y, int width, int height) {
        // Method code here
    }

    public void buttonPressed() {
        // Method code here
    }

    public Button getButton() {
        return this;
    }
}
