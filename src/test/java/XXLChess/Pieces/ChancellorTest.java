package XXLChess.Pieces;

import XXLChess.App;
import XXLChess.PieceColour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
import processing.core.PImage;

import java.util.ArrayList;

//import static org.mockito.MockitoAnnotations.initMocks;

class ChancellorTest {

//    @Mock
    private PImage mockPieceSprite;

    private Chancellor chancellorUnderTest;

    @BeforeEach
    void setUp() {
//        initMocks(this);
        chancellorUnderTest = new Chancellor(PieceColour.white, mockPieceSprite, 0, 0);
    }

    @Test
    void testGetAvailableMoves() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = chancellorUnderTest.getAvailableMoves(app);

        // Verify the results
    }
}
