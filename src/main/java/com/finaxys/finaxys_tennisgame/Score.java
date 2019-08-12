package com.finaxys.finaxys_tennisgame;

public class Score {
	
	private int gameScore;

	private int setScore;

	private int tieBreakScore;

	private boolean deuceRuleAdvantage;

	public Score(int gameScore, int setScore, int tieBreakScore) {
		this.gameScore = gameScore;
		this.setScore = setScore;
		this.tieBreakScore = tieBreakScore;
	}

	public int getGameScore() {
		return gameScore;
	}

	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

	public int getSetScore() {
		return setScore;
	}

	public void setSetScore(int setScore) {
		this.setScore = setScore;
	}

	public int getTieBreakScore() {
		return tieBreakScore;
	}

	public void setTieBreakScore(int tieBreakScore) {
		this.tieBreakScore = tieBreakScore;
	}

	public boolean isDeuceRuleAdvantage() {
		return deuceRuleAdvantage;
	}

	public void setDeuceRuleAdvantage(boolean deuceRuleAdvantage) {
		this.deuceRuleAdvantage = deuceRuleAdvantage;
	}

	public void incrementSet() {
		this.setScore = setScore + 1;
	}

	public void incrementTieBreak() {
		this.tieBreakScore = this.tieBreakScore + 1;
	}
}
