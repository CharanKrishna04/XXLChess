package XXLChess.Pieces;

import java.util.ArrayList;

import XXLChess.App;
import XXLChess.PieceColour;
import processing.core.PImage;


public abstract class PieceMoves {
    protected int x;
    protected int y;
    protected PieceColour colour;
    protected double value;
    protected PImage pieceSprite;
    protected boolean moved;

    public PieceMoves(PieceColour colour, PImage pieceSprite, int x, int y){
        this.pieceSprite = pieceSprite;
        this.x = x;
        this.y = y;
        this.value = value;
        this.colour = colour;
    }
    public double getValue(){

        return this.value;
    }
    public int[] getPosition(){
        int[] arr = {this.x, this.y};
        return arr;
    }

    public abstract ArrayList<int[]> getAvailableMoves(App app);

    public ArrayList<int[]> getAvailableCaptures(App app){
        ArrayList<int[]> available_captures = new ArrayList<int[]>();
        ArrayList<int[]> available_moves = this.getAvailableMoves(app);
        for(int[] move: available_moves){
            if (app.captured(this, move[0], move[1])){
                available_captures.add(new int[] {move[0], move[1]});
            }
        }
        return available_captures;
    }


    public void select(App app){
        ArrayList<int[]> legal_moves = this.getLegalMoves(app);
        for(int[] move : legal_moves){
            if (app.Block_available(move[0], move[1])) app.select_free_Block(move[0], move[1]);
            else app.select_blocked_Block(move[0], move[1]);
        }
    }


    public void move(App app, int X, int Y){
        app.board[this.x][this.y].setPiece(null);
        app.board[X][Y].setPiece(this);
        this.x = X;
        this.y = Y;
    }
    

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public PieceColour getColour(){
        return this.colour;
    }



    public void draw(App app){
        if (pieceSprite.width != App.BlockSIZE && pieceSprite.height != App.BlockSIZE){
            pieceSprite.resize(App.BlockSIZE, App.BlockSIZE);
        }
        app.image(pieceSprite, x*app.BlockSIZE, y*app.BlockSIZE);
    }


    protected ArrayList<int[]> getMovesRow(App app){
        ArrayList<int[]> available_moves = new ArrayList<int[]>();
        for(int x1 = this.x+1; x1 < app.BOARD_WIDTH; x1++){
            if (app.Block_available(x1, this.y)){
                available_moves.add(new int[] {x1, this.y});
            }
            else if(app.captured(this, x1, this.y)){
                available_moves.add(new int[] {x1, this.y});
                break;
            }
            else break;
        }
        for(int x1 = this.x-1; x1 >= 0; x1--){
            if (app.Block_available(x1, this.y)){
                available_moves.add(new int[] {x1, this.y});
            }
            else if(app.captured(this, x1, this.y)){
                available_moves.add(new int[] {x1, this.y});
                break;
            }
            else break;
        }
        return available_moves;
    }

    protected ArrayList<int[]> getMovesColumn(App app){
        ArrayList<int[]> available_moves = new ArrayList<int[]>();
        for(int y1 = this.y+1; y1 < app.BOARD_WIDTH; y1++){
            if (app.Block_available(this.x, y1)){
                available_moves.add(new int[] {this.x, y1});
            }
            else if(app.captured(this, this.x, y1)){
                available_moves.add(new int[] {this.x, y1});
                break;
            }
            else break;
        }
        for(int y1 = this.y-1; y1 >= 0; y1--){
            if (app.Block_available(this.x, y1)){
                available_moves.add(new int[] {this.x, y1});
            }
            else if(app.captured(this, this.x, y1)){
                available_moves.add(new int[] {this.x, y1});
                break;
            }
            else break;
        }
        return available_moves;
    }

    protected ArrayList<int[]> getMovesDiagonals(App app){
        ArrayList<int[]> available_moves = new ArrayList<int[]>();
        for(int i = 1; i <= app.BOARD_WIDTH; i++){
            if (app.Block_available(this.x + i, this.y + i)){
                available_moves.add(new int[] {this.x + i, this.y + i});
            }
            else if(app.captured(this, this.x + i, this.y + i)){
                available_moves.add(new int[] {this.x + i, this.y + i});
                break;
            }
            else
                break;
        }
        for(int i = 1; i <= app.BOARD_WIDTH; i++){
            if (app.Block_available(this.x - i, this.y + i)){
                available_moves.add(new int[]{this.x - i, this.y + i});
            }
            else if(app.captured(this, this.x - i, this.y + i)){
                available_moves.add(new int[] {this.x - i, this.y + i});
                break;
            }
            else
                break;
        }

        for(int i = 1; i <= app.BOARD_WIDTH; i++){
            if (app.Block_available(this.x + i, this.y - i)){
                available_moves.add(new int[] {this.x + i, this.y - i});
            }
            else if(app.captured(this, this.x + i, this.y - i)){
                available_moves.add(new int[] {this.x + i, this.y - i});
                break;
            }
            else
                break;
        }
        for(int i = 1; i <= app.BOARD_WIDTH; i++){
            if (app.Block_available(this.x - i, this.y - i)){
                available_moves.add(new int[] {this.x - i, this.y - i});
            }
            else if(app.captured(this, this.x - i, this.y - i)){
                available_moves.add(new int[] {this.x - i, this.y - i});
                break;
            }
            else break;
        }
        return available_moves;
    }
    protected ArrayList<int[]> getSpecialMoves(App app, int[][] possible_moves){
        ArrayList<int[]> available_moves = new ArrayList<int[]>();
        for (int i = 0; i < possible_moves.length; i++){
            int x1 = this.x + possible_moves[i][0];
            int y1 = this.y + possible_moves[i][1];
            if (app.Block_available(x1, y1) || app.captured( this, x1, y1)){
                available_moves.add(new int[] {x1, y1});
            }
        }
        return available_moves;
    }

    public ArrayList<int[]> getIllegalMoves(App app){
        ArrayList<int[]> illegal_moves = new ArrayList<int[]>();
        ArrayList<int[]> available_moves = this.getAvailableMoves(app);
        for (int[] move : available_moves){
            if(!app.isLegalMove(this, move[0], move[1])) illegal_moves.add(move);
        }
        return illegal_moves;
    }

    public ArrayList<int[]> getLegalMoves(App app){
        ArrayList<int[]> available_moves = getAvailableMoves(app);
        ArrayList<int[]> illegal_moves = getIllegalMoves(app); //new ArrayList<int[]>();
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for(int[] move : available_moves){
            moves.add(new int[] {move[0], move[1]});
            for(int[] illegal_move : illegal_moves){
                if (move[0] == illegal_move[0] && move[1] == illegal_move[1]){
                    moves.remove(moves.size() - 1);
                    break;
                }
            }
        }
        return moves;
    }


}