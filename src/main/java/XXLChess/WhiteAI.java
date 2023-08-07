package XXLChess;

import XXLChess.Pieces.PieceMoves;

import java.util.*;

public class WhiteAI {
    private PieceColour colour;
    private ArrayList<PieceMoves> available_pieces;
//    private int i = 0;


    public WhiteAI(App app, PieceColour colour){
        this.colour = colour;
        this.available_pieces = app.getPieces(this.colour);
    }

    public PieceColour getColour(){
        return this.colour;
    }

    public int[][] minimax(App app, int depth, PieceColour turn) {
        if (depth == 0 || app.isKingCheckMate(PieceColour.white) || app.isKingCheckMate(PieceColour.black)) {
            return null;
        }

        if (turn == PieceColour.white) {
            double best_score = -100000;//random negative number,worst possible score
            int[][] best_move = null;//best move not found
            ArrayList<PieceMoves> pieces = app.getPieces(turn);
            for(PieceMoves piece : pieces){
                ArrayList<int[]> moves = piece.getLegalMoves(app);
                for (int[] move : moves){
                    Block original_Block = new Block(app.board[move[0]][move[1]].getColour(), app.board[move[0]][move[1]].getPiece());
                    int[] position = piece.getPosition();
                    app.board[position[0]][position[1]].setPiece(null);
                    app.board[move[0]][move[1]].setPiece(piece);
                    piece.setPosition(move[0],move[1]);
                    int[][] opposite_best_move = minimax(app, depth - 1, PieceColour.black);
                    if (opposite_best_move != null){
                        int[] opposite_position = opposite_best_move[0];
                        int[] opposite_move = opposite_best_move[1];
                        Block opposite_original_Block = new Block(app.board[opposite_move[0]][opposite_move[1]].getColour(), app.board[opposite_move[0]][opposite_move[1]].getPiece());
                        PieceMoves opposite_piece = app.board[opposite_position[0]][opposite_position[1]].getPiece();

                        app.board[opposite_position[0]][opposite_position[1]].setPiece(null);
                        app.board[opposite_move[0]][opposite_move[1]].setPiece(opposite_piece);
                        opposite_piece.setPosition(opposite_move[0],opposite_move[1]);

                        double score = app.getPiecesMovementScore();
                        if (score > best_score){
                            best_score = score;
                            best_move = new int[][] {{position[0],position[1]}, {move[0],move[1]}};
                        }

                        app.board[opposite_position[0]][opposite_position[1]].setPiece(opposite_piece);
                        app.board[opposite_move[0]][opposite_move[1]] = opposite_original_Block;
                        opposite_piece.setPosition(opposite_position[0], opposite_position[1]);
                    }
                    else{
                        double score = app.getPiecesMovementScore();
                        if (score > best_score){
                            best_score = score;
                            best_move = new int[][] {{position[0],position[1]}, {move[0],move[1]}};
                        }
                    }


                    app.board[position[0]][position[1]].setPiece(piece);
                    app.board[move[0]][move[1]] = original_Block;
                    piece.setPosition(position[0], position[1]);
                }
            }

            return best_move;
        }
        else {
            double best_score = 100000;
            int[][] best_move = null;
            ArrayList<PieceMoves> pieces = app.getPieces(turn);
            for(PieceMoves piece : pieces){
                ArrayList<int[]> moves = piece.getLegalMoves(app);
                for (int[] move : moves){

                    Block original_Block = new Block(app.board[move[0]][move[1]].getColour(), app.board[move[0]][move[1]].getPiece());
                    int[] position = piece.getPosition();
                    app.board[position[0]][position[1]].setPiece(null);
                    app.board[move[0]][move[1]].setPiece(piece);
                    piece.setPosition(move[0],move[1]);
                    int[][] opposite_best_move = minimax(app, depth - 1, PieceColour.white);
                    if (opposite_best_move != null){
                        int[] opposite_position = opposite_best_move[0];
                        int[] opposite_move = opposite_best_move[1];
                        Block opposite_original_Block = new Block(app.board[opposite_move[0]][opposite_move[1]].getColour(), app.board[opposite_move[0]][opposite_move[1]].getPiece());
                        PieceMoves opposite_piece = app.board[opposite_position[0]][opposite_position[1]].getPiece();

                        app.board[opposite_position[0]][opposite_position[1]].setPiece(null);
                        app.board[opposite_move[0]][opposite_move[1]].setPiece(opposite_piece);
                        opposite_piece.setPosition(opposite_move[0],opposite_move[1]);

                        double score = app.getPiecesMovementScore();
                        if (score < best_score){
                            best_score = score;
                            best_move = new int[][] {{position[0],position[1]}, {move[0],move[1]}};
                        }

                        app.board[opposite_position[0]][opposite_position[1]].setPiece(opposite_piece);
                        app.board[opposite_move[0]][opposite_move[1]] = opposite_original_Block;
                        opposite_piece.setPosition(opposite_position[0], opposite_position[1]);
                    }
                    else{
                        double score = app.getPiecesMovementScore();
                        if (score < best_score){
                            best_score = score;
                            best_move = new int[][] {{position[0],position[1]}, {move[0],move[1]}};
                        }
                    }

                    app.board[position[0]][position[1]].setPiece(piece);
                    app.board[move[0]][move[1]] = original_Block;
                    piece.setPosition(position[0], position[1]);
                }
            }
            return best_move;
        }
    }

    public void move(App app){
        if (app.isCheck(app.turn)){
            PieceMoves king = app.getKing(app.turn);
            int[] position = king.getPosition();
            app.board[position[0]][position[1]].setColour(SelectedColour.RED);
        }
        int[][] min_max_move = minimax(app, 2, app.turn);
        PieceMoves piece = app.board[min_max_move[0][0]][min_max_move[0][1]].getPiece();
        app.last_move[0] = new int[] {piece.getPosition()[0],piece.getPosition()[1]};
        app.last_move[1] = new int[] {min_max_move[1][0], min_max_move[1][1]};
        piece.move(app, min_max_move[1][0], min_max_move[1][1]);
    }
}
