package com.project.terminal.crudterminal.dao;

import com.project.terminal.crudterminal.controller.AppController;

import java.text.ParseException;
import java.util.Scanner;

public class Helper {
    public static void backToMenu() throws ParseException {
        System.out.println("");
        System.out.print("Tekan [Enter] untuk kembali..");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        clearScreen();
        AppController.showProses();
    }

    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Mac OS")) {
                // clear screen untuk windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                // clear screen untuk Linux, Unix, Mac
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }
}
