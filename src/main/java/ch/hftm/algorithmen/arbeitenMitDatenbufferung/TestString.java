package ch.hftm.algorithmen.arbeitenMitDatenbufferung;

public class TestString {
  public static void main(String[] args){
    // testStringChecker();
    testStringReverse();
  }
  
  public static void testStringChecker(){
    String testString;
    // testString = "{ [ egg ] }"; // true
    // testString = "{ [ ( ] ) }"; // false
    // testString = "{ [ ( ) ] ) }"; // false
    // testString = "{ [ ] ( ( ) ] ) }"; // false
    // testString = "( { [ ( ] ) }"; // false
    // testString = " { [ ( ] ) } )"; // false
    // testString = "{ [ ] ( ( ) ) }"; // true
    testString = """
      public static void bubbleSort(List<Integer> list){
        boolean listChanged;
        do{
            listChanged = false;
            for(int i = 0; i < (list.size() - 1); i++){
                if(list.get(i) > list.get(i + 1)){
                    Helper.switchTwoPositon(list, i, (i + 1));
                    listChanged = true;
                }
            }
        }while(listChanged == true);
      }
        """; // true
  
    System.out.println("TestString (" + testString + ") ist von den Klammern her " + (StringChecker.sindKlammernAusgeglichen(testString) ? "ausgeglichen" : "nicht ausgeglichen"));
  }


  public static void testStringReverse(){
    String testString;
    // testString = "abcdef";
    testString = "Hallo du!";

    System.out.println(testString + " -> " + StringRevers.reverseString(testString));
  }
}
