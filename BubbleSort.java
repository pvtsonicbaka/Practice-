import java.util.Random;
import java.util.Scanner;

class BubbleSort{
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
        a.bubble(arr);
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
    void bubble(int a[]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    //swap
                    // a[i] = a[i]^a[i+1];
                    // a[i+1] = a[i]^a[i+1];
                    // a[i] =a[i]^a[i+1];
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
    }
}