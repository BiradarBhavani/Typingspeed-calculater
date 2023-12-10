import java.util.Scanner;

public class typingspeed {

    public static void main(String[] args) {
        String correctText = "The quick brown fox jumps over the lazy dog";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type the following text:");
        System.out.println(correctText);

        System.out.println("Press Enter when you are ready to start typing.");
        scanner.nextLine();

        long startTime = System.currentTimeMillis();

        System.out.println("Start typing:");

        String userTypedText = scanner.nextLine().trim();

        long endTime = System.currentTimeMillis();

        // Calculate performance metrics
        int correctChars = calculateCorrectCharacters(correctText, userTypedText);
        int totalChars = correctText.length();
        int totalTimeInSeconds = (int) ((endTime - startTime) / 1000);

        double cpm = calculateCPM(correctChars, totalTimeInSeconds);
        double wpm = calculateWPM(correctChars, totalTimeInSeconds);
        double accuracy = calculateAccuracy(correctChars, totalChars);

        // Display performance metrics
        System.out.println("\nTyping Performance Analysis:");
        System.out.println("Characters per Minute (CPM): " + cpm);
        System.out.println("Words per Minute (WPM): " + wpm);
        System.out.println("Accuracy: " + accuracy + "%");

    
        giveFeedback(cpm, wpm, accuracy);

        scanner.close();
    }

    private static int calculateCorrectCharacters(String correctText, String userTypedText) {
        int correctChars = 0;
        int minLength = Math.min(correctText.length(), userTypedText.length());

        for (int i = 0; i < minLength; i++) {
            if (correctText.charAt(i) == userTypedText.charAt(i)) {
                correctChars++;
            }
        }

        return correctChars;
    }

    private static double calculateCPM(int correctChars, int totalTimeInSeconds) {
        return (correctChars / 5.0) / totalTimeInSeconds * 60.0; // Assuming an average word length of 5 characters
    }

    private static double calculateWPM(int correctChars, int totalTimeInSeconds) {
        return (correctChars / 5.0) / totalTimeInSeconds * 60.0 / 5.0; // Assuming an average word length of 5 characters
    }

    private static double calculateAccuracy(int correctChars, int totalChars) {
        return (correctChars / (double) totalChars) * 100.0;
    }

    private static void giveFeedback(double cpm, double wpm, double accuracy) {
        System.out.println("\nFeedback:");

        if (accuracy < 90) {
            System.out.println("Your accuracy is quite low. Take your time to type accurately.");
        } else if (wpm < 30) {
            System.out.println("Your typing speed is below average. Practice regularly to improve.");
        } else {
            System.out.println("Great job! Your typing performance is good.");
        }
    }
}