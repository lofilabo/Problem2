package route001;

import java.util.List;

/**
 * 
 *	A class to contain a whole Graph (a number of junctions joined by a number of Routes.)
 *
 *	Uses: 
 *		A List of many Junction (please see Junction.java for definition of Junction)
 *		A List of many Edge (please see)
 *	
 *
 */


public class Graph {
  private final List<Junction> junctions;
  private final List<Road> roads;

  public Graph(List<Junction> junctions, List<Road> roads) {
    this.junctions = junctions;
    this.roads = roads;
  }

  public List<Junction> getJunctiones() {
    return junctions;
  }

  public List<Road> getRoads() {
    return roads;
  }
  
  
  
} 
