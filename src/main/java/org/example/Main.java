package org.example;

import InputLayer.InputParser.InputParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter an input:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        new InputParser(input);
    }
}