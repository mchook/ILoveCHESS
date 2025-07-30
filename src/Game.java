import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Arrays;

public class Game extends PApplet {
    // TODO: declare game variables;
    PImage img_black_pawn;
    PImage img_white_pawn;
    ArrayList<Piece> whitePieces;
    ArrayList<Piece> blackPieces;
    Board[][] board = new Board[8][8];
    boolean isWhite = true;
    int moveCounter = 0;
    boolean activated = false;
    public void settings() {
        size(800, 800);   // set the window size
    }

    public void setup() {
        background(255);
        setCoordinates();
        drawBoard();
        img_black_pawn = loadImage("images/black_pawn.png");
        img_white_pawn = loadImage("images/white_pawn.png");
        whitePieces = setWhitePieces();
        blackPieces = setBlackPieces();
        drawPieces();
    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
        background(255);
        drawBoard();
        drawPieces();
        drawActivatedCircles();
        mouseReleased();
    }

    public static void main(String[] args) {
        PApplet.main("Game");
    }
// Need to add other pieces later
    public ArrayList<Piece> setWhitePieces() {
        ArrayList<Piece> Pieces = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            Pawn p = new Pawn(true, board[i-1][1].getCoordinates(),this, img_white_pawn, img_black_pawn, i);
            Pieces.add(p);
        }
        return Pieces;
    }
    public ArrayList<Piece> setBlackPieces() {
        ArrayList<Piece> Pieces = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            Pawn p = new Pawn(false, board[i-1][6].getCoordinates(),this, img_white_pawn, img_black_pawn, i);
            Pieces.add(p);
        }
        return Pieces;
    }
    public void setCoordinates() {
        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board.length; j++) {
                int[] coordinates = {j, i};
                System.out.println(Arrays.toString(coordinates));
                Board b = new Board(coordinates, this);
                System.out.println(Arrays.toString(b.getCoordinates()));
                board[i-1][j-1] = b;
            }
        }
    }
    public void drawBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <= board.length; j+=2) {
                if (j != 8) {
                    int[] coordinates = board[i][j].getCoordinates();
                    if (i % 2 == 0) {
                        fill(118, 150, 86);
                        rect(coordinates[0], coordinates[1], 80, 80);
                        if (j > 0) {
                            coordinates = board[i][j - 1].getCoordinates();
                            fill(238, 238, 210);
                            rect(coordinates[0], coordinates[1], 80, 80);
                        }
                    } else {
                        fill(238, 238, 210);
                        rect(coordinates[0], coordinates[1], 80, 80);
                        if (j > 0) {
                            coordinates = board[i][j - 1].getCoordinates();
                            fill(118, 150, 86);
                            rect(coordinates[0], coordinates[1], 80, 80);
                        }
                    }
                } else {
                    j--;
                    int[] coordinates = board[i][j].getCoordinates();
                    if(i%2 == 0) {
                        fill(238, 238, 210);
                        rect(coordinates[0], coordinates[1], 80, 80);
                    } else {
                        fill(118, 150, 86);
                        rect(coordinates[0], coordinates[1], 80, 80);
                    }
                }
            }
        }
    }

    public void drawActivatedCircles() {
        for (Board[] boards : board) {
            for (int j = 0; j < board.length; j++) {
                boards[j].drawCircle();
            }
        }
    }
//Need to add capturing, incomplete
    public void mouseReleased() {
        if(moveCounter%2 == 0) {

        } else {

        }
    }

    public void drawPieces() {
        for (int i = 0; i < blackPieces.size(); i++) {
            blackPieces.get(i).display();
            whitePieces.get(i).display();
        }
    }
}
