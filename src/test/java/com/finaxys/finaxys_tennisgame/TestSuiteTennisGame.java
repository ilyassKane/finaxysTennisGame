package com.finaxys.finaxys_tennisgame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PlayerTest.class, TennisGameTest.class, TennisGameSetTest.class, TennisGameDeuceRuleTest.class,
		TennisGameTieBreakTest.class })
public class TestSuiteTennisGame {

}
