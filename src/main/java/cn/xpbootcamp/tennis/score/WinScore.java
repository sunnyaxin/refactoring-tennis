package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

public class WinScore extends Score {

    public WinScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApplied() {
        return player1.hasWonAgainst(player2) || player2.hasWonAgainst(player1);
    }

    @Override
    public String description() {
        return "Win for " + (player1.hasWonAgainst(player2) ? player1.getName() : player2.getName());
    }
}