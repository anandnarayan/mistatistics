package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static com.company.InputFileReader.GetFileData;

public class Main {
    static double minSupport = .5;
    static double minConfidence = .5;
    static  HashMap<Long,ArrayList<Long>> FileData = null;
    static double delta = .75;

    public static void main(String[] args) {
	// write your code here
        System.out.println("testing1");
        //Read the input file
        String filename = "F:\\EMDS\\Analytical Databases\\assignments\\Assign2\\retail1.txt";
        FileData = GetFileData(filename);
        //calculate minimum support for each item
        //min item support =>
        //Generate and Sort Minimum Support
        HashMap<Long,Double> itemVsInitialSupport = new HashMap<Long,Double>();
        InputFileReader.itemVsCountHashMap.forEach((k,v)->{
            itemVsInitialSupport.put(k,(v/FileData.size())* delta);
        });
        Stream<Map.Entry<Long,Double>> sorted = itemVsInitialSupport.entrySet().stream().sorted(Map.Entry.comparingByValue());

    }


}
