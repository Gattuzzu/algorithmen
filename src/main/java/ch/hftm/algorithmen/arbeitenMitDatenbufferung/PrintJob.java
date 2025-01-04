package ch.hftm.algorithmen.arbeitenMitDatenbufferung;

public class PrintJob {
  public enum Priority{
    high("Hoch"),
    middle("Mittel"),
    low("Tief");

    private String name;

    private Priority(String name){
      this.name = name;
    }

    public String toString(){
      return this.name;
    }
  }

  private int id;
  private String documentName;
  private Priority priority;

  public PrintJob() {
  }

  public PrintJob(int id, String documentName, Priority priority) {
    this.id = id;
    this.documentName = documentName;
    this.priority = priority;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDocumentName() {
    return documentName;
  }

  public void setDocumentName(String documentName) {
    this.documentName = documentName;
  }

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }
  
  public String toString(){
    return this.id + " | " + this.priority.toString() + " | " + this.documentName; 
  }
  

}
