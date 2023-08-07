package XXLChess;

import XXLChess.Pieces.PieceMoves;

public class Block {
    private SelectedColour colour;
    private PieceMoves piece;

    public Block(SelectedColour colour,PieceMoves piece){
        this.colour = colour;
        this.piece = piece;
    }
    
    public Block(SelectedColour colour){
        this.colour = colour;
    }

    public SelectedColour getColour(){
        return this.colour;
    }

    public void setColour(SelectedColour colour){
        this.colour = colour;
    }

    public PieceMoves getPiece(){
        return this.piece; 
    }

    public void setPiece(PieceMoves piece){
        this.piece = piece;
    }
}
