package year2022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {

    public static void main(String[] args) throws IOException {

        System.out.println(part1("resources\\year2022\\day4.txt"));
        System.out.println(part2("resources\\year2022\\day4.txt"));
    }

    public static int part1(String path) throws IOException {

        int fullyContained = 0;
        BufferedReader bReader = new BufferedReader(new FileReader(path));
        String line;

        while ((line = bReader.readLine()) != null) {
            String[] ranges = line.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            int start1 = Integer.parseInt(range1[0]);
            int end1 = Integer.parseInt(range1[1]);
            int start2 = Integer.parseInt(range2[0]);
            int end2 = Integer.parseInt(range2[1]);

            if ((start1 >= start2 && end1 <= end2) || (start1 <= start2 && end1 >= end2)) {
                fullyContained++;
            }
        }

        return fullyContained;
    }

    public static int part2(String path) throws IOException {

        int overlap = 0;
        BufferedReader bReader = new BufferedReader(new FileReader(path));
        String line;

        while ((line = bReader.readLine()) != null) {
            String[] ranges = line.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            int start1 = Integer.parseInt(range1[0]);
            int end1 = Integer.parseInt(range1[1]);
            int start2 = Integer.parseInt(range2[0]);
            int end2 = Integer.parseInt(range2[1]);

            if ((start1 <= end2) && (start2 <= end1)) {
                overlap++;
            }
        }

        return overlap;
    }
}
