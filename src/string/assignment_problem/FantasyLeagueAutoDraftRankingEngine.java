package string.assignment_problem;

import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Experience-only rule
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 10;
        }

        // Combined matches + fitness rule
        static boolean isDraftable(int matchesPlayed,
                                   double battingAverage,
                                   boolean injured) {

            return matchesPlayed >= 5
                    && battingAverage >= 50
                    && !injured;
        }

        boolean isDraftable() {
            return isDraftable(matchesPlayed, injured)
                    || isDraftable(matchesPlayed, battingAverage, injured);
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        String getName() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = Arrays.stream(players)
                .filter(Player::isDraftable)
                .toArray(Player[]::new);

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }

            result.append((i + 1))
                    .append(". ")
                    .append(draftable[i].getName());
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 30, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}