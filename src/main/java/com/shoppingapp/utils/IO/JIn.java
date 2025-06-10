package com.shoppingapp.utils.IO;
import java.util.Scanner;


public class JIn {
    private Scanner scanner;
    public JIn() {
        scanner = new Scanner(System.in);
    }
    public int i() {
        return scanner.nextInt();
    }
    public double d() {
        return scanner.nextDouble();
    }
    public String s() {
        return scanner.next();
    }
    public long l() {
        return scanner.nextLong();
    }
}
