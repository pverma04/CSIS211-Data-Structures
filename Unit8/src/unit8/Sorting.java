package unit8;

import java.util.ArrayList;

public class Sorting {

    private double[] mDataArray;
    private Timer mT;
    private int mIterations;

    public Sorting() {
        this(null);
    }

    public Sorting(double[] data) {
        this.mDataArray = data;
        this.mIterations = 0;
    }

    /**
     * ***********************************************
     * @par Name setData
     * @purpose Sets the data to a new double[]
     * @param [in] : double[] newData
     * @return None ***********************************************
     */
    public void setData(double[] newData) {
        this.mDataArray = newData;
    }
    
    /**
     * ***********************************************
     * @par Name getIterations
     * @purpose Gets the number of iterations of the last sort
     * @param [in] : None
     * @return Int ***********************************************
     */
    public int getIterations() {
        return this.mIterations;
    }
    
    /**
     * ***********************************************
     * @par Name insertionSort
     * @purpose Follows the insertion sort algorithm
     * @param [in] : double[] arr
     * @return None ***********************************************
     */
    public void insertionSort(double[] arr) {
        mT = new Timer();
        mT.startTimer();
        this.mIterations = 0;
        for (int i = 1; i < arr.length; i++) { //start at index 1, to compare a value to the left
            double current = arr[i];
            int j = i - 1; //position to the left of current index

            while ((j >= 0) && (arr[j] > current)) { //if directly to the left, the number is bigger, swap
                arr[j + 1] = arr[j];
                j = j - 1;
                mIterations++;
            }
            arr[j + 1] = current; //"current" has now be sorted
            mIterations++;
        }
        this.mDataArray = arr;
        mT.stopTimer();
    }
    
    /**
     * ***********************************************
     * @par Name selectionSort
     * @purpose Follows the selection sort algorithm
     * @param [in] : double[] arr
     * @return None ***********************************************
     */
    public void selectionSort(double [] arr) {
        mT = new Timer();
        mT.startTimer();
        this.mIterations = 0;
        int indexMin;
        for (int i = 0; i < arr.length - 1; i++) {
            indexMin = i; //min is set to the start of the unsorted portion of the array
            for (int j = i + 1; j < arr.length; j++) { //loop through to find min index
                if (arr[j] < arr[indexMin]) { //find and replace indexMin with "j", if number is smaller
                    indexMin = j; 
                }
                mIterations++;
            }
            double temp = arr[indexMin]; //now indexMin has been set to the smallest value of the unsorted array
            arr[indexMin] = arr[i]; //swap i and indexMin
            arr[i] = temp; //after this continue moving down the array
            mIterations++;
        }
        this.mDataArray = arr;
        mT.stopTimer();
    }
   
    /*
    private int choosePivot(int a, int b) {
        return ((a + b) / 2);
    }
    
    private void swap(double[] arr, int posA, int posB) {
        double temp = arr[posA];
        arr[posA] = arr[posB];
        arr[posB] = temp;
    }
    */
    public void mergeSort(double[] arr) {
        mT = new Timer();
        mT.startTimer();
        this.mIterations = 0;
        int inputLength = arr.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        double[] leftHalf = new double[midIndex];
        double[] rightHalf = new double[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = arr[i];
            this.mIterations++;
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = arr[i];
            this.mIterations++;
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);
        this.mDataArray = arr;
        mT.stopTimer();
    }

    private void merge(double[] arr, double[] leftHalf, double[] rightHalf) {

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
            this.mIterations++;
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftHalf[i];
            i++;
            k++;
            this.mIterations++;
        }

        while (j < rightSize) {
            arr[k] = rightHalf[j];
            j++;
            k++;
            this.mIterations++;
        }
    }
    
    public void shellSort(double [] arr) {
        mT = new Timer();
        mT.startTimer();
        this.mIterations = 0;
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap /= 2) { //reduce gap each time program recurs
            
            for (int i = gap; i < len; i++) { //go through entire gap
                double temp = arr[i];
                int j;
                for (j = i; (j >= gap) && (arr[j - gap] > temp); j -= gap) { 
                    arr[j] = arr[j - gap];
                    this.mIterations++;
                }
                arr[j] = temp;
                this.mIterations++;
            }
            this.mIterations++;
        }
        this.mDataArray = arr;
        mT.stopTimer();
    }
    
    public double printMicro(){
        return mT.getMicro();
    }
    public double printMilli() {
        return mT.getMilli();
    }
    public double printSec() {
        return mT.getSecond();
    }
    public void printArray(){
        String rv = "[";
        for (int i = 0; i < this.mDataArray.length - 1; i++) {
            rv += this.mDataArray[i] + ", ";
        } 
        rv += this.mDataArray[this.mDataArray.length - 1] + "]";
        System.out.println(rv);
        
        System.out.println("Microseconds: " + this.printMicro());
        //System.out.println("Milliseconds: " + this.printMilli());
        //System.out.println("Seconds: " + this.printSec());
        System.out.println("Iter: " + this.getIterations());
    }
    
} 
