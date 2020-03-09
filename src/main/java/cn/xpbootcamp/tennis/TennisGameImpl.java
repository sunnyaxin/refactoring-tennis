package cn.xpbootcamp.tennis;

import cn.xpbootcamp.tennis.score.AdvantageScore;
import cn.xpbootcamp.tennis.score.RegularScore;
import cn.xpbootcamp.tennis.score.SameScore;
import cn.xpbootcamp.tennis.score.Score;
import cn.xpbootcamp.tennis.score.WinScore;

public class TennisGameImpl implements TennisGame {

    private Player player1, player2;

    public TennisGameImpl(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.wonScore();
        } else {
            player2.wonScore();
        }
    }

    public String getScore() {
        Score sameScore = new SameScore(player1, player2);
        Score advantageScore = new AdvantageScore(player1, player2);
        Score winScore = new WinScore(player1, player2);
        Score regularScore = new RegularScore(player1, player2);

        if (sameScore.isApplied()) {
            return sameScore.description();
        } else if (advantageScore.isApplied()) {
            return advantageScore.description();
        } else if (winScore.isApplied()) {
            return winScore.description();
        } else {
            return regularScore.description();
        }
    }
}