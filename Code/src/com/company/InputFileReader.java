package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.ArrayList;

/**
 * Created by anand on 3/22/2017.
 */
public class InputFileReader {
    static long TransactionID = 1;
    static HashMap<Long,Long> itemVsCountHashMap = new HashMap<Long,Long>();

    public static HashMap<Long,ArrayList<Long>> GetFileData(String filename) {
        HashMap<Long,ArrayList<Long>> TransactionMap = new HashMap<Long,ArrayList<Long>>();

        try(Stream<String> stream = Files.lines(Paths.get(filename)))
        {
            stream.forEach((str)->{
                System.out.println(str);
                if(!str.isEmpty())
                {
                    String transactionItemsStrings[] = str.split(" ");
                    ArrayList<Long> itemList = null;
                    for (String transaction: transactionItemsStrings)
                    {
                        itemList = new ArrayList<Long>();
                        Long item = Long.parseLong(transaction);
                        itemList.add(item);
                        if(itemVsCountHashMap.containsKey(item))
                        {
                            Long aLong = itemVsCountHashMap.get(item);
                            itemVsCountHashMap.put(item,++aLong);
                        }
                        else
                        {
                            itemVsCountHashMap.put(item, (long) 1);
                        }
                    }

                    if(!itemList.isEmpty())
                    {
                        Collections.sort(itemList);
                        TransactionMap.put(TransactionID,itemList);
                        ++TransactionID;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        TransactionID = 0;
        return TransactionMap;
    }
}
