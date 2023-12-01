package year2022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1 {

    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(part1("resources\\year2022\\day1.txt"));
        System.out.println(part2("resources\\year2022\\day1.txt"));
    }

    public static int part1(String path) throws FileNotFoundException {

        BufferedReader bReader;
        bReader = new BufferedReader(new FileReader("resources\\year2022\\day1.txt"));
        String stringLine;
        int sum = 0;

        try {
            while ((stringLine = bReader.readLine()) != null) {

                if (stringLine.matches("[0-9]+")) {
                    sum += Integer.parseInt(stringLine);
                } else {
                    list.add(sum);
                    sum = 0;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.max(list);
    }

    public static int part2(String path) throws FileNotFoundException {

        BufferedReader bReader;
        bReader = new BufferedReader(new FileReader("resources\\year2022\\day1.txt"));
        String stringLine;
        int sum = 0;

        ArrayList<Integer> list2 = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            list2.add(Collections.max(list));
            list.remove(Collections.max(list));
        }

        for (int i : list2) {
            sum += i;
        }

        return sum;
    }
}
