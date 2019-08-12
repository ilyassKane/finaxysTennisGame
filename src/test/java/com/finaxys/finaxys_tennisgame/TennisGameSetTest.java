package com.finaxys.finaxys_tennisgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TennisGameSetTest {
	TennisGame tennisGame = null;

	@Before
	public void setUp() {
		tennisGame = new TennisGame(new Player("Federer", new Score(0, 0, 0)), new Player("Nadal", new Score(0, 0, 0)));
	}

	private void haveASet(Player player1, Player player2, int setScore1, int setScore2) {

		// the first player win a point then the score is
		// ([player1 : 15]
		// [player2 : 0])
		tennisGame.winsPoint(player1);
		assertEquals(15, player1.getScore().getGameScore());
		assertEquals(0, player2.getScore().getGameScore());
		// the set score is (0,0)
		assertEquals(setScore1, player1.getScore().getSetScore());
		assertEquals(setScore2, player2.getScore().getSetScore());
		// the game is not won by anyone for now
		assertFalse(player1.isTheGameWon());
		assertFalse(player2.isTheGameWon());

		// the first player win again a point then the score is
		// ([player1 : 30]
		// [player2 : 0])
		tennisGame.winsPoint(player1);
		assertEquals(30, player1.getScore().getGameScore());
		assertEquals(0, player2.getScore().getGameScore());
		// the set score is (0,0)
		assertEquals(setScore1, player1.getScore().getSetScore());
		assertEquals(setScore2, player2.getScore().getSetScore());
		// the game is not won by anyone for now
		assertFalse(player1.isTheGameWon());
		assertFalse(player2.isTheGameWon());

		// the second player win a point then the score is
		// ([player1 : 30]
		// [player2 : 15])
		tennisGame.winsPoint(player2);
		assertEquals(30, player1.getScore().getGameScore());
		assertEquals(15, player2.getScore().getGameScore());
		// the set score is (0,0)
		assertEquals(setScore1, player1.getScore().getSetScore());
		assertEquals(setScore2, player2.getScore().getSetScore());
		// the game is not won by anyone for now
		assertFalse(player1.isTheGameWon());
		assertFalse(player2.isTheGameWon());

		// the first player win again a point then the score is
		// ([player1 : 40]
		// [player2 : 15])
		tennisGame.winsPoint(player1);
		assertEquals(40, player1.getScore().getGameScore());
		assertEquals(15, player2.getScore().getGameScore());
		// the set score is (0,0)
		assertEquals(setScore1, player1.getScore().getSetScore());
		assertEquals(setScore2, player2.getScore().getSetScore());
		// the game is not won by anyone for now
		assertFalse(player1.isTheGameWon());
		assertFalse(player2.isTheGameWon());

		// the first player win again a point then the score is
		// ([player1 : 0]
		// [player2 : 0])
		tennisGame.winsPoint(player1);
		assertEquals(0, player1.getScore().getGameScore());
		assertEquals(0, player2.getScore().getGameScore());
		// the player1 set score is incremented
		assertEquals(setScore1 + 1, player1.getScore().getSetScore());
		assertEquals(setScore2, player2.getScore().getSetScore());

	}

	@Test
	public void playerOneSetScoreShouldReturn_1_and_playerTwoShouldReturn_0() {
		// player1 win a game
		haveASet(tennisGame.getPlayer1(), tennisGame.getPlayer2(), tennisGame.getPlayer1().getScore().getSetScore(),
				tennisGame.getPlayer2().getScore().getSetScore());
		assertEquals(1, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(0, tennisGame.getPlayer2().getScore().getSetScore());

		// the set is won by anyone yet
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

	}

	@Test
	public void playerOneSetScoreShouldReturn_1_and_playerTwoShouldReturn_1() {

		// player1 win a game
		haveASet(tennisGame.getPlayer1(), tennisGame.getPlayer2(), tennisGame.getPlayer1().getScore().getSetScore(),
				tennisGame.getPlayer2().getScore().getSetScore());

		// player2 win a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		// each player has a game
		assertEquals(1, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(1, tennisGame.getPlayer2().getScore().getSetScore());
		
		// the set is won by anyone yet
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());

	}

	@Test
	public void playerTwoOneTheSetAndShouldReturn_6_and_playerTwoShouldReturn_1() {

		// player1 win a game
		haveASet(tennisGame.getPlayer1(), tennisGame.getPlayer2(), tennisGame.getPlayer1().getScore().getSetScore(),
				tennisGame.getPlayer2().getScore().getSetScore());
		
		/***************************************************************************************************************/
		// player2 win a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		// each player has a game
		assertEquals(1, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(1, tennisGame.getPlayer2().getScore().getSetScore());

		// the set is won by anyone yet
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());
		/***************************************************************************************************************/
		
		/***************************************************************************************************************/
		// player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		assertEquals(1, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(2, tennisGame.getPlayer2().getScore().getSetScore());

		// the set is won by anyone yet
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());
		/***************************************************************************************************************/
		
		/***************************************************************************************************************/
		// player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		assertEquals(1, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(3, tennisGame.getPlayer2().getScore().getSetScore());

		// the set is won by anyone yet
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());
		/***************************************************************************************************************/
		
		/***************************************************************************************************************/
		// player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		assertEquals(1, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(4, tennisGame.getPlayer2().getScore().getSetScore());

		// the set is won by anyone yet
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());
		/***************************************************************************************************************/
		
		/***************************************************************************************************************/
		// player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		assertEquals(1, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(5, tennisGame.getPlayer2().getScore().getSetScore());

		// the set is won by anyone yet
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertFalse(tennisGame.getPlayer2().isTheSetWon());
		/***************************************************************************************************************/
		
		/***************************************************************************************************************/
		// player2 win again a game
		haveASet(tennisGame.getPlayer2(), tennisGame.getPlayer1(), tennisGame.getPlayer2().getScore().getSetScore(),
				tennisGame.getPlayer1().getScore().getSetScore());

		assertEquals(1, tennisGame.getPlayer1().getScore().getSetScore());
		assertEquals(6, tennisGame.getPlayer2().getScore().getSetScore());

		// the set is finnally won by the second player
		assertFalse(tennisGame.getPlayer1().isTheSetWon());
		assertTrue(tennisGame.getPlayer2().isTheSetWon());
		/***************************************************************************************************************/
	}
}
