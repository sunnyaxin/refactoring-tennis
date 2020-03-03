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
        if (playerName.equals(PLAYER_ONE))
            score1++;
        else
            score2++;
    }

    public String getScore() {
        String score = "";
        if (hasSameScore()) {
            score = printSameScore();
        } else if (hasLargeScoreGap()) {
            score = printLargeScore();
        } else {
            score = printSmallScore(score);
        }
        return score;
    }

    private boolean hasSameScore() {
        return score1 == score2;
    }

    private boolean hasLargeScoreGap() {
        return score1 >= 4 || score2 >= 4;
    }

    private String printSameScore() {
        String score;
        switch (score1) {
            case 0:
                score = LOVE + ALL;
                break;
            case 1:
                score = FIFTEEN + ALL;
                break;
            case 2:
                score = THIRTY + ALL;
                break;
            default:
                score = DEUCE;
                break;
        }
        return score;
    }

    private String printLargeScore() {
        String score;
        int minusResult = score1 - score2;
        if (minusResult == 1) score = ADVANTAGE + PLAYER_ONE;
        else if (minusResult == -1) score = ADVANTAGE + PLAYER_TWO;
        else if (minusResult >= 2) score = WIN_FOR + PLAYER_ONE;
        else score = WIN_FOR + PLAYER_TWO;
        return score;
    }

    private String printSmallScore(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = score1;
            else {
                score += DIVIDER;
                tempScore = score2;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }
}