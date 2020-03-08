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
        if (hasSameScore()) return printSameScore();
        else if (hasLargeScore()) return printLargeScore();
        return printSmallScore();
    }

    private boolean hasSameScore() {
        return player1.getScore() == player2.getScore();
    }

    private boolean hasLargeScore() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private String printSameScore() {
        return player1.getScore() < 3 ? scoreDescription[player1.getScore()] + "-All" : "Deuce";
    }

    private String printLargeScore() {
        int minusResult = player1.getScore() - player2.getScore();
        String winnerName = minusResult > 0 ? player1.getName() : player2.getName();
        if (Math.abs(minusResult) < 2) return "Advantage " + winnerName;
        else return "Win for " + winnerName;
    }

    private String printSmallScore() {
        return scoreDescription[player1.getScore()] + "-" + scoreDescription[player2.getScore()];
    }
}