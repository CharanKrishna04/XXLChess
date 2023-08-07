package XXLChess.Pieces;

import java.util.ArrayList;

import XXLChess.App;
import XXLChess.PieceColour;
import processing.core.PImage;

public class Camel extends PieceMoves{
    public static int[][] possible_moves = {{3,1},{-3,1},{-3,-1},{3,-1},{1,3},{-1,3},{-1,-3},{1,-3}};
    public Camel(PieceColour colour, PImage pieceSprite, int x, int y){
        super(colour, pieceSprite, x, y);
    }
    public ArrayList<int[]> getAvailableMoves(App app){
        ArrayList<int[]> available_moves = new ArrayList<int[]>();
        available_moves.addAll(this.getSpecialMoves(app, possible_moves));
        return available_moves;
    }
}
