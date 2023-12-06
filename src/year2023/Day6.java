package year2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day6 {

    public static void main(String[] args) throws IOException {
        System.out.println(part1("resources\\year2023\\day6.txt"));
        System.out.println(part2("resources\\year2023\\day6.txt"));
    }

    public static int part1(String path) throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(path));
        int result = 1;

        String[] times = bReader.readLine().split("\\s+");
        String[] records = bReader.readLine().split("\\s+");
        for (int i = 1; i < times.length; i++) {
            if (times[i].matches("\\d+") && records[i].matches("\\d+")) {
                int time = Integer.parseInt(times[i]);
                int record = Integer.parseInt(records[i]);
                int ways = 0;
                for (int j = 0; j < time; j++) {
                    int distance = (time - j) * j;
                    if (distance > record) {
                        ways++;
                    }
                }
                result *= ways;
            }
        }

        return result;
    }

    public static int part2(String path) throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(path));
        String lineTimes = bReader.readLine().replaceAll("\\s+", "").replace("Time:", "");
        String lineDistances = bReader.readLine().replaceAll("\\s+", "").replace("Distance:", "");

        long time = Long.parseLong(lineTimes);
        long record = Long.parseLong(lineDistances);

        int ways = 0;
        for (long i = 14; i <= time - 14; i++) {
            long distance = i * (time - i);
            if (distance > record) {
                ways++;
            }
        }
        return ways;
    }
}
