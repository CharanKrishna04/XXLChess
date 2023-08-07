package XXLChess;

import XXLChess.Clock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 public class ClockTest {
    private Clock clock;

    @BeforeEach
    public void setUp() {
        // Create a new Clock instance before each test
        clock = new Clock(10, 0, 5); // 10 minutes, 0 seconds, 5 seconds increment
    }

    @Test
    public void testStart() {
        assertFalse(clock.isRunning()); // Clock should not be running initially

        clock.start();
        assertTrue(clock.isRunning()); // Clock should be running after starting
    }

    @Test
    public void testStop() throws InterruptedException {
        clock.start();
        Thread.sleep(1000); // Sleep for 1 second

        clock.stop();
        assertFalse(clock.isRunning()); // Clock should stop running after stopping

        // Check if elapsed time is within an acceptable range (within 1 second of expected time)
        long elapsedTime = clock.getTime();
        assertTrue(elapsedTime >= 9 && elapsedTime <= 11);
    }

    @Test
    public void testFinish() throws InterruptedException {
        clock.start();
        Thread.sleep(1000); // Sleep for 1 second

        clock.finish();
        assertFalse(clock.isRunning()); // Clock should stop running after finishing

        // Check if elapsed time is within an acceptable range (within 1 second of expected time)
        long elapsedTime = clock.getTime();
        assertTrue(elapsedTime >= 9 && elapsedTime <= 11);
    }

    @Test
    public void testGetTime() throws InterruptedException {
        assertEquals(600, clock.getTime()); // Initial time should be 10 minutes (600 seconds)

        clock.start();
        Thread.sleep(3000); // Sleep for 3 seconds

        long elapsedTime = clock.getTime();
        assertTrue(elapsedTime >= 597 && elapsedTime <= 603); // Elapsed time should be within 3 seconds of 597-603

        clock.stop();
        Thread.sleep(1000); // Sleep for 1 second after stopping

        elapsedTime = clock.getTime();
        assertTrue(elapsedTime >= 596 && elapsedTime <= 604); // Elapsed time should be within 3 seconds of 596-604
    }

    @Test
    public void testIsRunning() {
        assertFalse(clock.isRunning()); // Clock should not be running initially

        clock.start();
        assertTrue(clock.isRunning()); // Clock should be running after starting

        clock.stop();
        assertFalse(clock.isRunning()); // Clock should not be running after stopping

        clock.finish();
        assertFalse(clock.isRunning()); // Clock should not be running after finishing
    }
}
