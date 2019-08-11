package com.finaxys.finaxys_tennisgame;

public class TennisGame {

	private Player player1;

	private Player player2;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player winsPoint(Player player) {

		// get the other player
		Player secondPlayer = getTheOtherPlayerFromAplayer(player);
		player.setTheGameWon(false);
		secondPlayer.setTheGameWon(false);

		// the game is over if the set is won
		if (player.isTheSetWon() || secondPlayer.isTheSetWon())
			throw new TennisGameException("The game is Over! the set is already won");
		else if (player.getScore().getSetScore() == secondPlayer.getScore().getSetScore()
				&& secondPlayer.getScore().getSetScore() == 6) {
			// the tie break rule is activated
			player.getScore().incrementTieBreak();
			checkAndApplyTheTieBreakRule(player, secondPlayer);
		} else if (player.getScore().getGameScore() == secondPlayer.getScore().getGameScore()
				&& secondPlayer.getScore().getGameScore() == 40) {
			// the Deuce rule is activated
			checkAndApplyDeuceRule(player, secondPlayer);
		} else {
			player.winsPoint();
			if (player.isTheGameWon()) {
				secondPlayer.getScore().setGameScore(0);
				player.getScore().incrementSet();
				checkIfTheSetIsWon(player, secondPlayer);
			}
		}
		showScore(player,secondPlayer);
		return player;
	}

	//get the other player from a player
	private Player getTheOtherPlayerFromAplayer(Player player) {
		if (player.equals(getPlayer1()))
			return getPlayer2();
		return getPlayer1();
	}

		//this methode check and apply the deuce Rule
	private void checkAndApplyDeuceRule(Player playerWhoWon, Player secondPlayer) {
		if (!playerWhoWon.getScore().isDeuceRuleAdvantage() && !secondPlayer.getScore().isDeuceRuleAdvantage()) {
			playerWhoWon.getScore().setDeuceRuleAdvantage(true);
			showScore(playerWhoWon,secondPlayer);
		} else if (!playerWhoWon.getScore().isDeuceRuleAdvantage() && secondPlayer.getScore().isDeuceRuleAdvantage()) {
			secondPlayer.getScore().setDeuceRuleAdvantage(false);
		} else if (playerWhoWon.getScore().isDeuceRuleAdvantage() && !secondPlayer.getScore().isDeuceRuleAdvantage()) {
			playerWhoWon.getScore().incrementSet();
			playerWhoWon.setTheGameWon(true);
			playerWhoWon.getScore().setGameScore(0);
			secondPlayer.getScore().setGameScore(0);
			playerWhoWon.getScore().setDeuceRuleAdvantage(false);
			checkIfTheSetIsWon(playerWhoWon, secondPlayer);
			showScore(playerWhoWon,secondPlayer);
		}
	}

		//this methode check and apply the deuce rule
	private void checkAndApplyTheTieBreakRule(Player playerWhoWon, Player secondPlayer) {
		playerWhoWon.getScore().setGameScore(0);
		secondPlayer.getScore().setGameScore(0);
		if (playerWhoWon.getScore().getTieBreakScore() >= 7
				&& playerWhoWon.getScore().getTieBreakScore() - secondPlayer.getScore().getTieBreakScore() >= 2) {
			playerWhoWon.setTheSetWon(true);
			playerWhoWon.getScore().incrementSet();
			playerWhoWon.getScore().setTieBreakScore(0);
			secondPlayer.getScore().setTieBreakScore(0);
			showScore(playerWhoWon,secondPlayer);
		}
	}

	private void checkIfTheSetIsWon(Player playerWhoWon, Player secondPlayer) {
		if (playerWhoWon.getScore().getSetScore() == 6 && secondPlayer.getScore().getSetScore() <= 4) {
			playerWhoWon.setTheSetWon(true);
		} else if (playerWhoWon.getScore().getSetScore() == 7 && secondPlayer.getScore().getSetScore() == 5) {
			playerWhoWon.setTheSetWon(true);
		}
	}
	
	private void showScore(Player playerWhoWon, Player secondPlayer) {
		System.out.println("-------------------------------------------------------------------");
		if(playerWhoWon.isTheGameWon())
			System.out.println(playerWhoWon.getNameId()+" win this game");
		System.out.println("["+playerWhoWon.getNameId()+" (set : "+playerWhoWon.getScore().getSetScore()+" / game : "+playerWhoWon.getScore().getGameScore()+" / Tie Break : "+playerWhoWon.getScore().getTieBreakScore()+")]");
		System.out.println("["+secondPlayer.getNameId()+" (set : "+secondPlayer.getScore().getSetScore()+" / game : "+secondPlayer.getScore().getGameScore()+" / Tie Break : "+secondPlayer.getScore().getTieBreakScore()+")]");
		if(playerWhoWon.isTheSetWon())
			System.out.println(playerWhoWon.getNameId()+" WIN THE SET, THE GAME IS OVER NOW");
		System.out.println("\n");
		//System.out.println("-------------------------------------------------------------------");
	}

}
