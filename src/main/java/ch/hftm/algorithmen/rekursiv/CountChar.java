package ch.hftm.algorithmen.rekursiv;


public class CountChar {
    public static int countChar(String s){
        return s.toCharArray().length;
    }

    public static int countChar(int z){
        return countChar(String.valueOf(z));
    }

    public static int countIntCharSelfmade(int z){
        if(z < 10){
            return 1;
        } else{
            return countIntCharSelfmade(z / 10) + 1;
        }
    }

    public static int countCharWithoutWhitespaceSelfmade(String s){
       return countCharWithoutWhitespaceSelfmade(s, 0);
    }

    private static int countCharWithoutWhitespaceSelfmade(String s, int i){
        int z = 0;
        if(i < (s.length() - 1)){
            if(s.charAt(i) != ' '){
                z++;
            }
            z += countCharWithoutWhitespaceSelfmade(s, ++i);
        } else{
            if(s.charAt(i) != ' '){
                z++;
            }
        }
        return z;
     }

}
