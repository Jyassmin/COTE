package doit.study4_sort;

/*문제 : 알고리즘 수업 - 버블정렬 3*/

/*문제 이해
 * N개의 서로 다른 양의 정수가 저장된 배열 A
 * 배열 A를 오름차순 정렬한다.
 * 배열 A를 오름차순 정렬하는 과정에서 배열 B가 나오는지 확인하는 프로그램*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*접근법
 * 0. 버블정렬을 구현한다.
 * 1. 배열의 크기를 입력받는다.
 * 2. 배열의 크기에 따른 배열A와 배열B를 넣는다.
 * 3. 배열 A를 swap을 한번씩 할 때마다 배열 B와 비교해서, 같다면 flag를 true로 바꿔준다.
 * 4. flag가 true라면 1을, 아니라면 0을 출력한다.*/
public class B23970_new {
    private static boolean flag = false; // 배열 B와 같은 경우를 판단하는 역할

    private static int[] B;//배열 B

    public static void boubleSort(int[] arr){

        if(Arrays.equals(arr,B)){//Arrays.equals를 해야지 배열 참조 값이 아닌 값 비교가 된다. -> 추가 공부할 것
            flag =true;
        }
        for(int i =0;i<arr.length;i++){ // i의 역할 : 배열 값의 개수 -> 정렬된 수의 개수를 의미

            boolean swapped = false;//test

            for(int j=0;j<arr.length-i-1;j++){ //j의 역할 : 비교할 인덱스 -> 정렬된 갯수에 따라서 비교하는 횟수
                if(arr[j]>arr[j+1]){ //swap을 한다 -> 앞이 뒤 보다 크다.

                    //틀렸다는 건 반례가 있다는 뜻이겠지?
                    //처음부터 A와 B가 같다면 swap하기 전에 확인을 해야한다.
//                    if(Arrays.equals(arr,B)){//Arrays.equals를 해야지 배열 참조 값이 아닌 값 비교가 된다. -> 추가 공부할 것
//                        flag =true;
//                    }//이건 왜 시간 초과가 뜰까? -> 버블 정렬이 시간을 잡아먹긴 한다.!!!!

                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;

                    swapped =true;
                    //바꿔주고 나서 만약에 바뀐 상태가 배열 B와 같다면? 을 넣어줘야겠다.
                    //문제 : 배열 2개의 값을 비교하는 방법이 뭐지?
//                    System.out.println(arr.toString()); -> 이렇게 출력하면 안나옴
//                    System.out.println(Arrays.toString(arr));
//                    System.out.println(Arrays.toString(B));
                    //틀렸다는 건 반례가 있다는 뜻이겠지?
                    //처음부터 A와 B가 같다면 swap하기 전에 확인을 해야한다.

                    if(arr[j]==B[j] && arr[j+1]==B[j+1]) {
                        if(Arrays.equals(arr,B)){//Arrays.equals를 해야지 배열 참조 값이 아닌 값 비교가 된다. -> 추가 공부할 것
                            flag =true;
                            break;
                        }
                    }

                }
            }
            if (swapped ==false){
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*1. 배열의 크기를 입력 받는다.*/
        int N = Integer.parseInt(br.readLine());

        /*2. 배열의 크기에 따른 배열 A와 B는 만들고 데이터를 넣는다.*/
        int[] A = new int[N];
        B = new int[N];

        String first = (br.readLine());
        String second = (br.readLine());

        StringTokenizer st1 = new StringTokenizer(first);
        StringTokenizer st2 = new StringTokenizer(second);


        for(int i=0;i<N;i++){
            A[i]= Integer.parseInt(st1.nextToken());
            B[i]= Integer.parseInt(st2.nextToken());
        }

        //여기까지 했으면 배열 A,B에 값이 들어있다.

        /*3. 배열 A를 swap할 때마다 배열 B와 비교해서, 맞다면 flag를 true로 바꿔준다.*/
        boubleSort(A);
        if(flag==true){
            System.out.println(1);
        }else System.out.println(0);


    }
}
