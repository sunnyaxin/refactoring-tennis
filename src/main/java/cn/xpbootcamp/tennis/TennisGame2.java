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

    public String P1res = "";
    public String P2res = "";

    private String player1Name;
    private String player2Name;

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
        if (score1 == score2 && score1 < 4) {
            if (score1 == 0)
                score = LOVE;
            if (score1 == 1)
                score = FIFTEEN;
            if (score1 == 2)
                score = THIRTY;
            score += ALL;
        }
        if (score1 == score2 && score1 >= 3)
            score = DEUCE;

        if (score1 > 0 && score2 == 0) {
            if (score1 == 1)
                P1res = FIFTEEN;
            if (score1 == 2)
                P1res = THIRTY;
            if (score1 == 3)
                P1res = FORTY;

            P2res = LOVE;
            score = P1res + DIVIDER + P2res;
        }
        if (score2 > 0 && score1 == 0) {
            if (score2 == 1)
                P2res = FIFTEEN;
            if (score2 == 2)
                P2res = THIRTY;
            if (score2 == 3)
                P2res = FORTY;

            P1res = LOVE;
            score = P1res + DIVIDER + P2res;
        }

        if (score1 > score2 && score1 < 4) {
            if (score1 == 2)
                P1res = THIRTY;
            if (score1 == 3)
                P1res = FORTY;
            if (score2 == 1)
                P2res = FIFTEEN;
            if (score2 == 2)
                P2res = THIRTY;
            score = P1res + DIVIDER + P2res;
        }
        if (score2 > score1 && score2 < 4) {
            if (score2 == 2)
                P2res = THIRTY;
            if (score2 == 3)
                P2res = FORTY;
            if (score1 == 1)
                P1res = FIFTEEN;
            if (score1 == 2)
                P1res = THIRTY;
            score = P1res + DIVIDER + P2res;
        }

        if (score1 > score2 && score2 >= 3) {
            score = ADVANTAGE + player1Name;
        }

        if (score2 > score1 && score1 >= 3) {
            score = ADVANTAGE + player2Name;
        }

        if (score1 >= 4 && score2 >= 0 && (score1 - score2) >= 2) {
            score = WIN_FOR + player1Name;
        }
        if (score2 >= 4 && score1 >= 0 && (score2 - score1) >= 2) {
            score = WIN_FOR + player2Name;
        }
        return score;
    }
}