package year2023;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {

    public static void main(String[] args) throws IOException {
        System.out.println(part1("resources\\year2023\\day3.txt"));
        System.out.println(part2("resources\\year2023\\day3.txt"));
    }

    public static int part1(String path) throws IOException {
        int sum = 0;
        BufferedReader bReader = new BufferedReader(new FileReader(path));
        String line;
        ArrayList<String> engine = new ArrayList<>();

        while ((line = bReader.readLine()) != null) {
            engine.add(line);
        }

        ArrayList<Point> symbolIndexes = new ArrayList<>();
        for (int i = 0; i < engine.size(); i++) {
            for (int j = 0; j < engine.get(i).length(); j++) {
                char c = engine.get(i).charAt(j);
                if (!Character.isDigit(c) && c != '.') {
                    symbolIndexes.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < engine.size(); i++) {
            int number = 0;
            int startJ = 0;
            boolean added = false;
            for (int j = 0; j <= engine.get(i).length(); j++) {
                if (j < engine.get(i).length() && Character.isDigit(engine.get(i).charAt(j))) {
                    if (number == 0) {
                        startJ = j;
                    }
                    number = number * 10 + Character.getNumericValue(engine.get(i).charAt(j));
                }
                if (number > 0 && (j == engine.get(i).length() || !Character.isDigit(engine.get(i).charAt(j)))) {
                    for (int k = startJ; k < j; k++) {
                        for (Point p : symbolIndexes) {
                            int x = p.x - i;
                            int y = p.y - k;
                            if ((x >= -1 && x <= 1) && (y >= -1 && y <= 1) && !(x == 0 && y == 0)) {
                                sum += number;
                                added = true;
                                break;
                            }
                        }
                        if (added) {
                            break;
                        }
                    }
                    number = 0;
                    added = false;
                }
            }
        }

        return sum;
    }

    public static int part2(String path) throws IOException {
        int sum = 0;

        return sum;
    }
}
