package XXLChess.Pieces;

import java.util.ArrayList;

import XXLChess.App;
import XXLChess.PieceColour;
import processing.core.PImage;

public class Pawn extends PieceMoves {

    public Pawn(PieceColour colour, PImage pieceSprite, int x, int y){
        super(colour, pieceSprite, x, y);
    }

    public void move(App app, int new_x, int new_y){
        app.board[this.x][this.y].setPiece(null);
        if(new_y == App.BOARD_WIDTH - 8 && this.colour == PieceColour.white){
            app.board[new_x][new_y].setPiece(new Queen(PieceColour.white, App.w_queen, new_x, new_y));
        }
        else if(new_y == 7 && this.colour == PieceColour.black){
            app.board[new_x][new_y].setPiece(new Queen(PieceColour.black, App.b_queen, new_x, new_y));
        }
        else{
            this.x = new_x;
            this.y = new_y;
            app.board[new_x][new_y].setPiece(this);
        }
    }

    public ArrayList<int[]> getAvailableMoves(App app){
        int direction;
        ArrayList<int[]> available_moves = new ArrayList<int[]>();
        if (this.colour == PieceColour.black) direction = 1;
        else direction = -1;
        if (app.Block_available(x, y+1*direction)){
            available_moves.add(new int[] {this.x,this.y+1*direction});
            if((this.y == 1 || this.y == 12) && (app.Block_available(this.x,this.y+2*direction))){
                available_moves.add(new int[] {this.x,this.y+2*direction});
            }
        }
        if (app.captured(this, x+1, y+1*direction)){
            available_moves.add(new int[] {x+1, y+1*direction});
        }
        if (app.captured(this, x-1, y+1*direction)){
            available_moves.add(new int[] {x-1, y+1*direction});
        }
        return available_moves;
    }

}