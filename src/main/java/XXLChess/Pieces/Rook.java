package XXLChess.Pieces;

import java.util.ArrayList;

import XXLChess.App;
import XXLChess.PieceColour;
import processing.core.PImage;

public class Rook extends PieceMoves{

    public Rook(PieceColour colour, PImage pieceSprite, int x, int y){
        super(colour, pieceSprite, x, y);
    }

    public void move(App app, int new_x, int new_y){
        moved = true;
        app.board[this.x][this.y].setPiece(null);
        app.board[new_x][new_y].setPiece(this);
        this.x = new_x;
        this.y = new_y;
    }

    public ArrayList<int[]> getAvailableMoves(App app){
        ArrayList<int[]> available_moves = new ArrayList<>();
        available_moves.addAll(getMovesRow(app));
        available_moves.addAll(getMovesColumn(app));
        return available_moves;
    }
}
