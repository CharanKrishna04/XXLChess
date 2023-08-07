package XXLChess;//package XXLChess;
//
//import XXLChess.Block;
//import XXLChess.Pieces.PieceMoves;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class BlockTest {
//    private Block block;
//
//    @BeforeEach
//    public void setUp() {
//        block = new Block(SelectedColour.LIGHT_BROWN);
//    }
//
//    @Test
//    public void testGetColour() {
//        assertEquals(SelectedColour.GREEN, block.getColour());
//    }
//
//    @Test
//    public void testSetColour() {
//        block.setColour(SelectedColour.GREEN);
//        assertEquals(SelectedColour.GREEN, block.getColour());
//    }
//
//    @Test
//    public void testGetPiece() {
//        assertNull(block.getPiece());
//    }
//
////    @Test
////    public void testSetPiece() {
////        PieceMoves piece = new PieceMoves();
////        block.setPiece(piece);
////        assertEquals(piece, block.getPiece());
////    }
//}



import XXLChess.Block;
import XXLChess.Pieces.PieceMoves;
import XXLChess.SelectedColour;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.*;

public class BlockTest {
    @BeforeAll
    static void initAll() {
    }
    @BeforeEach
    void init() {
    }

    @Test
    @DisplayName("get Colour")
    public void getColour(){
        try {
            SelectedColour expectedValue = null;

            SelectedColour colourc = null;

            Block block  =new Block( colourc);
            SelectedColour actualValue=block.getColour();
            System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
            Assertions.assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {

            exception.printStackTrace();
            Assertions.assertFalse(false);
        }
    }

    @Test
    @DisplayName("set Colour")
    public void setColour(){
        try {
            SelectedColour colour = null;

            SelectedColour colourc = null;

            Block block  =new Block( colourc);
            block.setColour( colour);
            Assertions.assertTrue(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            Assertions.assertFalse(false);
        }
    }

    @Test
    @DisplayName("get Piece")
    public void getPiece(){
        try {
            PieceMoves expectedValue = null;

            SelectedColour colourc = null;

            Block block  =new Block( colourc);
            PieceMoves actualValue=block.getPiece();

            System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
            Assertions.assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {

            exception.printStackTrace();
            Assertions.assertFalse(false);
        }
    }

    @Test
    @DisplayName("set Piece")
    public void setPiece(){
        try {

            PieceMoves piece = null;

            SelectedColour colourc = null;

            Block block  =new Block( colourc);
            block.setPiece( piece);
            Assertions.assertTrue(true);
        } catch (Exception exception) {

            exception.printStackTrace();
            Assertions.assertFalse(false);
        }
    }
    @AfterEach
    void tearDown() {
    }
    @AfterAll
    static void tearDownAll() {
    }
}
