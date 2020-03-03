package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {
    public int score1 = 0;
    public int score2 = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (score1 == score2 && score1 < 4) {
            if (score1 == 0)
                score = "Love";
            if (score1 == 1)
                score = "Fifteen";
            if (score1 == 2)
                score = "Thirty";
            score += "-All";
        }
        if (score1 == score2 && score1 >= 3)
            score = "Deuce";

        if (score1 > 0 && score2 == 0) {
            if (score1 == 1)
                P1res = "Fifteen";
            if (score1 == 2)
                P1res = "Thirty";
            if (score1 == 3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (score2 > 0 && score1 == 0) {
            if (score2 == 1)
                P2res = "Fifteen";
            if (score2 == 2)
                P2res = "Thirty";
            if (score2 == 3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (score1 > score2 && score1 < 4) {
            if (score1 == 2)
                P1res = "Thirty";
            if (score1 == 3)
                P1res = "Forty";
            if (score2 == 1)
                P2res = "Fifteen";
            if (score2 == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;
        }
        if (score2 > score1 && score2 < 4) {
            if (score2 == 2)
                P2res = "Thirty";
            if (score2 == 3)
                P2res = "Forty";
            if (score1 == 1)
                P1res = "Fifteen";
            if (score1 == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;
        }

        if (score1 > score2 && score2 >= 3) {
            score = "Advantage player1";
        }

        if (score2 > score1 && score1 >= 3) {
            score = "Advantage player2";
        }

        if (score1 >= 4 && score2 >= 0 && (score1 - score2) >= 2) {
            score = "Win for player1";
        }
        if (score2 >= 4 && score1 >= 0 && (score2 - score1) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            score1++;
        else
            score2++;
    }
}