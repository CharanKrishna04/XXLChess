package XXLChess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//import static org.mockito.MockitoAnnotations.initMocks;

class WhiteAITest {

//    @Mock
    private App mockApp;

    private WhiteAI whiteAIUnderTest;

    @BeforeEach
    void setUp() {
//        initMocks(this);
        whiteAIUnderTest = new WhiteAI(mockApp, PieceColour.white);
    }

    @Test
    void testMinimax() {
        // Setup
        final App app = new App();
        final int[][] expectedResult = new int[][]{{0}};

        // Run the test
        final int[][] result = whiteAIUnderTest.minimax(app, 0, PieceColour.white);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testMove() {
        // Setup
        final App app = new App();

        // Run the test
        whiteAIUnderTest.move(app);

        // Verify the results
    }
}
