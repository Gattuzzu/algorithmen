package ch.hftm.algorithmen.algorithmen;

import java.util.Collections;
import java.util.List;

public class BogoSort {
  // Dieser Sortieralgorithmus ist in der Geschwindigkeit zwischen 0ms - unendlich.
  // Der Sortieralgorithmus basiert auf Zufall.
  public static void bogoSort(List<Integer> list){
    while(!Helper.isListSortedAsc(list)){
      Collections.shuffle(list);
    }
  }

}
