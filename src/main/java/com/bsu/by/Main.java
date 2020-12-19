package com.bsu.by;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String cvsSplitBy = ";";
        String line;
        String csvInFileNameHostels = "hostels.txt";
        List<Hostel> hostelsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvInFileNameHostels))) {
            while ((line = br.readLine()) != null) {
                String[] hostels = line.split(cvsSplitBy);
                for (int j = 0; j < hostels.length; j++) {
                    hostels[j] = hostels[j].toLowerCase();
                }
                hostelsList.add(new Hostel(hostels));
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        try (Scanner sc = new Scanner(System.in)) {
            int switcher;
            StrAPI methods = new StrAPI(hostelsList);
            Scanner scanner = new Scanner(System.in);
            boolean isRun = true;
            while (isRun) {
                System.out.println("1 - List of hostels");
                System.out.println("2 - List of hostels with wins by num");
                System.out.println("3 - Find by name");
                System.out.println("4 - Group of hostels");
                System.out.println("5 - Exit");
                switcher = sc.nextInt();
                switch (switcher) {
                    case 1:
                        methods.hostelStars();
                        break;
                    case 2:
                        System.out.println("Min of stars?");
                        int stars = sc.nextInt();
                        methods.topRating(stars);
                        break;
                    case 3:
                        System.out.println("Hostel's name?");
                        String name = scanner.nextLine();
                        methods.searchName(name);
                        break;
                    case 4:
                        System.out.println("Group's name");
                        String category = scanner.nextLine();
                        System.out.println("Hostel - " + category + " stars - " + methods.hostelRating(category));
                        break;
                    case 5:
                        isRun = false;
                        break;
                }
            }
        }
    }
}

