package com.sss8000.getDirection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;*/

/* Dijkstra Test 클래스 
 */
public class TestDijkstraAlgorithm {

  //Nodes, Edges
  private List<Vertex> nodes;
  private List<Edge> edges;

  //Test
  public void testExcute() {
	//Vertex, Edge에 대한 ArrayList
    nodes = new ArrayList<Vertex>();
    edges = new ArrayList<Edge>();
    
    
//    for (int i = 0; i < 12; i++) {
//      Vertex location = new Vertex("Node_" + i, "Node_" + i);
//      nodes.add(location);
//    }
    
    addLane("Edge_0", 0, 1, 15);
    addLane("Edge_1", 0, 2, 5);
    addLane("Edge_2", 1, 4, 5);
    addLane("Edge_3", 2, 3, 2);
    addLane("Edge_4", 3, 6, 13);

    // Lets check from location Loc_1 to Loc_10
    Graph graph = new Graph(nodes, edges);
    
    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

    dijkstra.execute(nodes.get(11));
    
    LinkedList<Vertex> path = dijkstra.getPath(nodes.get(0));

    /* assertNotNull(path);
    assertTrue(path.size() > 0);*/
    
    
    if(path==null){
    	System.out.println("��ΰ� �������� �ʽ��ϴ�.");
    }else{
	    for (Vertex vertex : path) {
	      System.out.println(vertex);
	    }
    }
    
  }

  private void addLane(String laneId, int sourceLocNo, int destLocNo,
      int duration) { //Edge �̸�, �����, ������, ����ġ
    Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
    edges.add(lane);
  }
} 