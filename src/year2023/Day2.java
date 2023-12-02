package year2023;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day2 {

    public static void main(String[] args) throws IOException {
        System.out.println(part1("resources\\year2023\\day2.txt"));
        System.out.println(part2("resources\\year2023\\day2.txt"));
    }

    public static int part1(String path) throws IOException {

        int sum = 0;
        BufferedReader bReader = new BufferedReader(new FileReader(path));
        String line;

        while ((line = bReader.readLine()) != null) {

            String[] parts = line.split(": ");
            int id = Integer.parseInt(parts[0].replaceAll("\\D+", ""));

            String[] colorParts = parts[1].split("; ");
            boolean possible = true;

            for (String s : colorParts) {
                if (!possible) {
                    break;
                }
                String[] colorCounter = s.split(", ");
                for (String counter : colorCounter) {
                    HashMap<String, Integer> hm = new HashMap<>();
                    String[] split = counter.split(" ");
                    int count = Integer.parseInt(split[0]);
                    String color = split[1];
                    hm.put(color, hm.getOrDefault(color, 0) + count);
                    if ((hm.get("red") != null && hm.get("red") > 12) ||
                            (hm.get("green") != null && hm.get("green") > 13) ||
                            (hm.get("blue") != null && hm.get("blue") > 14)) {
                        possible = false;
                        break;
                    }
                }
            }
            if (possible) {
                sum += id;
            }
        }
        return sum;
    }

    public static int part2(String path) throws IOException {

        int sum = 0;
        BufferedReader bReader = new BufferedReader(new FileReader(path));
        String line;

        while ((line = bReader.readLine()) != null) {
            int minRed = 0;
            int minBlue = 0;
            int minGreen = 0;

            String[] parts = line.split(": ");
            String[] colorParts = parts[1].split("; ");

            for (String s : colorParts) {
                String[] colorCounter = s.split(", ");
                for (String counter : colorCounter) {
                    HashMap<String, Integer> hm = new HashMap<>();
                    String[] split = counter.split(" ");
                    int count = Integer.parseInt(split[0]);
                    String color = split[1];
                    hm.put(color, hm.getOrDefault(color, 0) + count);
                    if (hm.get("red") != null && hm.get("red") > minRed) {
                        minRed = hm.get("red");
                    } else if (hm.get("green") != null && hm.get("green") > minGreen) {
                        minGreen = hm.get("green");
                    } else if (hm.get("blue") != null && hm.get("blue") > minBlue) {
                        minBlue = hm.get("blue");
                    }
                }
            }
            sum += minRed * minGreen * minBlue;
        }

        return sum;
    }
}
