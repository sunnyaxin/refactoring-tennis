package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

public class RegularScore extends Score {

    public RegularScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApplied() {
        return true;
    }

    @Override
    public String description() {
        return scoreDescription[player1.getScore()] + "-" + scoreDescription[player2.getScore()];
    }
}