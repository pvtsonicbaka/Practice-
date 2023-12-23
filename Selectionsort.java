import java.util.Random;
import java.util.Scanner;

public class Selectionsort {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Random r = new Random();
        sort a = new sort();
        int arr[] = new int[10];
        for(int i =0;i<arr.length;i++){
            arr[i] = r.nextInt(10);
        }
        a.print(arr);
        System.out.println();
        for(int i=0;i<arr.length-1;i++){
            int k =i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    k = j;
                }
            }
            int temp = arr[k];
            arr[k] =arr[i];
            arr[i]=temp; 
        }
        //a.selection(arr);
        System.out.println();
        a.print(arr);
        sc.close();
        

    }
}
class sort{
    void print(int a[]){
        for(int i:a){
            System.out.print(i+" ");
        }
    }
    
    void selection(int a[]){
        for(int i=0;i<a.length-1;i++){
            int k =i;
            for(int j = i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    k = j;
                }
            }
            int temp = a[k];
            a[k] =a[i];
            a[i]=temp; 
        }
    }
}