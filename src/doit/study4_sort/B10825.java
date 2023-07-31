package doit.study4_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][4];
        for (int i=0; i<n; i++) {
            arr[i] = br.readLine().split(" ");
        }

        Arrays.sort(arr,new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o2[1].equals(o1[1])){
                    if(o1[2].equals(o2[2])){
                        if(o1[3].equals(o2[3])){
                            return o1[0].compareTo(o2[0]);
                        }
                        return Integer.parseInt(o2[3])-Integer.parseInt(o1[3]);
                    }

                    return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);

                }
                return Integer.parseInt(o2[1])- Integer.parseInt(o1[1]);
            }
        });

        for (String[] strings : arr) {
            System.out.println(strings[0]);
        }
    }
}
