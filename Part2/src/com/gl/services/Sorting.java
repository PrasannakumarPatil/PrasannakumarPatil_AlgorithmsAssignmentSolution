package com.gl.services;

public class Sorting {

    public void MergeSort(double [] array, int left, int right, String order){
        if(left < right){
            int mid = (left + right) / 2;
            MergeSort(array, left, mid, order);
            MergeSort(array, mid + 1, right,order);
            Merge(array, left, mid, right, order);
        }
    }

    private void Merge(double [] array, int left, int mid , int right , String order){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double [] leftArray = new double[n1];
        double [] rightArray = new double[n2];

        for(int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];

        for(int i = 0; i < n2; i++)
            rightArray[i] = array[mid + 1 + i];

        int i = 0, j = 0;
        int k = left;

        while(i < n1 && j < n2){
            if(order=="descending") {
                if (leftArray[i] >= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }
            else {
                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }
        }

        while(i < n1){
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < n2){
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

