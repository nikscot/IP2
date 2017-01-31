package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	private TicTacToe model;
	
	@Before
    public void setUp() {
        model = new TicTacToe();
    }
	
	@Test
	public void testInitialBoardIsEmpty() {
		for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
				//Mark m = model.getMark(row, col);
                assertEquals(TicTacToe.Mark.EMPTY, model.getMark(row, col));
            }
        }
		//assertTrue(false);
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		model.setMark(0, 2);
        assertEquals(TicTacToe.Mark.X, model.getMark(0, 2));
		//assertTrue(false);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		model.setMark(0, 2);
        model.setMark(2, 0);
        assertEquals(TicTacToe.Mark.O, model.getMark(2, 0));
		//assertTrue(false);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		model.setMark(0, 2);
        assertEquals(TicTacToe.Mark.X, model.getMark(0, 2));
        model.setMark(0, 2);
        assertEquals(TicTacToe.Mark.X, model.getMark(0, 2));
        model.setMark(2, 0);
        assertEquals(TicTacToe.Mark.O, model.getMark(2, 0));
		//assertTrue(false);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		model.setMark(0, 2);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
		//assertTrue(false);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		model.setMark(0, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(1, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(0, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(1, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(0, 2);
        assertEquals(TicTacToe.Result.XWINS, model.getResult());
		//assertTrue(false);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		model.setMark(0, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(0, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(0, 2);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(2, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(2, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(2, 2);
        model.setMark(1, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(1, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMark(1, 2);
        assertEquals(TicTacToe.Result.TIE, model.getResult());
		//assertTrue(false);
	}	
}
