package org.util.tbo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());

            String[] arr_Arr = br.readLine().split(" ");
            int[] Arr = new int[N];
            for(int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
            {
                Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
            }

            long out_ = solve(N, M, Arr);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static long solve(int N, int M, int[] Arr){
        // Write your code here
        long result = 0;
        for(int i =1;i+M<=Arr.length;i++){

        }
        return result;

    }

}
