package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

public class WinScore extends Score {

    public WinScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApplied() {
        return (player1.getScore() >= 4 || player2.getScore() >= 4) && Math.abs(player1.getScore() - player2.getScore()) >= 2;
    }

    @Override
    public String description() {
        int minusResult = player1.getScore() - player2.getScore();
        String winnerName = minusResult > 0 ? player1.getName() : player2.getName();
        return "Win for " + winnerName;
    }
}