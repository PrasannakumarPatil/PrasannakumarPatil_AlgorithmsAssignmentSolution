package com.gl.services;

public class StockRoseORFall {

    public int NumberOfStockRose(boolean [] riseorfall ,String value){
        int count=0;
        if(value=="rise") {
            for (int i = 0; i < riseorfall.length; i++) {
                if (riseorfall[i]) {
                    count++;
                }
            }
            return count;
        }
        else{
            for (int i = 0; i < riseorfall.length; i++) {
                if (!riseorfall[i]) {
                    count++;
                }
            }
            return count;
        }
    }

}
