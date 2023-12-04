package year2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day4 {

    public static void main(String[] args) throws IOException {
        System.out.println(part1("resources\\year2023\\day4.txt"));
        System.out.println(part2("resources\\year2023\\day4.txt"));
    }

    public static int part1(String path) throws IOException {

        int points = 0;
        BufferedReader bReader = new BufferedReader(new FileReader(path));
        String line;

        while ((line = bReader.readLine()) != null) {
            int sum = 0;
            int counter = 0;
            line = line.replaceAll("^Card \\d+: ", "");
            String[] parts = line.split("\\|");
            String[] winningNumbers = parts[0].trim().split("\\s+");
            String[] yourNumbers = parts[1].trim().split("\\s+");
            for (String winningNumber : winningNumbers) {
                boolean contains = Arrays.asList(yourNumbers).contains(winningNumber);
                if (contains) {
                    counter++;
                }
            }
            if (counter >= 1) {
                sum++;
                for (int i = 0; i < counter - 1; i++) {
                    sum *= 2;
                }
            }
            points += sum;
        }
        return points;
    }

    public static int part2(String path) throws IOException {

        BufferedReader readerCounter = new BufferedReader(new FileReader(path));
        int linesCounter = 0;

        while (readerCounter.readLine() != null) {
            linesCounter++;
        }
        readerCounter.close();

        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 1; i < linesCounter + 1; i++) {
            numbers.put(i, 1);
        }

        BufferedReader bReader = new BufferedReader(new FileReader(path));
        String line;
        int sum = 0;

        while ((line = bReader.readLine()) != null) {
            String[] parts = line.split("\\|");
            String[] split = parts[0].split(":");
            String[] numberParts = split[0].split("\\s+");

            int cardNumber = 0;
            for (String s : numberParts) {
                if (s.matches("\\d+")) {
                    cardNumber = Integer.parseInt(s);
                }
            }

            String[] currentCards = split[1].split("\\s+");
            String[] winningCards = parts[1].split("\\s+");

            int counter = 0;

            for (int i = 1; i < currentCards.length; i++) {
                for (int k = 1; k < winningCards.length; k++) {
                    if (currentCards[i].equals(winningCards[k])) {
                        counter++;
                    }
                }
            }

            for (int i = 1; i <= numbers.get(cardNumber); i++) {
                for (int j = cardNumber + 1; j < cardNumber + counter + 1; j++) {
                    numbers.put(j, numbers.get(j) + 1);
                }
            }
        }

        for (int key : numbers.keySet()) {
            sum += numbers.get(key);
        }

        return sum;
    }
}
