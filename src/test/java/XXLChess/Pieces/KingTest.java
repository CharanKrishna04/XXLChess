package XXLChess.Pieces;

import XXLChess.App;
import XXLChess.PieceColour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
import processing.core.PImage;

import java.util.ArrayList;

//import static org.mockito.MockitoAnnotations.initMocks;

class KingTest {

//    @Mock
    private PImage mockPieceSprite;

    private King kingUnderTest;

    @BeforeEach
    void setUp() throws Exception {
//        initMocks(this);
        kingUnderTest = new King(PieceColour.white, mockPieceSprite, 0, 0);
    }

    @Test
    void testMove() {
        // Setup
        final App app = new App();

        // Run the test
        kingUnderTest.move(app, 0, 0);

        // Verify the results
    }

    @Test
    void testGetAvailableMoves() throws Exception {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = kingUnderTest.getAvailableMoves(app);

        // Verify the results
    }
}
