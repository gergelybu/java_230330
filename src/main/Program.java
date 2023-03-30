package main;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bmiFeladat();
    }

    private static void bmiFeladat() {
        kiir("BMI kiszámítása");

        int also = 100;
        int felso = 200;
        String s = "Testmagassag [%d; %d]: ".formatted(also, felso);
        int m = beker(s, also, felso);

        also = 40;
        felso = 150;
        s = "Testtömeg [%d; %d]: ".formatted(also, felso);
        int t = beker(s, also, felso);

        double bmi = bmiSzamit(t, m);
        erkeles(bmi, t, m);
    }

    private static void kiir(String szoveg) {
        System.out.println(szoveg);
    }

    private static int beker(String kerdes, int min, int max) {
        int be = 0;
        while (be > max || be < min) {
            System.out.print(kerdes);
            be = sc.nextInt();
        }
        //do{jo = be >= also && szam <= felso;}while(!jo)
        return be;
    }

    private static double bmiSzamit(int t, int m) {
        return t / Math.pow(m / 100.0, 2);
    }

    private static void erkeles(Double bmi, int t, int m) {
        String szoveg = "Ön ... m: %d, t: %d, bmi: %.1f, Tehát Ön ";
        String kimenet = String.format(Locale.UK, szoveg, m, t, bmi);
        if (bmi < 20) {
            kimenet += "sovány!";
        } else if (bmi < 25) {
            kimenet += "normál!";
        } else if (bmi < 30) {
            kimenet += "túlsúlyos!";
        } else if (bmi < 40) {
            kimenet += "elhízott!";
        } else {
            kimenet += "kórosan elhízott!";
        }
        kiir(kimenet);
    }

}
