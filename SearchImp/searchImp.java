import CITS2200.Graph;
import CITS2200.Search;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;


public class SearchImp implements Search{
	private Queue<Integer> vertices;
	private String[] colours = {"white","black","grey"};
	private String[] vertexColours;
	private int[][] eMatrix;
	private int[][] time;
	private int[] pie;
	private int timer;
	
	/**
	 * This method will initiate the variables for the required methods
	 * 
	 * @param graph
	 * @param rootVertex
	 */
	public void initiation(Graph graph, int rootVertex) {
		vertices = new LinkedList<Integer>();

		//Get the edge matrix
		eMatrix = graph.getEdgeMatrix();
		
		//Initiate vertex colours, make all colours white and make root grey
		vertexColours = new String[graph.getNumberOfVertices()];
		Arrays.fill(vertexColours, colours[0]);
		vertexColours[rootVertex] = colours[2];

		//Make the root vertex as -2;
		pie = new int[graph.getNumberOfVertices()];
		Arrays.fill(pie, -1);
	}

	/**
	 * Runs a BFS on a given directed, unweighed graph.
	 * 
	 * @param graph - the Graph to be searched
	 * @param rootVertex - the vertex on which to start the search
	 * @return an array listing the parent of each vertex in the spanning tree, or -1 is the vertex is not reachable from the start vertex.
	 */
	@Override
	public int[] getConnectedTree(Graph graph, int rootVertex) {	
		initiation(graph, rootVertex);
		
		//Start of BFS search repetitive step
		vertices.add(rootVertex);
		while(!vertices.isEmpty()) {
			int parentVertex = vertices.poll();
			for(int adjacentVertex = 0; adjacentVertex < graph.getNumberOfVertices(); adjacentVertex++) {
				if(eMatrix[parentVertex][adjacentVertex] == 1 && vertexColours[adjacentVertex] == colours[0]) {
						pie[adjacentVertex] = parentVertex;
						vertexColours[adjacentVertex] = colours[2];
						vertices.add(adjacentVertex);
					}
			}
			vertexColours[parentVertex] = colours[1];
		}
		return pie;
	}

	/**
	 * Runs a BFS on a given directed, unweighed graph to find the distances of vertices from the start vertex.
	 * 
	 * @param graph - the Graph to be searched
	 * @param rootVertex - the vertex on which to start the search
	 * @return an array listing the distance of each vertex from the start vertex of each, or -1 is the vertex is not reachable from the start vertex.
	 */
	@Override
	public int[] getDistances(Graph graph, int rootVertex) {	
		initiation(graph, rootVertex);
		
		int[] dist = new int[graph.getNumberOfVertices()];
		Arrays.fill(dist, -1);
		dist[rootVertex] = 0;
		
		vertices.add(rootVertex);
		while(!vertices.isEmpty()) {
			int parentVertex = vertices.poll();
			for(int adjacentVertex = 0;adjacentVertex < graph.getNumberOfVertices(); adjacentVertex++) {
				if(eMatrix[parentVertex][adjacentVertex] == 1 && vertexColours[adjacentVertex] == colours[0]) {
					dist[adjacentVertex] = dist[parentVertex] + 1;
					pie[adjacentVertex] = parentVertex;
					vertexColours[adjacentVertex] = colours[2];
					vertices.add(adjacentVertex);
				}
			}
			vertexColours[parentVertex] = colours[1];
		}
		return dist;
	}

	/**
	 * Runs a DFS on a given directed, unweighed graph to find the start time and finish time for each vertex
	 * 
	 * @param graph - the Graph to be searched
	 * @param rootVertex - the vertex on which to start the search
	 * @return a 2-dimensional array, where each sub-array has two elements: the first is the start time, the second is the end time.
	 * 
	 */
	@Override
	public int[][] getTimes(Graph graph, int rootVertex) {
		
		//Initiate time array and set a timer to 0
		time = new int[graph.getNumberOfVertices()][2];
		for(int i = 0; i < time.length; i++) {
			Arrays.fill(time[i], -1);
		}
		timer = 0;
		
		initiation(graph, rootVertex);
		
		//start of DFS
		for(int i = 0; i <graph.getNumberOfVertices(); i++) {
			if(vertexColours[i] == colours[0]) {
				DFS(graph, rootVertex);
			}
		}
		return time;
	}
	
	/**
	 * This is method which does the depth-first search
	 * 
	 * @param graph - the Graph to be searched
	 * @param parentVertex
	 */
	public void DFS(Graph graph, int parentVertex) {
		vertexColours[parentVertex] = colours[1];
		time[parentVertex][0] = timer++;
		for(int adjacentVertex = 0; adjacentVertex < graph.getNumberOfVertices(); adjacentVertex++) {
			if(eMatrix[parentVertex][adjacentVertex] == 1 && vertexColours[adjacentVertex] == colours[0]) {
				pie[parentVertex] = adjacentVertex;
				DFS(graph, adjacentVertex);
			}
		}
		vertexColours[parentVertex] = colours[2];
		time[parentVertex][1] = timer++;
	}
}
