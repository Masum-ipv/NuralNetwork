package javaApplication1;

import java.util.Scanner;

public class runner {

    nuralNetwork nn = new nuralNetwork();

    private void taskManager() {
        nn.adjustWeight();
        System.out.println("Enter value of x");
        Scanner scan = new Scanner(System.in);
        double value = scan.nextDouble();
        System.out.println("Final output of y : " + value * nn.weight);
    }

    public static void main(String[] args) {
        new runner().taskManager();
    }

}
