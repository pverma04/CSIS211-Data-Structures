package unit8;

import java.util.ArrayList;

public class Sorting {

    double[] dataArray;
    Timer t;
    int iterations;

    public Sorting() {
        this(null);
    }

    public Sorting(double[] data) {
        this.dataArray = data;
        this.iterations = 0;
    }

    public void setData(double[] newData) {
        this.dataArray = newData;
    }
    
    public void insertionSort(double[] arr) {
        t = new Timer();
        t.startTimer();
        for (int i = 1; i < arr.length; i++) { //start at index 1, to compare a value to the left
            double current = arr[i];
            int j = i - 1; //position to the left of current index

            while ((j >= 0) && (arr[j] > current)) { //if directly to the left, the number is bigger, swap
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = current; //"current" has now be sorted
        }
        this.dataArray = arr;
        t.stopTimer();
    }
    
    public void selectionSort(double [] arr) {
        t = new Timer();
        t.startTimer();
        int indexMin;
        for (int i = 0; i < arr.length - 1; i++) {
            indexMin = i; //min is set to the start of the unsorted portion of the array
            for (int j = i + 1; j < arr.length; j++) { //loop through to find min index
                if (arr[j] < arr[indexMin]) { //find and replace indexMin with "j", if number is smaller
                    indexMin = j; 
                }
            }
            double temp = arr[indexMin]; //now indexMin has been set to the smallest value of the unsorted array
            arr[indexMin] = arr[i]; //swap i and indexMin
            arr[i] = temp; //after this continue moving down the array
        }
        this.dataArray = arr;
        t.stopTimer();
    }
   
    private int choosePivot(int a, int b) {
        return ((a + b) / 2);
    }
    private void swap(double[] arr, int posA, int posB) {
        double temp = arr[posA];
        arr[posA] = arr[posB];
        arr[posB] = temp;
    }
    public void mergeSort(double[] arr) {
        t = new Timer();
        t.startTimer();
        int inputLength = arr.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        double[] leftHalf = new double[midIndex];
        double[] rightHalf = new double[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = arr[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = arr[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);
        this.dataArray = arr;
        t.stopTimer();
    }

    private static void merge(double[] arr, double[] leftHalf, double[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                arr[k] = leftHalf[i];
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }
    
    public void shellSort(double [] arr) {
        t = new Timer();
        t.startTimer();
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap /= 2) { //reduce gap each time program recurs
            
            for (int i = gap; i < len; i++) { //go through entire gap
                double temp = arr[i];
                int j;
                for (j = i; (j >= gap) && (arr[j - gap] > temp); j -= gap) { 
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        this.dataArray = arr;
        t.stopTimer();
    }
    
    public double printMicro(){
        return t.getMicro();
    }
    public double printMilli() {
        return t.getMilli();
    }
    public double printSec() {
        return t.getSecond();
    }
    public void printArray(){
        String rv = "[";
        for (int i = 0; i < this.dataArray.length - 1; i++) {
            rv += this.dataArray[i] + ", ";
        } 
        rv += this.dataArray[this.dataArray.length - 1] + "]";
        System.out.println(rv);
        /*
        System.out.println("Microseconds: " + this.printMicro());
        System.out.println("Milliseconds: " + this.printMilli());
*/
        System.out.println("Seconds: " + this.printSec());
        

    }
    
}
