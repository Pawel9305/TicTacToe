package com.game.tictactoegame;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Suite for Game Engine")
class GameEngineTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Checking board tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void testCheckHorizontallyOWins() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{"O", "O", "O"}, {"X", "X", " "}, {" ", " ", " "}};

        //When
        int result = gameEngine.checkHorizontally(board);

        //Then
        assertEquals(2, result);
    }

    @Test
    void testCheckVerticallyOWins() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{" ", "X", "O"}, {"X", " ", "O"}, {"X", " ", "O"}};

        //When
        int result = gameEngine.checkVertically(board);

        //Then
        assertEquals(2, result);
    }

    @Test
    void testCheckCrossOWins() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{"O", " ", "X"}, {"X", "O", " "}, {"X", " ", "O"}};

        //When
        int result = gameEngine.checkCross(board);

        //Then
        assertEquals(2, result);
    }

    @Test
    void testCheckReversedCrossOWins() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{"X", " ", "O"}, {"X", "O", " "}, {"O", " ", "X"}};

        //When
        int result = gameEngine.checkReversedCross(board);

        //Then
        assertEquals(2, result);
    }

    @Test
    void testCheckHorizontallyXWins() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{"O", " ", " "}, {"X", "X", "X"}, {"O", " ", " "}};

        //When
        int result = gameEngine.checkHorizontally(board);

        //Then
        assertEquals(1, result);
    }

    @Test
    void testCheckVerticallyXWins() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{" ", "X", " "}, {"O", "X", " "}, {"O", "X", " "}};

        //When
        int result = gameEngine.checkVertically(board);

        //Then
        assertEquals(1, result);
    }

    @Test
    void testCheckCrossXWins() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{"X", "O", " "}, {" ", "X", "O"}, {" ", " ", "X"}};

        //When
        int result = gameEngine.checkCross(board);

        //Then
        assertEquals(1, result);
    }

    @Test
    void testCheckReversedCrossXWins() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{"O", " ", "X"}, {" ", "X", "O"}, {"X", " ", " "}};

        //When
        int result = gameEngine.checkReversedCross(board);

        //Then
        assertEquals(1, result);
    }

    @Test
    void testIsDrawReturnsTrue() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{"O", "X", "O"}, {"X", "O", "X"}, {"X", "O", "X"}};

        //When
        boolean isDraw = gameEngine.isDraw(board);

        //Then
        assertTrue(isDraw);
    }

    @Test
    void testIsDrawReturnsFalse() {
        //Given
        GameEngine gameEngine = new GameEngine();
        String[][] board = {{"O", "X", "O"}, {"O", "X", " "}, {" ", "X", " "}};

        //When
        boolean isDraw = gameEngine.isDraw(board);

        //Then
        assertFalse(isDraw);
    }
}
