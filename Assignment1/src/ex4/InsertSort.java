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
public class InsertSort extends NumberList implements Sort{

    public InsertSort(int n) {
        super(n);
    }

    @Override
    public void sort() {
        insertSort(this.getArray(), 0, this.getArray().length, 0);
    }
    private void insertSort(int[] inputArray, int u, int v, int n){
        if (n == 0) insertSort(inputArray, u, v, n+1);
        else if (n == v) return;
        else {
            if (inputArray[n] < inputArray[0]){
                int temp = inputArray[n];
                for (int i = n; i > 0; i-- ) inputArray[i] = inputArray[i - 1];
                inputArray[0] = temp;
                insertSort(inputArray, u, v, n+1);
            } else if (inputArray[n] > inputArray[n-1])
                insertSort(inputArray, u, v, n+1);
            else {
                for (int i = n - 1; i > 0; i--){
                    if ((inputArray[i] > inputArray[n]) && (inputArray[n]>inputArray[i - 1])){
                        int temp = inputArray[n];
                        for (int j = n; j > i; j --){
                            inputArray[j] = inputArray[j-1];
                        }
                        inputArray[i] = temp;
                        break;
                    }
                }
                insertSort(inputArray, u, v, n+1);
            }
        }
    }
}
