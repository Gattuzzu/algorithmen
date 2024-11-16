package ch.hftm.algorithmen.rekursiv;

public class Fibonacci {
    public static int fibonacci(int zahl){
        if(zahl == 0){
            return 0;
        } else if(zahl  <= 2){
            return 1;
        } else{
            return fibonacci(--zahl) + fibonacci(--zahl); // Hier wird zweimal -1 gerechnet. (Beim ersten mal -1 und beim zweiten Aufrug zu dem ersten -1 nochmals -1)
        }
    }
}
