
package unit8;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Sorting s = new Sorting();
        double RAND_MAX = 100;
        double max = 1000;
        double min = 0;
        double[] d = new double[100];
        for (int i = 0; i < 100; i++) {
            d[i] = (((double) Math.random() / RAND_MAX) * (max - min)) + min;
        }
        s.setData(d);
        //s.printArray();
        System.out.println("--");
        s.shellSort(d);
        s.printArray();
    }
    
}
