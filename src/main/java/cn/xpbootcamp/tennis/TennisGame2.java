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

public class TennisGame2 implements TennisGame {
    public int score1 = 0;
    public int score2 = 0;

    private String player1Name;
    private String player2Name;

    private String[] scoreDescription = new String[]{LOVE, FIFTEEN, THIRTY, FORTY};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) score1++;
        else score2++;
    }

    public String getScore() {
        String score = "";
        if (hasSameScore()) {
            return printSameScore();
        } else if (hasSmallScore()) {
            return printSmallScore();
        } else if (hasWinnerScore()) {
            return printWinnerScore();
        }

        if (score1 > score2 && score2 >= 3) {
            score = ADVANTAGE + player1Name;
        }

        if (score2 > score1 && score1 >= 3) {
            score = ADVANTAGE + player2Name;
        }
        return score;
    }

    private boolean hasSameScore() {
        return score1 == score2;
    }

    private boolean hasSmallScore() {
        return score1 < 4 && score2 < 4 && score1 != score2;
    }

    private boolean hasWinnerScore() {
        int higherScore = Math.max(score1, score2);
        return higherScore >= 4 && Math.abs(score1 - score2) >= 2;
    }

    private String printSameScore() {
        return score1 < 3 ? scoreDescription[score1] + ALL : DEUCE;
    }

    private String printSmallScore() {
        return scoreDescription[score1] + DIVIDER + scoreDescription[score2];
    }

    private String printWinnerScore() {
        String winnerPlayer = score1 - score2 > 0 ? player1Name : player2Name;
        return WIN_FOR + winnerPlayer;
    }
}