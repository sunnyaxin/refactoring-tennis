package cn.xpbootcamp.tennis;

public class TennisGame3 implements TennisGame {

    private int score1;
    private int score2;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String playerName;
        if (score2 < 4 && score1 < 4 && !(score2 + score1 == 6)) {
            String[] descriptions = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            playerName = descriptions[score2];
            return (score2 == score1) ? playerName + "-All" : playerName + "-" + descriptions[score1];
        } else {
            if (score2 == score1)
                return "Deuce";
            playerName = score2 > score1 ? player1Name : player2Name;
            return ((score2 - score1) * (score2 - score1) == 1) ? "Advantage " + playerName : "Win for " + playerName;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.score2 += 1;
        else
            this.score1 += 1;
    }
}