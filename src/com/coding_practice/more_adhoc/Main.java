package com.coding_practice.more_adhoc;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        Integer noOfDays= 0 , month = 0 , sizeOfBar= 0 , ways = 0;
        for(int i = 0; i < s.size() ; i++) {
            while( ++noOfDays <= m ) {
                sizeOfBar += s.get(i);
                if(sizeOfBar > d){
                    noOfDays = 0;
                    sizeOfBar = 0;
                    break;
                }
                else if(sizeOfBar == d && noOfDays == m) {
                    ways++;
                    sizeOfBar = 0;
                    noOfDays = 0;
                    break;
                }
                else if(sizeOfBar < d && noOfDays == m){
                    noOfDays = 0;
                    sizeOfBar = 0;
                    break;
                }
            }

        }
        return ways;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int w = (int)8.888;
        byte x = (byte)100L;
        long y = (byte)100;


        final int i = 1;



        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
