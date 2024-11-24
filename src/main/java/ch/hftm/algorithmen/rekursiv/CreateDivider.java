package ch.hftm.algorithmen.rekursiv;

public class CreateDivider {
    public static String createLine(String s, int length){
        if(length <= 1){
            return s;
        } else{
            return createLine(s, --length).concat(s);
        }
    }

    public static String createQuader(String s, int size){
        return createRectangle(s, size, size);
    }

    public static String createRectangle(String s, int row, int split){
        if(row <= 1){
            return "\n" + createLine(s, split);
        } else{
            return createRectangle(s, --row, split) + "\n" + createLine(s, split);
        }
    }
}
