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
public class QuickSort extends NumberList implements Sort{

    public QuickSort(int n) {
        super(n);
    }

    @Override
    public void sort() {
        quickSort(this.getArray(), 0, this.getArray().length - 1);
    }
    
    private void quickSort(int[] inputArray, int u, int v) {
        if (u > v) {
            return;
        }
        int i = u + 1;
        int j = v;
        while (true) {
            while (i < v) {
                if (inputArray[i] >= inputArray[u]) {
                    break;
                } else i++;
            }
            while (j > u) {
                if (inputArray[j] < inputArray[u]) {
                    break;
                } else j--;
            }
            if (i >= j) {
                break;
            } else swap(inputArray, i, j);
        }
        swap(inputArray, u, j);
        quickSort(inputArray, u, j - 1);
        quickSort(inputArray, j + 1, v);
    }
    
            
    
    private static void swap(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }

    
   
    

}
