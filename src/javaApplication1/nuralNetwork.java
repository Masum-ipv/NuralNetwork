/**
 * y = wx
 * we have set of training data x
 * output target output data y
 * our target is find out the value of w(weight)
 */
package javaApplication1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author acm
 */
public class nuralNetwork {

    double learningRate = 0.01;
    double weight = 0.0;

    public void adjustWeight() {
        List<Double> trainingData = readFile("lib/input.txt");
        List<Double> targetOutput = readFile("lib/output.txt");
        while (true) {
            // Calculate weighted input
            double weightedSum = 0, error = 0.0;
            int errorCount = 0;
            for (int i = 0; i < trainingData.size(); i++) {
                weightedSum = trainingData.get(i) * weight;
                System.out.println("weightedSum output: " + weightedSum);

                error = targetOutput.get(i) - weightedSum;
                System.out.println("error output: " + error);

                if (error > 0.0000001) {
                    errorCount++;
                }
                // Update weights

                weight = weight + learningRate * error * trainingData.get(i);

                System.out.println("New weights: " + weight);
                System.out.println("*******************************************************");
            }
            // If there are no errors, stop
            if (errorCount == 0) {
                System.out.println("Final weights: " + weight);
                break;
            }
        }
    }

    public List<Double> readFile(String fileName) {
        List<Double> data = new ArrayList<Double>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data.add(Double.parseDouble(scanner.nextLine()));
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
