
package unit8;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Sorting s = new Sorting();
        double RAND_MAX = 10;
        double max = 1000;
        double min = 0;
        double[] d = new double[1000];
        for (int i = 0; i < 1000; i++) {
            d[i] = (((double) Math.random() / RAND_MAX) * (max - min)) + min;
        }
        
        
        s.setData(d);
        System.out.println("Insertion Sort--");
        s.insertionSort(d);
        s.printArray();
        
        System.out.println("");

        s.setData(d);
        System.out.println("Selection Sort--");
        s.selectionSort(d);
        s.printArray();
        
        System.out.println("");

        s.setData(d);
        System.out.println("Shell Sort--");
        s.shellSort(d);
        s.printArray();

        System.out.println("");

        s.setData(d);
        System.out.println("Merge Sort--");
        s.mergeSort(d);
        s.printArray();
        
        /*
        In order of effeciency (time and iterations):
            1) On average, Merge Sort was both the fastest, and requried the least iterations
                -  Since Merge Sort works recursively, and divides the list in half each iteration, it is O(nlogn), the fastest on this list
            2) Shell Sort
                - With a best case of O(nlogn), it is just behind Merge Sort (Worst case of O(n^2)), which is why it is a bit slower
                - Since the gap of the "shell" reduces each time, the iterations become faster and faster
            3) Insertion Sort
                - Has best case of O(n), and a worst case of O(n^2)
                - Insertion sort looks at every element in the list, but skips over the ones that are already sorted (if none are sorted it will be O(n^2), making it ineffecient)
            4) Selection Sort
                - The least effecient and worst sorting method for large data groups, as even if items are in order, Selection Sort will go though looking at every element, to find a smaller one, making it O(n^2)
         */
    }
    
}
