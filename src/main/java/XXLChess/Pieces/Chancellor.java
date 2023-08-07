package XXLChess.Pieces;

import java.util.ArrayList;

import XXLChess.App;
import XXLChess.PieceColour;
import processing.core.PImage;

public class Chancellor extends PieceMoves{
    public Chancellor(PieceColour colour, PImage pieceSprite, int x, int y){
        super(colour, pieceSprite, x, y);
    }
    public ArrayList<int[]> getAvailableMoves(App app){
        ArrayList<int[]> available_moves = new ArrayList<int[]>();
        available_moves.addAll(this.getSpecialMoves(app, Knight.possible_moves));
        available_moves.addAll(this.getMovesRow(app));
        available_moves.addAll(this.getMovesColumn(app));
        return available_moves;
    }
}
