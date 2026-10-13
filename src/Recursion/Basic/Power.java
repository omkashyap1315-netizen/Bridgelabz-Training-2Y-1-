package Recursion.Basic;

public class Power {
    public static int pow(int p,int q){
        if(q==0){
            return 1;
        }
        int small = pow(p,q-1);
        return p*small;
    }
    public static void main(String[] args){
        int result = pow(5,4);
        System.out.println(result);
    }
}
