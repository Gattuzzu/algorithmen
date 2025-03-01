package ch.hftm.algorithmen.pruefungssimmulation.pruefung;

import ch.hftm.algorithmen.pruefungssimmulation.MyStack;

public class BrowserTabs {
  // Wählen Sie eine passende Datenstruktur (Stack oder LinkedList)
  // Ein Stack ist für dieses Aufgabe ideal geeignet. Da man das verhalten LIFO beim zurückgehen möchte.
  // Eine doppelt verlinkte Liste würde sich insbesodere eigenen, wenn man sowohl vorwärs wie rückwärts möchte in der Page möchte.
  private String actPage = null;
  private MyStack stack = new MyStack();

  public void openTab(String url) {
    // Legt ein neues Tab "oben" an
    if(url != null){

      if(actPage != null){
        stack.push(actPage);
      }
      actPage = url;
    }
  }

  public String switchToPreviousTab() {
    // Schließt das aktuelle Tab und gibt die URL zurück
    // Danach ist das vorherige Tab aktiv
    String oldPage = actPage;
    actPage = stack.pop();
    return oldPage;
  }

  public String getActPage(){
    return actPage == null ? "" : actPage;
  }

  public static void main(String[] args){
    BrowserTabs tabs = new BrowserTabs();
    tabs.openTab("1");
    tabs.openTab("2");
    tabs.openTab("3");

    System.out.println("oldPage = " + tabs.switchToPreviousTab()); // oldpage = 3
    System.out.println("actPage = " + tabs.getActPage()); // actPage = 2

    System.out.println("oldPage = " + tabs.switchToPreviousTab()); // oldpage = 2
    System.out.println("actPage = " + tabs.getActPage()); // actPage = 3
  }

}