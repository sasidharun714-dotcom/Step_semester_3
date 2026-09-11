package string.assignment_problem;




public class TopPerformerTracker {

    static void findTopPerformer(String[] playerNames, int[] scores) {

        int highestScore = scores[0];
        String topPlayer = playerNames[0];

        for (int i = 1; i < scores.length; i++) {

            if (scores[i] > highestScore) {
                highestScore = scores[i];
                topPlayer = playerNames[i];
            }
        }

        System.out.println("Top Performer: " + topPlayer);
        System.out.println("Highest Score: " + highestScore);
    }

    public static void main(String[] args) {

        String[] playerNames = {"Kohli", "Bumrah", "Rohit", "Hardik"};
        int[] scores = {85, 92, 78, 88};

        findTopPerformer(playerNames, scores);
    }
}