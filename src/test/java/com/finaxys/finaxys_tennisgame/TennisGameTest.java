package com.finaxys.finaxys_tennisgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
	TennisGame tennisGame = null;

	@Before
	public void setUp() {
		tennisGame = new TennisGame(new Player("Federer", new Score(0, 0, 0)), new Player("Nadal", new Score(0, 0, 0)));
	}

	@Test
	public void playerOneScoreGameShouldReturn_0_and_playerTworeturn_0() {

		// the first player win the a then the score is
		// ([player1 : 15]
		// [player2 : 0])
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(15), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(0), tennisGame.getPlayer2().getScore().getGameScore());
		// the game is not win by anyone for now
		assertFalse(tennisGame.getPlayer1().isTheGameWon());
		assertFalse(tennisGame.getPlayer2().isTheGameWon());

		// the first player win again a point then the score is
		// ([player1 : 30]
		// [player2 : 0])
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(30), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(0), tennisGame.getPlayer2().getScore().getGameScore());
		// the game is not won by anyone for now
		assertFalse(tennisGame.getPlayer1().isTheGameWon());
		assertFalse(tennisGame.getPlayer2().isTheGameWon());

		// the second player win a point then the score is
		// ([player1 : 30]
		// [player2 : 15])
		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(Integer.valueOf(30), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(15), tennisGame.getPlayer2().getScore().getGameScore());
		// the game is not won by anyone for now
		assertFalse(tennisGame.getPlayer1().isTheGameWon());
		assertFalse(tennisGame.getPlayer2().isTheGameWon());

		// the first player win again a point then the score is
		// ([player1 : 40]
		// [player2 : 15])
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(15), tennisGame.getPlayer2().getScore().getGameScore());
		// the game is not won by anyone for now
		assertFalse(tennisGame.getPlayer1().isTheGameWon());
		assertFalse(tennisGame.getPlayer2().isTheGameWon());

		// the second player win again a point then the score is
		// ([player1 : 40] /
		// [player2 : 30])
		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(30), tennisGame.getPlayer2().getScore().getGameScore());
		// the game is not won by anyone for now
		assertFalse(tennisGame.getPlayer1().isTheGameWon());
		assertFalse(tennisGame.getPlayer2().isTheGameWon());

		// the first player win again a point and won the game then the score is
		// ([player1 : 0] /
		// [player2 : 0]),
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(0), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(0), tennisGame.getPlayer2().getScore().getGameScore());
		// the game is won by the first player now
		assertTrue(tennisGame.getPlayer1().isTheGameWon());

		assertFalse(tennisGame.getPlayer2().isTheGameWon());
	}
}
