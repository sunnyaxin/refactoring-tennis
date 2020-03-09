package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

public abstract class Score {
    protected Player player1;
    protected Player player2;

    protected String[] scoreDescription = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public Score(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public abstract boolean isApplied();

    public abstract String description();
}