package XXLChess.Pieces;

import XXLChess.App;
import XXLChess.PieceColour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
import processing.core.PImage;

import java.util.ArrayList;

//import static org.mockito.MockitoAnnotations.initMocks;

class RookTest {

//    @Mock
    private PImage mockPieceSprite;

    private Rook rookUnderTest;

    @BeforeEach
    void setUp() throws Exception {
//        initMocks(this);
        rookUnderTest = new Rook(PieceColour.white, mockPieceSprite, 0, 0);
    }

    @Test
    void testMove() {
        // Setup
        final App app = new App();

        // Run the test
        rookUnderTest.move(app, 0, 0);

        // Verify the results
    }

    @Test
    void testGetAvailableMoves() throws Exception {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = rookUnderTest.getAvailableMoves(app);

        // Verify the results
    }
}
