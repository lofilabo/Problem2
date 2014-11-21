package route001;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import route001.Road;
import route001.Graph;
import route001.Junction;

public class DijkstraImpl {

  private final List<Junction> nodes;
  private final List<Road> roads;
  private Set<Junction> settledNodes;
  private Set<Junction> unSettledNodes;
  private Map<Junction, Junction> predecessors;
  private Map<Junction, Integer> distance;

  public DijkstraImpl(Graph graph) {
    // create a copy of the array so that we can operate on this array
    this.nodes = new ArrayList<Junction>(graph.getJunctiones());
    this.roads = new ArrayList<Road>(graph.getRoads());
  }

  public void execute(Junction source) {
    settledNodes = new HashSet<Junction>();
    unSettledNodes = new HashSet<Junction>();
    distance = new HashMap<Junction, Integer>();
    predecessors = new HashMap<Junction, Junction>();
    distance.put(source, 0);
    unSettledNodes.add(source);
    while (unSettledNodes.size() > 0) {
      Junction node = getMinimum(unSettledNodes);
      settledNodes.add(node);
      unSettledNodes.remove(node);
      findMinimalDistances(node);
    }
  }

  private void findMinimalDistances(Junction node) {
    List<Junction> adjacentNodes = getNeighbors(node);
    for (Junction target : adjacentNodes) {
      if (getShortestDistance(target) > getShortestDistance(node)
          + getDistance(node, target)) {
        distance.put(target, getShortestDistance(node)
            + getDistance(node, target));
        predecessors.put(target, node);
        unSettledNodes.add(target);
      }
    }

  }

  private int getDistance(Junction node, Junction target) {
    for (Road edge : roads) {
      if (edge.getSource().equals(node)
          && edge.getDestination().equals(target)) {
        return edge.getWeight();
      }
    }
    throw new RuntimeException("Should not happen");
  }

  private List<Junction> getNeighbors(Junction node) {
    List<Junction> neighbors = new ArrayList<Junction>();
    for (Road edge : roads) {
      if (edge.getSource().equals(node)
          && !isSettled(edge.getDestination())) {
        neighbors.add(edge.getDestination());
      }
    }
    return neighbors;
  }

  private Junction getMinimum(Set<Junction> Junctiones) {
    Junction minimum = null;
    for (Junction Junction : Junctiones) {
      if (minimum == null) {
        minimum = Junction;
      } else {
        if (getShortestDistance(Junction) < getShortestDistance(minimum)) {
          minimum = Junction;
        }
      }
    }
    return minimum;
  }

  private boolean isSettled(Junction Junction) {
    return settledNodes.contains(Junction);
  }

  private int getShortestDistance(Junction destination) {
    Integer d = distance.get(destination);
    if (d == null) {
      return Integer.MAX_VALUE;
    } else {
      return d;
    }
  }

  /*
   * This method returns the path from the source to the selected target and
   * NULL if no path exists
   */
  public LinkedList<Junction> getPath(Junction target) {
    LinkedList<Junction> path = new LinkedList<Junction>();
    Junction step = target;
    // check if a path exists
    if (predecessors.get(step) == null) {
      return null;
    }
    path.add(step);
    while (predecessors.get(step) != null) {
      step = predecessors.get(step);
      path.add(step);
    }
    // Put it into the correct order
    Collections.reverse(path);
    return path;
  }

} 
