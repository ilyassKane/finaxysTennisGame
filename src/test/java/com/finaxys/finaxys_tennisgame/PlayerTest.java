package com.finaxys.finaxys_tennisgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private Player player = null;

	@Before
	public void setup() {
		player = new Player("testPlayer", new Score(0, 0, 0));
	}

	@Test
	public void shouldReturn_15() {
		//the player win his first point in a game
		player.winsPoint();
		assertEquals(15, player.getScore().getGameScore());
	}

	@Test
	public void shouldReturn_30() {
		//the player win his second point in a game
		player.winsPoint();
		assertEquals(15, player.getScore().getGameScore());
		player.winsPoint();
		assertEquals(30, player.getScore().getGameScore());
	}

	@Test
	public void shouldReturn_40() {
		//the player win his third point in a game
		player.winsPoint();
		assertEquals(15, player.getScore().getGameScore());
		player.winsPoint();
		assertEquals(30, player.getScore().getGameScore());
		player.winsPoint();
		assertEquals(40, player.getScore().getGameScore());
	}
	
	@Test
    public void shouldReturn_0_and_playerWinTheGame(){
		//the player win his fourth point in a game and win the game
        player.winsPoint();
        assertEquals(15,player.getScore().getGameScore());
        player.winsPoint();
        assertEquals(30,player.getScore().getGameScore());
        player.winsPoint();
        assertEquals(40,player.getScore().getGameScore());
        player.winsPoint();
        assertEquals(0,player.getScore().getGameScore());
		assertTrue(player.isTheGameWon());
    }
}
