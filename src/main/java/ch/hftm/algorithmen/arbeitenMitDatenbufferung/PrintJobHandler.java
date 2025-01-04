package ch.hftm.algorithmen.arbeitenMitDatenbufferung;

import ch.hftm.algorithmen.datenbufferung.ArrayQueueRingBufferGeneric;

public class PrintJobHandler {
  private ArrayQueueRingBufferGeneric<PrintJob> queue;
  
  public PrintJobHandler(int size){
    queue = new ArrayQueueRingBufferGeneric<>(size);
  }

  public void addPrintJob(PrintJob job){
    queue.insert(job);
  }

  public PrintJob processNextJob(){
    return queue.remove();
  }

  public void displayQueue(){
    System.out.println(queue.showAllEntries());
  }
  
}
