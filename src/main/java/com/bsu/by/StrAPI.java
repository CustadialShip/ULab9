package com.bsu.by;


import java.util.List;
import java.util.stream.Collectors;

public class StrAPI {
    private List<Hostel> hostels;

    public StrAPI(List<Hostel> hostels) {
        this.hostels = hostels;
    }

    public void searchName(String name) {
        hostels.stream().parallel().filter(x1 -> x1.getName().equals(name)).findAny()
                .ifPresent(System.out::println);
    }

    public int hostelRating(String hostel) {
        return hostels.stream().filter(p -> p.getGroup().equalsIgnoreCase(hostel))
                .reduce(0, (x1, x2) -> x1 + x2.getStars(),
                        Integer::sum);
    }

    public void topRating(int num) {
        hostels.stream().filter(c -> c.getStars() > num)
                .map(x1 -> "Name: " + x1.getName() + " - " + x1.getStars() + " stars")
                .forEach(System.out::println);
    }

    public void hostelStars() {
        hostels.stream().collect(Collectors.toMap(Hostel::getName, Hostel::getStars))
                .entrySet().forEach(System.out::println);
    }
}



