package com.finaxys.finaxys_tennisgame;

public class Player {

	private String nameId;

	private Score score;

	private boolean theGameWon;

	private boolean theSetWon;

	public Player(String nameId, Score score) {
		this.nameId = nameId;
		this.score = score;
	}

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public boolean isTheGameWon() {
		return theGameWon;
	}

	public void setTheGameWon(boolean theGameWon) {
		this.theGameWon = theGameWon;
	}

	public boolean isTheSetWon() {
		return theSetWon;
	}

	public void setTheSetWon(boolean theSetWon) {
		this.theSetWon = theSetWon;
	}

	public Score winsPoint() {
		if (score.getGameScore() == 0) {
			score.setGameScore(15);
			return score;
		}
		if (score.getGameScore() == 15) {
			score.setGameScore(30);
			return score;
		}
		if (score.getGameScore() == 30) {
			score.setGameScore(40);
			return score;
		}
		if (score.getGameScore() == 40) {
			score.setGameScore(0);
			setTheGameWon(true);
			return score;
		}
		return score;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Player player = (Player) obj;
		return this.getNameId().equals(player.getNameId());

	}
}
