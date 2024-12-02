package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class Helper {
    protected static void switchTwoPositon(List<Integer> list, int indexPosA, int indexPosB){
        Integer value = list.get(indexPosA);
        list.set(indexPosA, list.get(indexPosB));
        list.set(indexPosB, value);
    }

    protected static void switchTwoPositon(int[] array, int indexPosA, int indexPosB){
        Integer value = array[indexPosA];
        array[indexPosA] = array[indexPosB];
        array[indexPosB] = value;
    }

    // Prüfen ob die Liste aufsteigends sortiert ist.
    protected static boolean isListSortedAsc(List<Integer> list){
        if (list != null){
          for(int i = 0; i < list.size(); i++){
            if(i == (list.size() - 1)){
                break;
            } else if(list.get(i) > list.get(i + 1)){
                return false;
            }
          }
          return true;
        } else{
            // Falls diese Methode als Abbruchbedingung verwendet wird, und keine Liste übergeben wird, 
            // dann wird trotzdem True zurückgegeben, damit man nicht in einer Endlosschleiffe festhängt.
            return true;
        }
      }
}
