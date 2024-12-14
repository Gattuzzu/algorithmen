package ch.hftm.algorithmen.rekursiv;

public class Baum {

  // public static void zeichneBaum(int level, int maxLevel){
  //   if (level == maxLevel){
  //     System.out.println("Level " + level + ": *");
  //     return;
  //   } else{
  //     zeichneBaum(level + 1, maxLevel);
  //     System.out.println("Level " + level + ": *");
  //   }
  // }


  /*
   * Aufruf:
   *  zeichneBaum(1, 4);
   * Ausgabe:
   *  Level 4: *
   *  Level 3: ***
   *  Level 2: *****
   *  Level 1: *******
   */
  

   public static void main(String[] args){
    zeichneBaum(1, 4);

    int[] array = {1,3,7,9,11,15,20};
    int target = 9;
    int index = binarySearch(array, target, 0, array.length -1);
   }


  public static void zeichneBaum(int level, int maxLevel){
    if(level > maxLevel){
      return;
    } else{
      System.out.println("Level " + (maxLevel - level + 1) +":" + stars(((level -1)*2)+1));
      zeichneBaum(++level, maxLevel);
      return;
    }
  } 

  private static String stars(int anzahl){
    if(anzahl <= 0){
      return "";
    } else{
      return "*" + stars(--anzahl);
    }
  }


  public static int binarySearch(int[] array, int gesuchtesElement, int untererIndex, int obererIndex){
    if (untererIndex > obererIndex){
      return -1;
    }

    int mitte = (untererIndex + obererIndex) / 2;

    if (array[mitte] == gesuchtesElement){
      return mitte;
    }

    if(array[mitte] < gesuchtesElement){
      return binarySearch(array, gesuchtesElement, mitte + 1, obererIndex);
    } else{
      return binarySearch(array, gesuchtesElement, untererIndex, mitte -1);
    }
  }
}