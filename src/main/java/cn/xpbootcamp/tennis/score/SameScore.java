package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

public class SameScore extends Score {

    public SameScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApplied() {
        return player1.getScore() == player2.getScore();
    }

    @Override
    public String description() {
        return player1.getScore() < 3 ? scoreDescription[player1.getScore()] + "-All" : "Deuce";
    }
}