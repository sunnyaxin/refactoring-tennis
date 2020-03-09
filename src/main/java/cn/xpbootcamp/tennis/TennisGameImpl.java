package cn.xpbootcamp.tennis;

public class TennisGameImpl implements TennisGame {

    private Player player1, player2;
    private String[] scoreDescription = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

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
        if (hasSameScore()) {
            return printSameScore();
        } else if (hasAdvantageScore()) {
            return printAdvantageScore();
        } else if (hasWinnerScore()) {
            return printWinnerScore();
        } else {
            return printRegularScore();
        }
    }

    private boolean hasSameScore() {
        return player1.getScore() == player2.getScore();
    }

    private boolean hasAdvantageScore() {
        return (player1.getScore() >= 4 || player2.getScore() >= 4) && Math.abs(player1.getScore() - player2.getScore()) < 2;
    }

    private boolean hasWinnerScore() {
        return (player1.getScore() >= 4 || player2.getScore() >= 4) && Math.abs(player1.getScore() - player2.getScore()) >= 2;
    }

    private String printSameScore() {
        return player1.getScore() < 3 ? scoreDescription[player1.getScore()] + "-All" : "Deuce";
    }

    private String printAdvantageScore() {
        int minusResult = player1.getScore() - player2.getScore();
        String advantageName = minusResult > 0 ? player1.getName() : player2.getName();
        return "Advantage " + advantageName;
    }

    private String printWinnerScore() {
        int minusResult = player1.getScore() - player2.getScore();
        String winnerName = minusResult > 0 ? player1.getName() : player2.getName();
        return "Win for " + winnerName;
    }

    private String printRegularScore() {
        return scoreDescription[player1.getScore()] + "-" + scoreDescription[player2.getScore()];
    }
}