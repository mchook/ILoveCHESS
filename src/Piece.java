import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Piece {
    protected int type;
    protected int newX;
    protected int newY;
    protected int pieceVal;
    protected boolean isWhite;
    protected boolean activated;
    protected int[] coordinates = new int[2];
    protected int[] pos = new int[2];
    ArrayList<int[]> activatedPositions = new ArrayList<>();
    protected PApplet parent;
    protected PImage pieceIMG;
    public Piece(boolean isWhite, PApplet p) {
        this.isWhite = isWhite;
        activated = false;
        parent = p;
    }
    public Piece(boolean isWhite, int[] coordinates, PApplet p, PImage white_P_IMG, PImage black_P_Image, int type) {
        this.isWhite = isWhite;
        activated = false;
        parent = p;
        for (int i = 0; i < coordinates.length; i++) {
            this.coordinates[i] = coordinates[i]*80;
            pos[i] = coordinates[i];
        }
        if(isWhite()) {
            pieceIMG = white_P_IMG;
        } else pieceIMG = black_P_Image;
        pieceIMG.resize(80,80);
        this.type = type * whiteOrBlack();
    }

    public int getPieceType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public boolean isWhite() {
        return isWhite;
    }

    public int whiteOrBlack() {
        if(isWhite()) {
            return 1;
        }
        return -1;
    }
    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public void setNewX(int newX) {
        this.newX = newX;
    }

    public void setNewY(int newY) {
        this.newY = newY;
    }

    public void setPieceVal(int pieceVal) {
        this.pieceVal = pieceVal;
    }

    public int getNewX() {
        return newX;
    }

    public int getNewY() {
        return newY;
    }

    public int getPieceVal() {
        return pieceVal;
    }
    public boolean isBlocked(Board[][] board) {
        return board[newY][newX].getBoardType() * whiteOrBlack() > 0;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int curX() {
        return coordinates[0];
    }
    public int curY() {
        return coordinates[1];
    }

    public void drawCircle(int[] coordinates) {
        parent.fill(173, 216, 230);
        parent.ellipse(coordinates[0]+40, coordinates[1]+40, 15, 15);
    }

    public void deactivate(Board[][] b) {
        for (int[] pos : activatedPositions) {
            b[pos[0]][pos[1]].setActivated(false);
        }
    }

    public boolean pieceClickedOn() {
        return parent.mouseX > coordinates[0] && parent.mouseY > coordinates[1] && parent.mouseX < coordinates[0] + 80 && parent.mouseY < coordinates[1] + 80;
    }

    public void display() {
        parent.image(pieceIMG, coordinates[0], coordinates[1]);
    }
}
