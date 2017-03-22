package com.company;

import java.util.HashMap;

import static com.company.InputFileReader.GetFileData;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("testing1");
        //Read the input file
        String filename = "F:\\EMDS\\Analytical Databases\\assignments\\Assign2\\retail1.txt";
        HashMap<Long,Long> FileData = GetFileData(filename);
    }


}
