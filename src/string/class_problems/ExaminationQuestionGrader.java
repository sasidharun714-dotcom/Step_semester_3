package string.class_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface QuestionGrader {
    double calculateScore(String correctAnswer, String studentAnswer, int points);
}

class MCQGrader implements QuestionGrader {

    public double calculateScore(String correctAnswer, String studentAnswer, int points) {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TFGrader implements QuestionGrader {

    public double calculateScore(String correctAnswer, String studentAnswer, int points) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class EssayGrader implements QuestionGrader {

    public double calculateScore(String correctAnswer, String studentAnswer, int points) {

        String[] keywords = correctAnswer.split(",");
        int matched = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationQuestionGrader {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        double totalScore = 0;

        Pattern pattern = Pattern.compile(
                "^(\\w+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$"
        );

        for (int i = 0; i < n; i++) {

            String line = br.readLine();

            Matcher matcher = pattern.matcher(line);

            if (!matcher.matches()) {
                continue;
            }

            String questionType = matcher.group(1);
            String questionText = matcher.group(2);
            String correctAnswer = matcher.group(3);
            String studentAnswer = matcher.group(4);
            int points = Integer.parseInt(matcher.group(5));

            QuestionGrader grader;

            if (questionType.equals("MCQ")) {
                grader = new MCQGrader();
            } else if (questionType.equals("TF")) {
                grader = new TFGrader();
            } else {
                grader = new EssayGrader();
            }

            double score = grader.calculateScore(
                    correctAnswer,
                    studentAnswer,
                    points
            );

            System.out.printf("%s: %.2f%n", questionType, score);

            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
    }
}