package com.finaxys.finaxys_tennisgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTieBreakTest {

	TennisGame tennisGame = null;

	@Before
	public void setUp() {
		tennisGame = new TennisGame(new Player("Federer", new Score(0, 0, 0)), new Player("Nadal", new Score(0, 0, 0)));
		activateTieBreak();
	}

	private void haveASet(Player player1, Player player2, int setScore1, int setScore2) {

		tennisGame.winsPoint(player1);
		tennisGame.winsPoint(player1);
		tennisGame.winsPoint(player2);
		tennisGame.winsPoint(player1);
		tennisGame.winsPoint(player1);
		assertEquals(0, player1.getScore().getGameScore());
		assertEquals(0, player2.getScore().getGameScore());
		assertEquals(setScore1 + 1, player1.getScore().getSetScore());
		assertEquals(setScore2, player2.getScore().getSetScore());

	}

	private void activateTieBreak() {
		// 1 player1 win a game
		haveASet(tennisGame.getPlayer1(), tennisGame.getPlayer2(), tennisGame.getPlayer1().getScore().getSetScore(),
				tennisGame.getPlayer2().getScore().getSetScore());

		// 1 player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		// 2 player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		// 3 player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		// 4 player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		// 5 player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		// 2 player1 win a game
		haveASet(tennisGame.getPlayer1(), tennisGame.getPlayer2(), tennisGame.getPlayer1().getScore().getSetScore(),
				tennisGame.getPlayer2().getScore().getSetScore());

		// 3 player1 win a game
		haveASet(tennisGame.getPlayer1(), tennisGame.getPlayer2(), tennisGame.getPlayer1().getScore().getSetScore(),
				tennisGame.getPlayer2().getScore().getSetScore());

		// 4 player1 win a game
		haveASet(tennisGame.getPlayer1(), tennisGame.getPlayer2(), tennisGame.getPlayer1().getScore().getSetScore(),
				tennisGame.getPlayer2().getScore().getSetScore());

		// 5 player1 win a game
		haveASet(tennisGame.getPlayer1(), tennisGame.getPlayer2(), tennisGame.getPlayer1().getScore().getSetScore(),
				tennisGame.getPlayer2().getScore().getSetScore());

		// 6 player1 win a game
		haveASet(tennisGame.getPlayer1(), tennisGame.getPlayer2(), tennisGame.getPlayer1().getScore().getSetScore(),
				tennisGame.getPlayer2().getScore().getSetScore());

		// 6 player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());
	}

	@Test
	public void playerOneShouldReturnSetScore_6_and_playerTwoShouldReturnSetScore_6() {

		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

	}

	@Test
	public void playerOneWinTheTieBreakAndShouldReturnSetScore_7_and_playerTwoShouldReturnSetScore_6() {

		/********************************************************************************************/
		// this is a Tie Break
		assertEquals(0, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

		/********************************************************************************************/
		// 1 player1 win a point in the tie break
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(1, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

		/********************************************************************************************/
		// 1 player2 win a point in the tie break
		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(1, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(1, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

		/********************************************************************************************/
		// 2 player1 win a point in the tie break
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(2, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(1, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

		/********************************************************************************************/
		// 3 player1 win a point in the tie break
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(3, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(1, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

		/********************************************************************************************/
		// 2 player2 win a point in the tie break
		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(3, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(2, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

		/********************************************************************************************/
		// 4 player1 win a point in the tie break
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(4, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(2, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

		/********************************************************************************************/
		// 5 player1 win a point in the tie break
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(5, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(2, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

		/********************************************************************************************/
		// 6 player1 win a point in the tie break
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(6, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(2, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(6, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

		/********************************************************************************************/
		// 7 player1 win a point in the tie break
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(0, tennisGame.getPlayer1().getScore().getTieBreakScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getTieBreakScore());
		assertEquals(7, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getGameScore());

		// the player1 finally win the set and the game should be over
		assertTrue(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

		/********************************************************************************************/

	}
	
	@Test(expected = TennisGameException.class)
	public void theGameIsOverAndShouldExpectException() {
		playerOneWinTheTieBreakAndShouldReturnSetScore_7_and_playerTwoShouldReturnSetScore_6();
		//this game is over, we should expect an exception "TennisGameException"
		tennisGame.winsPoint(tennisGame.getPlayer1());
	}

}
