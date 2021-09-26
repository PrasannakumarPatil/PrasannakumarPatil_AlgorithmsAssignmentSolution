package com.gl.main;

import com.gl.services.FindStockValueIFExists;
import com.gl.services.Sorting;
import com.gl.services.StockRoseORFall;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the no of companies");
        int numberOfCompanies = scanner.nextInt();
        int count = 1;
        double[] prices = new double[numberOfCompanies];
        boolean[] riseorfall = new boolean[numberOfCompanies];
       for(int i=0;i<numberOfCompanies;i++) {
           System.out.println("Enter current stock price of the company " + count++);
           prices[i] = scanner.nextDouble();
           System.out.println("Whether company's stock price rose today compare to yesterday?");
           boolean value = Boolean.parseBoolean(scanner.next().toLowerCase());
           riseorfall[i]=value;
//           System.out.println(value);

       }
        Sorting sorting = new Sorting();
        StockRoseORFall stockRoseORFall = new StockRoseORFall();
        FindStockValueIFExists findStockValueIFExists = new FindStockValueIFExists();
      int choice ;
        do {

            System.out.println("-----------------------------------------------");
            System.out.println("Enter the operation that you want to perform");


            System.out.println("1. Display the companies stock prices in ascending order");
            System.out.println("2. Display the companies stock prices in descending order");
            System.out.println("3. Display the total no of companies for which stock prices rose today");
            System.out.println("4. Display the total no of companies for which stock prices declined today");
            System.out.println("5. Search a specific stock price");
            System.out.println("6. press 0 to exit");
            choice = scanner.nextInt();
            String order;
            switch (choice) {
                case 0:
                    System.out.println("Exited successfully");
                    break;
                case 1:
                    order = "ascending";
                    sorting.MergeSort(prices, 0, numberOfCompanies - 1, order);
                    print(prices, order);
                    break;
                case 2:
                    order ="descending";
                    sorting.MergeSort(prices, 0, numberOfCompanies - 1, order);
                    print(prices, order);
                    break;
                case 3:
                    System.out.print("Total no of companies whose stock price declined today : ");
                    System.out.println(stockRoseORFall.NumberOfStockRose(riseorfall,"rise"));
                    break;
                case 4:
                    System.out.print("Total no of companies whose stock price rose today : ");
                    System.out.println(stockRoseORFall.NumberOfStockRose(riseorfall,"decline"));
                    break;
                case 5:
                    System.out.println("enter the key value");
                    System.out.println(findStockValueIFExists.StockExists(prices, scanner.nextDouble()));
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }while (choice!=0);

    }
    public static void print(double[] prices,String  order) {

        System.out.println("Stock prices in " +order+" are:");
        for(double a: prices){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println();
    }
}
