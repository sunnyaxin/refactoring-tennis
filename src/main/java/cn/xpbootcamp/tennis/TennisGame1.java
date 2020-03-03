package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constants.ADVANTAGE;
import static cn.xpbootcamp.tennis.Constants.ALL;
import static cn.xpbootcamp.tennis.Constants.DEUCE;
import static cn.xpbootcamp.tennis.Constants.DIVIDER;
import static cn.xpbootcamp.tennis.Constants.FIFTEEN;
import static cn.xpbootcamp.tennis.Constants.FORTY;
import static cn.xpbootcamp.tennis.Constants.LOVE;
import static cn.xpbootcamp.tennis.Constants.THIRTY;
import static cn.xpbootcamp.tennis.Constants.WIN_FOR;

public class TennisGame1 implements TennisGame {

    private int score1 = 0;
    private int score2 = 0;
    private String player1Name;
    private String player2Name;

    private String[] scoreDescription = new String[]{LOVE, FIFTEEN, THIRTY, FORTY};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) score1++;
        else score2++;
    }

    public String getScore() {
        if (hasSameScore()) return printSameScore();
        else if (hasLargeScoreGap()) return printLargeScore();
        return printSmallScore();
    }

    private boolean hasSameScore() {
        return score1 == score2;
    }

    private boolean hasLargeScoreGap() {
        return score1 >= 4 || score2 >= 4;
    }

    private String printSameScore() {
        if (score1 < 3) return scoreDescription[score1] + ALL;
        else return DEUCE;
    }

    private String printLargeScore() {
        int minusResult = score1 - score2;
        if (minusResult == 1) return ADVANTAGE + player1Name;
        else if (minusResult == -1) return ADVANTAGE + player2Name;
        else if (minusResult >= 2) return WIN_FOR + player1Name;
        else return WIN_FOR + player2Name;
    }

    private String printSmallScore() {
        return scoreDescription[score1] + DIVIDER + scoreDescription[score2];
    }
}