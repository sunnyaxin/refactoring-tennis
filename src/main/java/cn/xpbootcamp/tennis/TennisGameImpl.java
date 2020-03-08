package cn.xpbootcamp.tennis;

public class TennisGameImpl implements TennisGame {

    private int score1 = 0;
    private int score2 = 0;
    private String player1Name;
    private String player2Name;

    private String[] scoreDescription = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) score1++;
        else score2++;
    }

    public String getScore() {
        if (hasSameScore()) return printSameScore();
        else if (hasLargeScore()) return printLargeScore();
        return printSmallScore();
    }

    private boolean hasSameScore() {
        return score1 == score2;
    }

    private boolean hasLargeScore() {
        return score1 >= 4 || score2 >= 4;
    }

    private String printSameScore() {
        return score1 < 3 ? scoreDescription[score1] + "-All" : "Deuce";
    }

    private String printLargeScore() {
        int minusResult = score1 - score2;
        String winnerName = minusResult > 0 ? player1Name : player2Name;
        if (Math.abs(minusResult) < 2) return "Advantage " + winnerName;
        else return "Win for " + winnerName;
    }

    private String printSmallScore() {
        return scoreDescription[score1] + "-" + scoreDescription[score2];
    }
}