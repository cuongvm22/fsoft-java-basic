/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex4;

/**
 * 
 * @date Jun 18, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class SelectionSort extends NumberList implements Sort{

    public SelectionSort(int n) {
        super(n);
    }

    @Override
    public void sort() {
        selectionSort(this.getArray(), 0, this.getArray().length);
    }
    
    public void selectionSort(int[] inputArray, int u, int v){
        if (u >= v) return;
        int point = getMin(inputArray, u, v);
        for (int i = u; i < v; i ++){
            if (inputArray[i] == point){
                swap(inputArray, u, i);
                break;
            }
        }
    
        selectionSort(inputArray, u + 1, v);
    }
    
    private int getMin(int[] inputArray, int u, int v){
        int result = inputArray[u];
        for (int j = u + 1; j < v; j++ )
            result = (result < inputArray[j])?  result : inputArray[j];
        return result;
    }
    
    private static void swap(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }
}
