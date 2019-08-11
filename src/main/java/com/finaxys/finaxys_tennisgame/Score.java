package com.finaxys.finaxys_tennisgame;

public class Score {
	
	private Integer gameScore;

	private Integer setScore;

	private Integer tieBreakScore;

	private boolean deuceRuleAdvantage;

	public Score(Integer gameScore, Integer setScore, Integer tieBreakScore) {
		this.gameScore = gameScore;
		this.setScore = setScore;
		this.tieBreakScore = tieBreakScore;
	}

	public Integer getGameScore() {
		return gameScore;
	}

	public void setGameScore(Integer gameScore) {
		this.gameScore = gameScore;
	}

	public Integer getSetScore() {
		return setScore;
	}

	public void setSetScore(Integer setScore) {
		this.setScore = setScore;
	}

	public Integer getTieBreakScore() {
		return tieBreakScore;
	}

	public void setTieBreakScore(Integer tieBreakScore) {
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
