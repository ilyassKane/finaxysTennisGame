package com.finaxys.finaxys_tennisgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TennisGameDeuceRuleTest {
	TennisGame tennisGame = null;

	@Before
	public void setUp() {
		tennisGame = new TennisGame(new Player("Federer", new Score(0, 0, 0)), new Player("Nadal", new Score(0, 0, 0)));
		activateTheDeuceRule();
	}

	// this methode create a Deuce Rule situation
	public void activateTheDeuceRule() {
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(15), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(0), tennisGame.getPlayer2().getScore().getGameScore());

		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(30), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(0), tennisGame.getPlayer2().getScore().getGameScore());

		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(Integer.valueOf(30), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(15), tennisGame.getPlayer2().getScore().getGameScore());

		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(15), tennisGame.getPlayer2().getScore().getGameScore());

		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(30), tennisGame.getPlayer2().getScore().getGameScore());

		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

	}

	@Test
	public void playerTwoScoreAndhaveTheADVAndShouldReturn_40_and_playerTworeturn_40() {

		// the Second player scores
		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

		// the second player took the advantage
		assertTrue(tennisGame.getPlayer2().getScore().isDeuceRuleAdvantage());
		assertFalse(tennisGame.getPlayer1().getScore().isDeuceRuleAdvantage());

		// the game is not won by anyOne yet
		assertFalse(tennisGame.getPlayer2().isTheGameWon());
		assertFalse(tennisGame.getPlayer1().isTheGameWon());
	}

	@Test
	public void playerOneCancelTheADVOfPlayerTwo_playerOneShouldReturn_40_and_playerTworeturn_40() {

		// the Second player scores and got the Adv
		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

		// the First player scores and cancel the Adv
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

		// we are back on the Deuce situation again
		assertFalse(tennisGame.getPlayer2().getScore().isDeuceRuleAdvantage());
		assertFalse(tennisGame.getPlayer1().getScore().isDeuceRuleAdvantage());

		// the game is not won by anyOne yet
		assertFalse(tennisGame.getPlayer2().isTheGameWon());
		assertFalse(tennisGame.getPlayer1().isTheGameWon());
	}

	@Test
	public void playerOneScoresAgainAndTookAdv_playerOneShouldReturn_40_and_playerTworeturn_40() {

		// the Second player scores and got the Adv
		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

		// the First player scores and cancel the Adv
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

		// the First player scores again and took the Adv
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

		assertFalse(tennisGame.getPlayer2().getScore().isDeuceRuleAdvantage());

		// the first took the Advantage
		assertTrue(tennisGame.getPlayer1().getScore().isDeuceRuleAdvantage());

		// the game is not won by anyOne yet
		assertFalse(tennisGame.getPlayer2().isTheGameWon());
		assertFalse(tennisGame.getPlayer1().isTheGameWon());
	}

	@Test
	public void playerOneScoresAgainAndWonTheGame_playerOneShouldReturn_0_and_playerTworeturn_0() {

		// the Second player scores and got the Adv
		tennisGame.winsPoint(tennisGame.getPlayer2());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

		// the First player scores and cancel the Adv
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

		// the First player scores again and took the Adv
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(40), tennisGame.getPlayer2().getScore().getGameScore());

		// the First player scores again and won the game
		tennisGame.winsPoint(tennisGame.getPlayer1());
		assertEquals(Integer.valueOf(0), tennisGame.getPlayer1().getScore().getGameScore());
		assertEquals(Integer.valueOf(0), tennisGame.getPlayer2().getScore().getGameScore());
		
		// the game is won by the first player
		assertTrue(tennisGame.getPlayer1().isTheGameWon());
		assertFalse(tennisGame.getPlayer2().isTheGameWon());
		
		//All the data are reset
		assertFalse(tennisGame.getPlayer2().getScore().isDeuceRuleAdvantage());
		assertFalse(tennisGame.getPlayer1().getScore().isDeuceRuleAdvantage());
	}
}
