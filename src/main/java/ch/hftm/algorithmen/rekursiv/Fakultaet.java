package ch.hftm.algorithmen.rekursiv;

public class Fakultaet {
    public static int fak(int zahl){
        if(zahl <= 1){
            return 1;
        } else{
            return zahl * fak(--zahl);
        }
    }
}
