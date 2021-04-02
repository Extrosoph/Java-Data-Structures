import CITS2200.Graph;
import CITS2200.Path;
import CITS2200.IllegalValue;
import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * 
 * @author 22764884 (Theoridho Andily)
 *
 */
public class PathImp implements Path {
	
	PriorityQueue<weightedEdge> pQueue = new PriorityQueue<weightedEdge>();
	
	//Class to handle the weight of the edges
	public class weightedEdge implements Comparable<weightedEdge>{
		public int vertex;
		public int edgeWeight;
		
		public weightedEdge(int endVertex, int weight){
			vertex = endVertex;
			edgeWeight = weight;
		}
		
		@Override
		/**
		 * A method to compare the weight of the edges
		 * 
		 * @param E - weighted edge
		 * @return -1 if the edge of the previous is more than the weight of the edge being compared to, 1 if less and 0 otherwise.
		 */
		public int compareTo(weightedEdge E) {
			int currentWeight = E.edgeWeight;
			
			if(edgeWeight < currentWeight){
				return -1;
			}
			
			else if(edgeWeight > currentWeight){
				return 1;
			}
			
			else return 0;
		}
	}
	

	@Override
	/**
	 * Finds the minimum weight of a spanning tree for the given graph.
	 * 
	 * @param g - the Graph to be searched. Assume that an edge weight of 0 signifies that the edge does not exist.
	 * @return the weight of the minimum spanning tree, or -1 if there is no spanning tree
	 * @throws IllegalValue if the graph is empty
	 */
	public int getMinSpanningTree(Graph graph) {
		//Check for empty graphs
		int vertices = graph.getNumberOfVertices();
		if(vertices == 0) throw new IllegalValue("Graph is empty.");
		
		//Construct the required arrays
		int[][] eMatrix = graph.getEdgeMatrix();
		Boolean[] seen = new Boolean[vertices];
		int[] pie = new int[vertices];
		int[] parentWeight = new int[vertices];
		
		//Initializes the arrays
		Arrays.fill(seen, false);
		Arrays.fill(pie,  -1);
		Arrays.fill(parentWeight, -1);
		
		//Add a new weighted edge to the queue and making the weight of the root vertex to be 0
		pQueue.add(new weightedEdge(0, 0));
		parentWeight[0] = 0;
		
		//Start of the Prim's algorithm
		while(!pQueue.isEmpty()) {
			int parentVertex = pQueue.remove().vertex;
			
			//Check if the vertex is seen or not
			if(seen[parentVertex] == false) {
				seen[parentVertex] = true;
				
				//Go through every vertex that is adjacent to the current parent vertex
				for(int i = 0; i < vertices; ++i){
					int vertexWeight = eMatrix[parentVertex][i];
					if(vertexWeight > 0 && seen[i] == false){
						if(parentWeight[i] == -1 || parentWeight[i] > vertexWeight){
							parentWeight[i] = vertexWeight;
							pie[i] = parentVertex;
							pQueue.add(new weightedEdge(i, parentWeight[i]));
						}
					}
				}
			}
			else {
				continue;
			}
				
		}
		
		
		//Calculate the total weight
		int totalWeight = 0;
 		for(int j : parentWeight){
 			if(j == -1){
 				totalWeight = -1;
 				break;
 			}
 			totalWeight+=j;
 		}
		return totalWeight;
		
	}
		
	@Override
	/**
	 * Runs Dijkstra's algorithm on a given undirected, non-negative weighted graph
	 * to find the distances to all vertices from the specified source vertex
	 *  
	 * @param g - the Graph to be searched. Assume that an edge weight of 0 signifies that the edge does not exist.
	 * @param source - the vertex on which to start the search
	 * @return an array listing the distance to each vertex in the single source shortest path problem, or -1 if the vertex is not reachable from the source.
	 * @throw IllegalValue if the graph is empty
	 */
	public int[] getShortestPaths(Graph graph, int source) {
			//Check for empty graphs
			int vertices = graph.getNumberOfVertices();
			if(vertices == 0) throw new IllegalValue("Graph is empty.");
			
			//Construct the required arrays
			Boolean[] seen = new Boolean[vertices];
			int[] pie = new int[vertices];
			int[][] eMatrix = graph.getEdgeMatrix();
			int[] parentWeight = new int[vertices];
			
			//Initializes the arrays
			Arrays.fill(pie,-1);
			Arrays.fill(seen, false);
			Arrays.fill(parentWeight, -1);
			
			//Add a new weighted edge to the queue and making the weight of the root vertex to be 0
	 		pQueue.add(new weightedEdge(source, 0));
	 		parentWeight[source] = 0;
	 		
	 		//Start of the Dijkstra's algorithm
	 		while(!pQueue.isEmpty()){			
				int parentVertex = pQueue.remove().vertex;
				
				//Check if the vertex is seen or not
				if(seen[parentVertex] == false) {
					seen[parentVertex] = true;
					
					//Go through every vertex that is adjacent to the current parent vertex
					for(int i = 0; i < vertices; ++i){
						int vertexWeight = eMatrix[parentVertex][i];
						if(vertexWeight > 0 && seen[i] == false){
							if(parentWeight[i] == -1 || parentWeight[i] > parentWeight[parentVertex] + vertexWeight){
								parentWeight[i] = parentWeight[parentVertex] + vertexWeight;
								pie[i] = parentVertex;
								pQueue.add(new weightedEdge(i, parentWeight[i]));
							}
						}
					}
				}
				else {
					continue;
				}
		}
		return parentWeight;
	}
}
