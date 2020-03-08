package cn.xpbootcamp.tennis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisTest {

    private static String player1Name = "player1";
    private static String player2Name = "player2";

    private static class TestFixture {
        int player1Score;
        int player2Score;
        String statement;

        private TestFixture(int player1Score, int player2Score, String statement) {
            this.player1Score = player1Score;
            this.player2Score = player2Score;
            this.statement = statement;
        }

        public static TestFixture create(int player1Score, int player2Score, String statement) {
            return new TestFixture(player1Score, player2Score, statement);
        }
    }

    public static Stream<TestFixture> provideScores() {
        return Stream.of(
                TestFixture.create(0, 0, "Love-All"),
                TestFixture.create(1, 1, "Fifteen-All"),
                TestFixture.create(2, 2, "Thirty-All"),
                TestFixture.create(3, 3, "Deuce"),
                TestFixture.create(4, 4, "Deuce"),

                TestFixture.create(1, 0, "Fifteen-Love"),
                TestFixture.create(0, 1, "Love-Fifteen"),
                TestFixture.create(2, 0, "Thirty-Love"),
                TestFixture.create(0, 2, "Love-Thirty"),
                TestFixture.create(3, 0, "Forty-Love"),
                TestFixture.create(0, 3, "Love-Forty"),

                TestFixture.create(2, 1, "Thirty-Fifteen"),
                TestFixture.create(1, 2, "Fifteen-Thirty"),
                TestFixture.create(3, 1, "Forty-Fifteen"),
                TestFixture.create(1, 3, "Fifteen-Forty"),
                TestFixture.create(3, 2, "Forty-Thirty"),
                TestFixture.create(2, 3, "Thirty-Forty"),

                TestFixture.create(4, 0, "Win for " + player1Name),
                TestFixture.create(0, 4, "Win for " + player2Name),
                TestFixture.create(4, 1, "Win for " + player1Name),
                TestFixture.create(1, 4, "Win for " + player2Name),
                TestFixture.create(4, 2, "Win for " + player1Name),
                TestFixture.create(2, 4, "Win for " + player2Name),
                TestFixture.create(6, 4, "Win for " + player1Name),
                TestFixture.create(4, 6, "Win for " + player2Name),
                TestFixture.create(16, 14, "Win for " + player1Name),
                TestFixture.create(14, 16, "Win for " + player2Name),

                TestFixture.create(4, 3, "Advantage " + player1Name),
                TestFixture.create(3, 4, "Advantage " + player2Name),
                TestFixture.create(5, 4, "Advantage " + player1Name),
                TestFixture.create(4, 5, "Advantage " + player2Name),
                TestFixture.create(15, 14, "Advantage " + player1Name),
                TestFixture.create(14, 15, "Advantage " + player2Name));
    }

    @ParameterizedTest
    @MethodSource({"provideScores"})
    public void should_check_all_scores_correctly(TestFixture testFixture) {
        TennisGame tennisGame = new TennisGameImpl(player1Name, player2Name);

        int highestScore = Math.max(testFixture.player1Score, testFixture.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < testFixture.player1Score)
                tennisGame.wonPoint(player1Name);
            if (i < testFixture.player2Score)
                tennisGame.wonPoint(player2Name);
        }
        assertThat(tennisGame.getScore()).isEqualTo(testFixture.statement);
    }
}