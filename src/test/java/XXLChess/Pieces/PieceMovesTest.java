package XXLChess.Pieces;

import XXLChess.App;
import XXLChess.PieceColour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
import processing.core.PImage;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.MockitoAnnotations.initMocks;

class PieceMovesTest {

//    @Mock
    private PImage mockPieceSprite;

    private PieceMoves pieceMovesUnderTest;

    @BeforeEach
    void setUp() {
//        initMocks(this);
        pieceMovesUnderTest = new PieceMoves(PieceColour.white,mockPieceSprite,0,0) {
            @Override
            public ArrayList<int[]> getAvailableMoves(App app) {
                return null;
            }
        };
    }

    @Test
    void testGetPosition() {
        assertArrayEquals(new int[]{0}, pieceMovesUnderTest.getPosition());
    }

    @Test
    void testGetAvailableCaptures() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = pieceMovesUnderTest.getAvailableCaptures(app);

        // Verify the results
    }

    @Test
    void testSelect() {
        // Setup
        final App app = new App();

        // Run the test
        pieceMovesUnderTest.select(app);

        // Verify the results
    }

    @Test
    void testMove() {
        // Setup
        final App app = new App();

        // Run the test
        pieceMovesUnderTest.move(app, 0, 0);

        // Verify the results
    }

    @Test
    void testSetPosition() {
        // Setup
        // Run the test
        pieceMovesUnderTest.setPosition(0, 0);

        // Verify the results
    }

    @Test
    void testDraw() {
        // Setup
        final App app = new App();

        // Run the test
        pieceMovesUnderTest.draw(app);

        // Verify the results
//        verify(mockPieceSprite).resize(48, 48);
    }

    @Test
    void testGetMovesRow() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = pieceMovesUnderTest.getMovesRow(app);

        // Verify the results
    }

    @Test
    void testGetMovesColumn() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = pieceMovesUnderTest.getMovesColumn(app);

        // Verify the results
    }

    @Test
    void testGetMovesDiagonals() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = pieceMovesUnderTest.getMovesDiagonals(app);

        // Verify the results
    }

    @Test
    void testGetSpecialMoves() {
        // Setup
        final App app = new App();
        final int[][] possible_moves = new int[][]{{0}};

        // Run the test
        final ArrayList<int[]> result = pieceMovesUnderTest.getSpecialMoves(app, possible_moves);

        // Verify the results
    }

    @Test
    void testGetIllegalMoves() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = pieceMovesUnderTest.getIllegalMoves(app);

        // Verify the results
    }

    @Test
    void testGetLegalMoves() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = pieceMovesUnderTest.getLegalMoves(app);

        // Verify the results
    }
}
