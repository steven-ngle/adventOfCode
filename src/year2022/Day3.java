package year2022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day3 {

    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader bReader;

        String stringLine;
        String firstCompartment = "";
        String secondCompartment = "";
        String backpack1 = "";
        String backpack2 = "";
        String backpack3 = "";
        int sum = 0;
        int sum2 = 0;
        ArrayList<String> firstCompartmentList = new ArrayList<String>();
        ArrayList<String> secondCompartmentList = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> rucksackList1 = new ArrayList<String>();
        ArrayList<String> rucksackList2 = new ArrayList<String>();
        ArrayList<String> rucksackList3 = new ArrayList<String>();

        bReader = new BufferedReader(new FileReader("resources\\year2022\\day3.txt"));

        try {
            while ((stringLine = bReader.readLine()) != null) {
                firstCompartmentList.add(stringLine.substring(0, stringLine.length()/2));
                secondCompartmentList.add(stringLine.substring(stringLine.length()/2, stringLine.length()));
                list.add(stringLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < firstCompartmentList.size(); i++) {
            firstCompartment = firstCompartmentList.get(i);
            secondCompartment = secondCompartmentList.get(i);

            Set<Character> set1 = new HashSet<Character>();
            Set<Character> set2 = new HashSet<Character>();

            for (char c : firstCompartment.toCharArray()) {
                set1.add(c);
            }
            for (char c : secondCompartment.toCharArray()) {
                set2.add(c);
            }

            set1.retainAll(set2);
            for (char c : set1) {
                if (Character.isUpperCase(c)) {
                    int priorityUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c) + 27;
                    sum += priorityUpperCase;
                }
                if (Character.isLowerCase(c)) {
                    int priorityLowerCase = "abcdefghijklmnopqrstuvwxyz".indexOf(c) + 1;
                    sum += priorityLowerCase;
                }
            }
        }
        System.out.println(sum);

        // part two

        boolean check = true;

        while (check) {
            rucksackList1.add(list.get(0));
            list.remove(0);
            rucksackList2.add(list.get(0));
            list.remove(0);
            rucksackList3.add(list.get(0));
            list.remove(0);
            if (list.size() == 0) {
                check = false;
            }
        }

        for (int i = 0; i < rucksackList1.size(); i++) {
            backpack1 = rucksackList1.get(i);
            backpack2 = rucksackList2.get(i);
            backpack3 = rucksackList3.get(i);

            Set<Character> setRucksack1 = new HashSet<Character>();
            Set<Character> setRucksack2 = new HashSet<Character>();
            Set<Character> setRucksack3 = new HashSet<Character>();

            for (char c : backpack1.toCharArray()) {
                setRucksack1.add(c);
            }
            for (char c : backpack2.toCharArray()) {
                setRucksack2.add(c);
            }
            for (char c : backpack3.toCharArray()) {
                setRucksack3.add(c);
            }

            setRucksack1.retainAll(setRucksack2);
            setRucksack1.retainAll(setRucksack3);

            for (char c : setRucksack1) {
                if (Character.isUpperCase(c)) {
                    int priorityUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c) + 27;
                    sum2 += priorityUpperCase;
                }
                if (Character.isLowerCase(c)) {
                    int priorityLowerCase = "abcdefghijklmnopqrstuvwxyz".indexOf(c) + 1;
                    sum2 += priorityLowerCase;
                }
            }
        }
        System.out.println(sum2);
    }
}
