package XXLChess.Pieces;

import XXLChess.App;
import XXLChess.PieceColour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
import processing.core.PImage;

import java.util.ArrayList;

//import static org.mockito.MockitoAnnotations.initMocks;

class ArchbishopTest {

//    @Mock
    private PImage mockPieceSprite;

    private Archbishop archbishopUnderTest;

    @BeforeEach
    void setUp() {
//        initMocks(this);
        archbishopUnderTest = new Archbishop(PieceColour.white, mockPieceSprite, 0, 0);
    }

    @Test
    void testGetAvailableMoves() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = archbishopUnderTest.getAvailableMoves(app);

        // Verify the results
    }
}
