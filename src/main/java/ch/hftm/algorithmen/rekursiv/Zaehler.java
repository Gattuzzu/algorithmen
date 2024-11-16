package ch.hftm.algorithmen.rekursiv;

public class Zaehler {
    public static String countDown(int zahl) {
        if (zahl > 0) {
            return zahl + " " + countDown(--zahl);
        }
        return "" + zahl;
    }

    public static String countUp(int start, int end) {
        if (start < end) {
            return start + " " + countUp(++start, end);
        }
        return "" + end;
    }

    public static String countUp(int zahl) {
        if (zahl > 0) {
            int origZahl = zahl;
            return countUp(--zahl) + " " + origZahl;
        }
        return "" + zahl;
    }
}
