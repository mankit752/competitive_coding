package com.learning;

public class SubsetSum {

    // Method to find two's complement
    static String findTwoscomplement(StringBuffer str)
    {
        int n = str.length();

        // Traverse the string to get first '1' from
        // the last of string
        int i;
        for (i = n-1 ; i >= 0 ; i--)
            if (str.charAt(i) == '1')
                break;

        // If there exists no '1' concat 1 at the
        // starting of string
        if (i == -1)
            return "1" + str;

        // Continue traversal after the position of
        // first '1'
        for (int k = i-1 ; k >= 0; k--)
        {
            //Just flip the values
            if (str.charAt(k) == '1') {
                str.replace(k, k + 1, "0");
                System.out.println(k +" = " +str);
            }
            else {
                str.replace(k, k + 1, "1");
                System.out.println(k +" = " +str);
            }
        }

        // return the modified string
        return str.toString();
    }

    // Driver method
    public static void main(String[] args)
    {
        StringBuffer str = new StringBuffer("00000101");
        System.out.println("Original = "+str);
        System.out.println(findTwoscomplement(str));
    }
}
