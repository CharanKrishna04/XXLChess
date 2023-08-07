package XXLChess.Pieces;

import java.util.ArrayList;

import XXLChess.App;
import XXLChess.PieceColour;
import processing.core.PImage;

public class King extends PieceMoves{
    public static final int[][] possible_moves = {{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0}};

    public King(PieceColour colour, PImage pieceSprite, int x, int y){
        super(colour, pieceSprite, x, y);
    }

    public void move(App app, int new_x, int new_y){
        moved = true;
        if(new_x - this.x >= 2){
            Rook rook = (Rook) app.board[App.BOARD_WIDTH -1][this.y].getPiece();
            rook.move(app, this.x+1, this.y);
        }
        if(this.x - new_x >= 2){
            Rook rook = (Rook) app.board[0][this.y].getPiece();
            rook.move(app, this.x-1, this.y);
        }
        app.board[this.x][this.y].setPiece(null);
        app.board[new_x][new_y].setPiece(this);
        this.x = new_x;
        this.y = new_y;
    }

    public ArrayList<int[]> getAvailableMoves(App app){
        ArrayList<int[]> available_moves = new ArrayList<int[]>();
        available_moves.addAll(this.getSpecialMoves(app, possible_moves));
        if(!this.moved){
            if (app.Block_available(this.x+2, this.y) && app.Block_available(this.x+1, this.y)){
                for(int i = this.x+1; i < App.BOARD_WIDTH; i++){
                    if (app.board[i][this.y].getPiece() instanceof Rook && !app.board[i][this.y].getPiece().moved){
                        available_moves.add(new int[] {this.x+2, this.y});
                    }
                }
            }
            if (app.Block_available(this.x-2, this.y) && app.Block_available(this.x-1, this.y)){
                for(int i=this.x-1; i >= 0; i--){
                    if (app.board[i][this.y].getPiece() instanceof Rook && !app.board[i][this.y].getPiece().moved){
                        available_moves.add(new int[] {this.x-2, this.y});
                    }
                }
            }
        }
        return available_moves;
    }
}