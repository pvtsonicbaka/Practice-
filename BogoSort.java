import java.util.Random;

public class BogoSort {

    public static void main(String[] args) {
        idk a  = new idk();
        Random r = new Random();
        
        int b[] = new int[13];
        for(int i=0;i<b.length;i++){
            b[i] = r.nextInt(1000);
        }
        a.BogoSor(b);
        a.diaplay(b);
        System.out.println("attempts"+a.atttempt);
    }
}
class idk{
    int atttempt = 0;
    Random r = new Random();
    void diaplay(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    
    void BogoSor(int a[]){
        while (!sortedOrnot(a)) {
            
        
        int index1 = r.nextInt(a.length);
        int index2 = r.nextInt(a.length);
        //swap 
        int temp = a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
        atttempt++;
        }
    }
    boolean sortedOrnot(int a[]){
        for(int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1]){
                return false;
            }

        }
        return true;
    }

}
