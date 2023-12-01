package year2023;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day1 {

    public static void main(String[] args) throws IOException {
        System.out.println(part1("resources\\year2023\\day1.txt"));
        System.out.println(part2("resources\\year2023\\day1.txt"));
    }

    public static int part1(String path) throws IOException {

        int sum = 0;

        try (BufferedReader bReader = new BufferedReader(new FileReader(path))) {

            String line = bReader.readLine();
            while (line != null) {
                int first = 0;
                int last = 0;
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        if (first == 0) {
                            first = Character.getNumericValue(c);
                        }
                        last = Character.getNumericValue(c);
                    }
                }
                sum += first * 10 + last;

                line = bReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sum;
    }

    public static int part2(String path) throws IOException {

        int sum = 0;

        BufferedReader bReader = new BufferedReader(new FileReader(path));
        String line;

        while ((line = bReader.readLine()) != null) {
            int first = 0;
            int last = 0;
            ArrayList<Integer> arrayList = new ArrayList<>();

            String newline = line.replace("one", "o1e")
                                 .replace("two", "t2o")
                                 .replace("three", "t3hree")
                                 .replace("four", "f4ur")
                                 .replace("five", "f5ve")
                                 .replace("six", "s6x")
                                 .replace("seven", "s7ven")
                                 .replace("eight", "e8ght")
                                 .replace("nine", "n9ne")
                                 .replace("zero", "z0ro");

            char[] chars = newline.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    arrayList.add(Character.getNumericValue(chars[i]));
                }
            }

            first = arrayList.get(0);
            last = arrayList.get(arrayList.size() - 1);
            sum += first * 10 + last;
        }

        return sum;
    }

}

