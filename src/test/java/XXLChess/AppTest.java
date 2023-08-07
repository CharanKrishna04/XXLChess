
package XXLChess;

import XXLChess.Pieces.King;
import XXLChess.Pieces.PieceMoves;
import XXLChess.Pieces.Queen;
import XXLChess.Pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private App appUnderTest;

    @BeforeEach
    void setUp() {
        appUnderTest = new App();
    }

    @Test
    void testMain() {
        // Setup
        // Run the test
        App.main(new String[]{"args"});

        // Verify the results
    }

    @Test
    void testSettings() {
        // Setup
        // Run the test
        appUnderTest.settings();

        // Verify the results
    }

    @Test
    void testBringBoard() {
        // Setup
        // Run the test
        appUnderTest.bringBoard("file_name");

        // Verify the results
    }

    @Test
    void testSetup() {
        // Setup
        // Run the test
        appUnderTest.setup();

        // Verify the results
    }

    @Test
    void testKeyPressed() {
        // Setup
        final KeyEvent key = new KeyEvent("nativeObject", 0L, 0, 0, 'a', 0, false);

        // Run the test
        appUnderTest.keyPressed(key);

        // Verify the results
    }

    @Test
    void testKeyReleased() {
        appUnderTest.keyReleased();
    }

    @Test
    void testMouseClicked() {
        // Setup
        final MouseEvent e = new MouseEvent("nativeObject", 0L, 0, 0, 0, 0, 0, 0);

        // Run the test
        appUnderTest.mouseClicked(e);

        // Verify the results
    }

    @Test
    void testMouseDragged() {
        // Setup
        final MouseEvent e = new MouseEvent("nativeObject", 0L, 0, 0, 0, 0, 0, 0);

        // Run the test
        appUnderTest.mouseDragged(e);

        // Verify the results
    }

    @Test
    void testDraw() {
        // Setup
        // Run the test
        appUnderTest.draw();

        // Verify the results
    }

    @Test
    void testGetKing1() {
        // Setup
        final Block[][] board = new Block[][]{{new Block(SelectedColour.LIGHT_BLUE, null)}};

        // Run the test
        final PieceMoves result = appUnderTest.getKing(board, PieceColour.white);

        // Verify the results
    }

    @Test
    void testUpdate_time() {
        // Setup
        final Clock Clock_white = new Clock(0, 0, 0);
        final Clock Clock_black = new Clock(0, 0, 0);

        // Run the test
        appUnderTest.update_time(Clock_white, Clock_black, PieceColour.white);

        // Verify the results
    }

    @Test
    void testGetPiecesMovementScore() {
        assertEquals(0.0, appUnderTest.getPiecesMovementScore(), 0.0001);
    }

    @Test
    void testDisplay_time() {
        // Setup
        final Clock Clock_white = new Clock(0, 0, 0);
        final Clock Clock_black = new Clock(0, 0, 0);

        // Run the test
        appUnderTest.display_time(Clock_white, Clock_black, PieceColour.white);

        // Verify the results
    }

    @Test
    void testGetKing2() {
        // Setup
        // Run the test
        final PieceMoves result = appUnderTest.getKing(PieceColour.white);

        // Verify the results
    }

    @Test
    void testIsCheck1() {
        assertFalse(appUnderTest.isCheck(PieceColour.white));
    }

    @Test
    void testIsCheck2() {
        assertFalse(appUnderTest.isCheck());
    }

    @Test
    void testGetPieces1() {
        // Setup
        // Run the test
        final ArrayList<PieceMoves> result = appUnderTest.getPieces(PieceColour.white);

        // Verify the results
    }

    @Test
    void testGetPieces2() {
        // Setup
        final Block[][] board = new Block[][]{{new Block(SelectedColour.LIGHT_BLUE, null)}};

        // Run the test
        final ArrayList<PieceMoves> result = appUnderTest.getPieces(board, PieceColour.white);

        // Verify the results
    }

    @Test
    void testGetPiecesCheckmate() {
        // Setup
        // Run the test
        final ArrayList<PieceMoves> result = appUnderTest.getPiecesCheckmate();
        // Verify the results
    }

    @Test
    void testIsLegalMove() {
        // Setup
        final PieceMoves piece = null;

        // Run the test
        final boolean result = appUnderTest.isLegalMove(piece, 0, 0);

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testReset_colour() {
        // Setup
        // Run the test
        appUnderTest.reset_colour();

        // Verify the results
    }

    @Test
    void testIsKingCheckMate1() {
        assertFalse(appUnderTest.isKingCheckMate(PieceColour.white));
    }

    @Test
    void testIsKingCheckMate2() {
        assertFalse(appUnderTest.isKingCheckMate());
    }

    @Test
    void testDraw_board() {
        // Setup
        // Run the test
        appUnderTest.draw_board();

        // Verify the results
    }

    @Test
    void testSelect_current_piece() {
        // Setup
        // Run the test
        appUnderTest.select_current_piece(0, 0);

        // Verify the results

    }

    @Test
    void testSelect_free_Block() {
        // Setup
        // Run the test
        appUnderTest.select_free_Block(0, 0);

        // Verify the results
    }

    @Test
    void testDraw_move() {
        // Setup
        // Run the test
        appUnderTest.draw_move(0, 0, 0, 0);

        // Verify the results
    }

    @Test
    void testSelect_blocked_Block() {
        // Setup
        // Run the test
        appUnderTest.select_blocked_Block(0, 0);
        int x=2;
        int y=3;
        Block[][] board = new Block[14][14];
        // Verify the results
      Assertions.assertEquals(SelectedColour.ORANGE,board[x][y].getColour());
    }

    @Test
    void testcaptured() {
        // Setup
        final PieceMoves piece = null;

        // Run the test
        final boolean result = appUnderTest.captured(piece, 0, 0);

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testBlock_available() {
        assertFalse(appUnderTest.Block_available(0, 0));
    }

    @Test
    void testChangeTurn() {
        // Setup
        // Run the test
        appUnderTest.ChangeTurn();

        // Verify the results

        assertEquals(PieceColour.white, appUnderTest.turn);
    }
    @Test
    public void testDraw_resigned() {
        appUnderTest.resigned = true;
        appUnderTest.draw();
        // Assert that the game displays the "Player Resigned! AI WON!" message
        // You may need to update the expected coordinates based on your implementation
        assertEquals("Player Resigned!AI WON!", appUnderTest.get(120, 360));
    }

    @Test
    public void testDraw_timeout() {
        appUnderTest.Clock_black.getTime();
        appUnderTest.draw();
        // Assert that the game displays the "Stop! Timeout!" message
        // You may need to update the expected coordinates based on your implementation
        assertEquals("Stop! Timeout!", appUnderTest.get(120, 360));
    }

    @Test
    public void testDraw_checkmate() {
        // Simulate a checkmate scenario
        // ...

        appUnderTest.draw();
        // Assert that the game displays the "Checkmate" message
        // You may need to update the expected coordinates based on your implementation
        assertEquals("Checkmate", appUnderTest.get(200, 360));
    }

    @Test
    public void testDraw_playerTurn() {
        // Simulate a scenario where it's the player's turn
        // ...

        appUnderTest.draw();
        // Assert that the game behaves as expected for the player's turn
        // ...
    }

    @Test
    public void testDraw_noMessage() {
        appUnderTest.draw();
        // Assert that no message is displayed on the screen
        // You may need to update the expected coordinates based on your implementation
        assertNull(appUnderTest.get(120, 360));
    }


}
