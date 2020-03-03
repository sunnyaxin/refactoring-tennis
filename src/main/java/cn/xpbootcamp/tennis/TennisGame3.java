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

public class TennisGame3 implements TennisGame {

    private int score1;
    private int score2;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) score2++;
        else score1++;
    }

    public String getScore() {
        String playerName;
        if (score2 < 4 && score1 < 4 && !(score2 + score1 == 6)) {
            String[] descriptions = new String[]{LOVE, FIFTEEN, THIRTY, FORTY};
            playerName = descriptions[score2];
            return (score2 == score1) ? playerName + ALL : playerName + DIVIDER + descriptions[score1];
        } else {
            if (score2 == score1) return DEUCE;
            playerName = score2 > score1 ? player1Name : player2Name;
            return ((score2 - score1) * (score2 - score1) == 1) ? ADVANTAGE + playerName : WIN_FOR + playerName;
        }
    }
}