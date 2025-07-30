import processing.core.PApplet;
import processing.core.PImage;

public class Pawn extends Piece {
    private int timesPlayed;
    public Pawn(boolean isWhite, int[] coordinates, PApplet p, PImage white_P_IMG, PImage black_P_Image, int type) {
        super(isWhite, coordinates, p, white_P_IMG, black_P_Image, type);
        pieceVal = 1;
    }


    public void displayMoves(Board[][] b) {
        displayMoveOne(b);
        displayDoubleJump(b);
        displayCaptureLeft(b);
        displayCaptureRight(b);
    }

    public void move(Board[][] board) {

    }
    public void displayMoveOne(Board[][] b) {
        int[] activatedPos = new int[2];
        if (b[pos[0]][pos[1] + getPieceType()].getBoardType() == 0 && this.isActivated()) {
            b[pos[0]][pos[1] + getPieceType()].setActivated(true);
            activatedPos[0] = pos[0];
            activatedPos[1] = pos[1] + getPieceType();
            activatedPositions.add(activatedPos);
        }
    }

    public void displayDoubleJump(Board[][] b) {
        int[] activatedPos = new int[2];
        if (b[pos[0]][pos[1] + getPieceType()].getBoardType() == 0 && b[pos[0]][pos[1] + getPieceType()*2].getBoardType() == 0 && timesPlayed == 0 && this.isActivated()) {
            b[pos[0]][pos[1] + getPieceType() * 2].setActivated(true);
            activatedPos[0] = pos[0];
            activatedPos[1] = pos[1] + getPieceType() * 2;
            activatedPositions.add(activatedPos);
        }
    }

    public void displayCaptureLeft(Board[][] b) {
        int[] activatedPos = new int[2];
        if (b[pos[0]][pos[1]].getBoardType()*getPieceType() > b[pos[0] + getPieceType()][pos[1] + getPieceType()].getBoardType()*getPieceType() && isActivated()) {
            b[pos[0] + getPieceType()][pos[1] + getPieceType()].setActivated(true);
            activatedPos[0] = pos[0] + getPieceType();
            activatedPos[1] = pos[1] + getPieceType();
            activatedPositions.add(activatedPos);
        }
    }

    public void displayCaptureRight(Board[][] b) {
        int[] activatedPos = new int[2];
        if (b[pos[0]][pos[1]].getBoardType()*getPieceType() > b[pos[0] - getPieceType()][pos[1] + getPieceType()].getBoardType()*getPieceType() && isActivated()) {
            b[pos[0] - getPieceType()][pos[1] + getPieceType()].setActivated(true);
            activatedPos[0] = pos[0] - getPieceType();
            activatedPos[1] = (pos[1] + getPieceType());
            activatedPositions.add(activatedPos);
        }
    }
}
