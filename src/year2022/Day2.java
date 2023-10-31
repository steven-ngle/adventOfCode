package year2022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {

// A und X = Rock
// B und Y = Paper
// C und Z = Scissors

// Rock = +1
// Paper = +2
// Scissors = +3

// Win = +6
// Draw = +3
// Lose = +0

// A X = +4
// A Y = +8
// A Z = +3

// B Y = +5
// B X = +1
// B Z = +9

// C Z = +6
// C X = +7
// C Y = +2

        BufferedReader bReader;
        bReader = new BufferedReader(new FileReader("resources\\year2022\\day2.txt"));

        String stringLine;

        int sumDraw = 0;
        int sumWin = 0;
        int sumLose = 0;

        ArrayList<String> listWin = new ArrayList<String>();
        ArrayList<String> listDraw = new ArrayList<String>();
        ArrayList<String> listLose = new ArrayList<String>();

        try {
            while ((stringLine = bReader.readLine()) != null) {
                switch (stringLine) {
                    // DRAW
                    case "A X":
                        listDraw.add(stringLine);
                        break;
                    case "B Y":
                        listDraw.add(stringLine);
                        break;
                    case "C Z":
                        listDraw.add(stringLine);
                        break;
                    // WIN
                    case "A Y":
                        listWin.add(stringLine);
                        break;
                    case "B Z":
                        listWin.add(stringLine);
                        break;
                    case "C X":
                        listWin.add(stringLine);
                        break;
                    // Lose
                    case "A Z":
                        listLose.add(stringLine);
                        break;
                    case "B X":
                        listLose.add(stringLine);
                        break;
                    case "C Y":
                        listLose.add(stringLine);
                        break;
                    default:
                        System.out.println("moin moin");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // DRAW
        int drawRock = Collections.frequency(listDraw, "A X");
        int drawPaper = Collections.frequency(listDraw, "B Y");
        int drawScissors = Collections.frequency(listDraw, "C Z");
        // WIN
        int winRock = Collections.frequency(listWin, "A Y");
        int winPaper = Collections.frequency(listWin, "B Z");
        int winScissors = Collections.frequency(listWin, "C X");
        // LOSE
        int loseRock = Collections.frequency(listLose, "A Z");
        int losePaper = Collections.frequency(listLose, "B X");
        int loseScissors = Collections.frequency(listLose, "C Y");

        for (int i = 0; i < drawRock; i++) {
            sumDraw += 4;
        }
        for (int i = 0; i < drawPaper; i++) {
            sumDraw += 5;
        }
        for (int i = 0; i < drawScissors; i++) {
            sumDraw += 6;
        }

        for (int i = 0; i < winRock; i++) {
            sumWin += 8;
        }
        for (int i = 0; i < winPaper; i++) {
            sumWin += 9;
        }
        for (int i = 0; i < winScissors; i++) {
            sumWin += 7;
        }

        for (int i = 0; i < loseRock; i++) {
            sumLose += 3;
        }
        for (int i = 0; i < losePaper; i++) {
            sumLose += 1;
        }
        for (int i = 0; i < loseScissors; i++) {
            sumLose += 2;
        }

        int totalScore = sumDraw + sumWin + sumLose;
        System.out.println(totalScore);

// part two

// A = Rock
// B = Paper
// C = Scissors

// Rock = +1
// Paper = +2
// Scissors = +3

// X = Lose = +0
// Y = Draw = +3
// Z = Win = +6

// A X = +3
// A Y = +4
// A Z = +8

// B Y = +5
// B X = +1
// B Z = +9

// C Z = +7
// C X = +2
// C Y = +6

        ArrayList<String> listWin1 = new ArrayList<String>();
        ArrayList<String> listDraw1 = new ArrayList<String>();
        ArrayList<String> listLose1 = new ArrayList<String>();

        int sumDraw1 = 0;
        int sumWin1 = 0;
        int sumLose1 = 0;

        BufferedReader bReader1;
        bReader1 = new BufferedReader(new FileReader("resources\\day2.txt"));

        String stringLine1;

        try {
            while ((stringLine1 = bReader1.readLine()) != null) {
                switch (stringLine1) {
                    // DRAW
                    case "A Y":
                        listDraw1.add(stringLine1);
                        break;
                    case "B Y":
                        listDraw1.add(stringLine1);
                        break;
                    case "C Y":
                        listDraw1.add(stringLine1);
                        break;
                    // WIN
                    case "A Z":
                        listWin1.add(stringLine1);
                        break;
                    case "B Z":
                        listWin1.add(stringLine1);
                        break;
                    case "C Z":
                        listWin1.add(stringLine1);
                        break;
                    // Lose
                    case "A X":
                        listLose1.add(stringLine1);
                        break;
                    case "B X":
                        listLose1.add(stringLine1);
                        break;
                    case "C X":
                        listLose1.add(stringLine1);
                        break;
                    default:
                        System.out.println("tschau tschau");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // DRAW
        int drawA = Collections.frequency(listDraw1, "A Y");
        int drawB = Collections.frequency(listDraw1, "B Y");
        int drawC = Collections.frequency(listDraw1, "C Y");
        // WIN
        int winA = Collections.frequency(listWin1, "A Z");
        int winB = Collections.frequency(listWin1, "B Z");
        int winC = Collections.frequency(listWin1, "C Z");
        // LOSE
        int loseA = Collections.frequency(listLose1, "A X");
        int loseB = Collections.frequency(listLose1, "B X");
        int loseC = Collections.frequency(listLose1, "C X");

        for (int i = 0; i < drawA; i++) {
            sumDraw1 += 4;
        }
        for (int i = 0; i < drawB; i++) {
            sumDraw1 += 5;
        }
        for (int i = 0; i < drawC; i++) {
            sumDraw1 += 6;
        }

        for (int i = 0; i < winA; i++) {
            sumWin1 += 8;
        }
        for (int i = 0; i < winB; i++) {
            sumWin1 += 9;
        }
        for (int i = 0; i < winC; i++) {
            sumWin1 += 7;
        }

        for (int i = 0; i < loseA; i++) {
            sumLose1 += 3;
        }
        for (int i = 0; i < loseB; i++) {
            sumLose1 += 1;
        }
        for (int i = 0; i < loseC; i++) {
            sumLose1 += 2;
        }

        int totalScore2 = sumDraw1 + sumWin1 + sumLose1;
        System.out.println(totalScore2);
    }
}
