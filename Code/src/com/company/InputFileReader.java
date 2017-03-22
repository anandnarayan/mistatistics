package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by anand on 3/22/2017.
 */
public class InputFileReader {


    public static HashMap<Long,Long> GetFileData(String filename) {
        HashMap<Long,Long> TransactionMap = new HashMap<Long,Long>();
        long TransactionID = 1;
        try(Stream<String> stream = Files.lines(Paths.get(filename)))
        {
            stream.forEach((str,Trans)->{
                System.out.println(str);
                if(!str.isEmpty())
                {
                    String transactionItemsStrings[] = str.split(" ");
                    for (String transaction: transactionItemsStrings)
                    {
                    TransactionMap.put(TransactionID,Long.parseLong(transaction));
                        TransactionID++;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TransactionMap;
    }
}
