
import java.lang.Math;

public class Calc {
    public static long factorial(int num) {
        int i,fact=1;  
        int number=5;//It is the number to calculate factorial    
        for(i=1;i<=number;i++){    
            fact=fact*i;    
        }    
        return (long)fact;
    }
    public static long pow(int base, int exponent) {
        return (long)Math.pow((double)base,(double)exponent);
    }
}
