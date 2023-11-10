import java.util.*;
class InputAndCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ENter input size");
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<a.length;i++){
            a[i] = sc.nextInt();

        }
        //search
        System.out.println("enter search element");
        int num = sc.nextInt();
        for(int i=0;i<a.length;i++){
            if(a[i]==num){
                System.out.println(num +" is foound on index: "+ i);
            }
        }
        sc.close();
    }
}