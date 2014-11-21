package route001;

public class Road{
  private final String id; 
  private final Junction source;
  private final Junction destination;
  private final int weight; 
  
  public Road(String id, Junction source, Junction destination, int weight) {
    this.id = id;
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }
  
  public String getId() {
    return id;
  }
  public Junction getDestination() {
    return destination;
  }

  public Junction getSource() {
    return source;
  }
  public int getWeight() {
    return weight;
  }
  
  @Override
  public String toString() {
    return source + " " + destination;
  }
  
  
} 
