package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    //Aufgabe 1
    public static void oneMonthCalendar(int tage, int ersterTag) {
        int zeilen; //Um Anzahl der zeilen des Kalenders zu bestimmen

        if ((tage + ersterTag)%7 != 0) {
            zeilen = (tage/7) +1;
        }
        else{
            zeilen = tage/7;
        }


        for (int i = 1; i < ersterTag; i++) {
            System.out.print("   ");
        }

        int count = 1;
        int column = ersterTag;

        for (int a = 0; a < zeilen; a++) {
            while (column <= 7) {
                System.out.printf("%2d ",count);
                if (count == tage){
                    System.out.println();
                    return;
                }
                column++;
                count++;
            }
            column =1;
            System.out.println();
        }
    }
    //Aufgabe 2
    public static long[] lcg(long seed){
        long modul = (long)Math.pow(2, 31); //2^31
        long c = 12345;
        long a = 1103515245;

        long[] zahlen = new long[11]; //Array aus long zahlen erstellt
        zahlen[0] = seed;

        //Startwert ist seed
        //Zufallszahlen werden so berechnet
        //X = (a*Xi + c)%m

        for (int i = 0; i < 10; i++) {
            zahlen[i+1] = (a * zahlen[i] + c)%modul;
        }
        //return zahlen;
        return Arrays.copyOfRange(zahlen, 1, zahlen.length);
    }
    //Aufgabe 3
    public static void guessingGame(int numberToGuess){
        Scanner scanner = new Scanner(System.in);
        int guessZahl;

        //10 Versuche
        for (int i = 1; i < 11; i++) {
            System.out.print("Guess number " + i + ":");
            guessZahl = scanner.nextInt();

            if (guessZahl == numberToGuess) {
                System.out.println(" You won wisenheimer!");
                break;
            } else if (i == 10) {
                System.out.println(" You lost! Have you ever heard of divide & conquer?");
                break;
            } else if (guessZahl > numberToGuess) {
                System.out.println(" The number AI picked is lower than your guess.");
            }else {
                System.out.println(" The number AI picked is higher than your guess.");
            }
        }
    }
    //Random Zahl für Aufgabe 3 generieren
    public static int randomNumberBetweenOneAndHundred(){
        int min = 1;
        int max = 100;
        int zufallszahl = (int) (Math.random()*(max-min)) + min;
        return zufallszahl;
    }
    //Aufgabe 4
    public static boolean swapArrays(int arr1[], int arr2[]){
        if(arr1.length != arr2.length){
            return false;
        } else{
            for(int i = 0 ; i<arr1.length;i++){
                arr1[i] = arr1[i] - arr2[i];
                arr2[i] = arr2[i] + arr1[i];
                arr1[i] = arr2[i] - arr1[i];
            }
        } return true;
    }
    //Aufgabe 5
    public static String camelCase(String satz){
        char[] c = satz.toCharArray();

        if (c[0] >= 97 && c[0] <= 122)
            c[0] -= 32;

        for (int i = 0; i < c.length; i++) {
            if (i >= 1 && c[i-1] == ' ' && c[i] >= 97 && c[i] <= 122){
                c[i] -= 32;
            }
            if (i >= 1 && c[i-1] != ' ' && c[i] >= 65 && c[i] <= 90){
                c[i] += 32;
            }
        }

        for (int i = 0; i < c.length; i++) {
            if ((c[i] > 0 && c[i] <= 64) || (c[i] >= 91 && c[i] <= 96) || (c[i] >= 123 && c[i] <= 127)){
                c[i] = 32;
            }
        }

        String ohneL = String.valueOf(c).replace(" ", "");
        return ohneL;

    }
    //Aufgabe 6
    public static int checkDigit(int arr[]){
        int gewichtung = 2;
        int sum = 0;
        int rest;
        int zahl;

        for (int i = 0; i < arr.length; i++) {
                sum += arr[i] * (gewichtung+i);
            }
            rest = sum%11;
            zahl = 11 - rest;
            if (zahl == 10) {
                return 0;
            } else if (zahl == 11) {
                return 5;
            } else {
                return zahl;
            }
    }
    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        System.out.println("Aufgabe 1:");
        oneMonthCalendar(31, 3);
        System.out.println(); //für einen Abstand zwischen den Aufgaben

        System.out.println("Aufgabe 2:");
        lcg(12345);
        System.out.println();

        System.out.println("Aufgabe 3:");
        guessingGame(randomNumberBetweenOneAndHundred());
        System.out.println();

        System.out.println("Aufgabe 4:");
        int arr1[] = new int[]{1, 2, 3};
        int arr2[] = new int[]{1, 2, 3};

        swapArrays(arr1, arr2);
        System.out.println();

        System.out.println("Aufgabe 5:");
        camelCase("my name isn't Alice");
        System.out.println();

        System.out.println("Aufgabe 6:");
        int arr3[] = new int[]{1, 2, 3, 4, 6};
        checkDigit(arr3);
        System.out.println();


    }
}