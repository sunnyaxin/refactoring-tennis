package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constants.ADVANTAGE;
import static cn.xpbootcamp.tennis.Constants.ALL;
import static cn.xpbootcamp.tennis.Constants.DEUCE;
import static cn.xpbootcamp.tennis.Constants.DIVIDER;
import static cn.xpbootcamp.tennis.Constants.FIFTEEN;
import static cn.xpbootcamp.tennis.Constants.FORTY;
import static cn.xpbootcamp.tennis.Constants.LOVE;
import static cn.xpbootcamp.tennis.Constants.PLAYER_ONE;
import static cn.xpbootcamp.tennis.Constants.PLAYER_TWO;
import static cn.xpbootcamp.tennis.Constants.THIRTY;
import static cn.xpbootcamp.tennis.Constants.WIN_FOR;

public class TennisGame1 implements TennisGame {

    private int score1 = 0;
    private int score2 = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_ONE)) score1++;
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
        if (score1 < 3) return pointToDescription(score1) + ALL;
        else return DEUCE;
    }

    private String printLargeScore() {
        int minusResult = score1 - score2;
        if (minusResult == 1) return ADVANTAGE + PLAYER_ONE;
        else if (minusResult == -1) return ADVANTAGE + PLAYER_TWO;
        else if (minusResult >= 2) return WIN_FOR + PLAYER_ONE;
        else return WIN_FOR + PLAYER_TWO;
    }

    private String printSmallScore() {
        return pointToDescription(score1) + DIVIDER + pointToDescription(score2);
    }

    private String pointToDescription(int score) {
        switch (score) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            default:
                return FORTY;
        }
    }
}