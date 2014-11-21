

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import route001.DijkstraImpl;
import route001.Road;
import route001.Graph;
import route001.Junction;



public class Problem {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	private List<Junction> junctions;
	private List<Road> roads;	
	
	public static void main(String[] args) {
	    /**
	     * Let's escape from the Static world as fast as we can, 
	     * and make an instance of our class.
	     */
	    Problem routeplan = new Problem();
	    
	    /**
	     * call the method which actually defines the network
	     */
	    routeplan.defineNetwork();
	    
	    /**
	     * Call a test.
	     * PARM: Start-point which must be defined in defineNetwork
	     * PARM: End-point which must be defined in defineNetwork
	     * 
	     */
	    routeplan.doTest(1, 12);
	    
	    
	}

	  public void defineNetwork(){
		  
		  	int totalNumberOfJunctions = 36;
		  
		  	junctions = new ArrayList<Junction>();
		    
		  	roads = new ArrayList<Road>();
		    
		    for (int i = 0; i < totalNumberOfJunctions; i++) {
		      junctions.add( new Junction("Junction " + i, "Junction " + i) );
		    }

		    this.definePath("R1_out", 	0, 1, 1);
		    this.definePath("R1_in", 	1, 0, 1);
		    this.definePath("R2_out", 	1, 2, 1);
		    this.definePath("R2_in", 	2, 1, 1);
		    this.definePath("R3_out", 	2, 3, 1);
		    this.definePath("R3_in", 	3, 2, 1);
		    this.definePath("R4_out", 	0, 5, 1);
		    this.definePath("R4_in", 	5, 0, 1);
		    this.definePath("R5_out", 	1, 6, 1);
		    this.definePath("R5_in", 	6, 1, 1);
		    this.definePath("R6_out", 	2, 7, 1);
		    this.definePath("R6_in", 	7, 2, 1);
		    this.definePath("R7_out", 	3, 8, 1);
		    this.definePath("R7_in", 	8, 3, 1);
		    this.definePath("R8_out", 	4, 5, 1);
		    this.definePath("R8_in", 	5, 4, 1);
		    this.definePath("R9_out", 	5, 6, 1);
		    this.definePath("R9_in", 	6, 5, 1);
		    this.definePath("R10_out", 	6, 7, 1);
		    this.definePath("R10_in", 	7, 6, 1);
		    this.definePath("R11_out", 	7, 8, 1);
		    this.definePath("R11_in", 	8, 7, 1);
		    this.definePath("R12_out", 	4, 9, 1);
		    this.definePath("R13_out", 	6, 9, 1);
		    this.definePath("R13_in", 	9, 6, 1);
		    this.definePath("R14_out", 	8, 12, 1);
		    this.definePath("R14_in", 	12, 8, 1);
		    this.definePath("R15_out", 	9, 10, 1);
		    this.definePath("R15_in", 	10, 9, 1);
		    this.definePath("R16_out", 	9, 11, 1);
		    this.definePath("R17_out", 	10, 11, 1);
		    this.definePath("R17_in", 	11, 10, 1);
		    this.definePath("R18_out", 	11, 12, 1);
		    this.definePath("R18_in", 	12, 11, 1);
		    	  
	  }
	
	  public void doTest(int start, int end){
		  
		  System.out.println( ANSI_CYAN + "START: " + start + ", END: " + end + ANSI_RESET );
		  
		  	Graph graph = new Graph(junctions, roads);
		    
		  	DijkstraImpl dijkstra = new DijkstraImpl(graph);
		    
		    dijkstra.execute(junctions.get( start ));
		    
		    LinkedList<Junction> path = dijkstra.getPath(junctions.get( end ));
		    
		    String allResults = "";
		    
		    
		    if (path != null){
			    for (Junction Junction : path) {
			      //System.out.println(Junction);
			      allResults = allResults + "" + Junction.toString() + " -> ";
			    }
			    
			    System.out.println( ANSI_GREEN + allResults + ANSI_RESET + "\n" );
		    }else{
		    	System.out.println( ANSI_RED + "No Results" + ANSI_RESET + "\n"  );
		    }
		    
		    
	  }

	  private void definePath(String laneId, int sourceLocNo, int destLocNo, int duration) {
		  
		  Road road = new Road(laneId,junctions.get(sourceLocNo), junctions.get(destLocNo), duration);
		  roads.add(road);
	  
	  }	
	
}
