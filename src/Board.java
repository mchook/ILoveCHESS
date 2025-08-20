import processing.core.PApplet;

public class Board {
    private boolean activated;
    private int type;
    private int[] coordinates = new int[2];
    private PApplet parent;
    public Board() {
        type = 0;
    }
    public Board(int[] coordinates, PApplet p) {
        for (int i = 0; i < coordinates.length; i++) {
            this.coordinates[i] = coordinates[i] * 80;
        }
        type = 0;
        parent = p;
    }


    public void setType(int type) {
        this.type = type;
    }

    public int getBoardType() {
        return type;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public int getX() {
        return coordinates[0];
    }

    public int getY() {
        return coordinates[1];
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }


    public void drawCircle() {
        if(activated) {
            parent.fill(173, 216, 230);
            parent.ellipse(coordinates[0] + 40, coordinates[1] + 40, 15, 15);
        }
    }
}
