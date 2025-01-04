package ch.hftm.algorithmen.arbeitenMitDatenbufferung;

public class TestPrintJob {
  public static void main(String[] args){
    testPrintJob();
  }

  private static void testPrintJob(){
    PrintJobHandler printerQueue = new PrintJobHandler(3);

    printerQueue.addPrintJob(new PrintJob(5, "Das ist der erste Ausdruck", PrintJob.Priority.middle));
    printerQueue.addPrintJob(new PrintJob(2, "Das ist der zweite Ausdruck", PrintJob.Priority.low));
    printerQueue.addPrintJob(new PrintJob(5, "Das ist der dritte Ausdruck", PrintJob.Priority.high));
    
    printerQueue.displayQueue();
    System.out.println("Erledigter Printjob: " + printerQueue.processNextJob().toString());
    printerQueue.addPrintJob(new PrintJob(19, "Das ist der vierte Ausdruck", PrintJob.Priority.middle));
    printerQueue.displayQueue();

    System.out.println("Erledigter Printjob: " + printerQueue.processNextJob().toString());
    System.out.println("Erledigter Printjob: " + printerQueue.processNextJob().toString());
    printerQueue.displayQueue();
    
    System.out.println("Erledigter Printjob: " + printerQueue.processNextJob().toString());

  }
  
}
