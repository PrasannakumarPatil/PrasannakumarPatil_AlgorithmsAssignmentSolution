package com.gl.services;

public class FindStockValueIFExists {

    public String StockExists(double [] prices , double searchStock){

        Sorting sorting = new Sorting();
        sorting.MergeSort(prices, 0, prices.length-1, "ascending");
        if(binarySearch(prices, 0, prices.length-1, searchStock)!=-1)
            return "Stock of value"+ searchStock + " is present";
        return "Value not found";
    }



    int binarySearch(double prices[], int l, int r, double searchele)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (prices[mid] == searchele)
                return mid;
            if (prices[mid] > searchele)
                return binarySearch(prices, l, mid - 1, searchele);
            return binarySearch(prices, mid + 1, r, searchele);
        }
        return -1;
    }
}
