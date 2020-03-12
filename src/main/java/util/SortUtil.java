package util;

import java.util.Arrays;

/**
 * 各种排序算法
 */
public class SortUtil {

    //冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr,int start,int end){
        if(start<end){
            int low=start;
            int high=end;
            int init=arr[start];
            while (low<high){
                while (low<high&&arr[high]>=init){
                    high--;
                }
                arr[low]=arr[high];
                while (low<high&&arr[start]<=init){
                    low++;
                }
                arr[high]=arr[low];
            }
            arr[low]=init;
            quickSort(arr,start,low);
            quickSort(arr,low+1,end);

        }

    }
    //快速排序,将一组数组中的偶数全部放在后面，奇数全部放在前面
    public static void quickSort2(int[] arr,int start,int end){
            int low=start;
            int high=end;
            while (low<high){
                while (low<high&&arr[high]%2==0){
                    high--;
                }
                while (low<high&&arr[low]%2!=0){
                    low++;
                }
                if(low<high){
                    int temp=arr[low];
                    arr[low]=arr[high];
                    arr[high]=temp;
                }

            }
    }

    //
    public static void insertSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                int j=i-1;
                int x=arr[i];
                while(j>0&arr[j]>arr[i]){
                    j--;
                    arr[j]=x;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr=new int[]{1,3,5,2,2,8,9,10,3,34,2,3,7,33,88};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
        quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
