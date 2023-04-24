package week5;

import java.util.*;
import java.util.LinkedList;
 
// This class represents an undirected graph using adjacency list representation
public class Graph {
        private int V;   // No. of vertices
     
        // Array  of lists for Adjacency List Representation
        private LinkedList<Integer> adj[];
        private int time = 0;
        private int NIL = -1;
     
        @SuppressWarnings("unchecked")
        // Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList<Integer>();
        }
     
        //Function to add an edge into the graph
        void addEdge(int v, int w)
        {
            adj[v].add(w);  // Add w to v's list.
            adj[w].add(v);    //Add v to w's list
        }
     
        // A recursive function that find Vulnerable Nodes using DFS
        // u --> The vertex to be visited next
        // visited[] --> keeps tract of visited vertices
        // disc[] --> Stores discovery times of visited vertices
        // parent[] --> Stores parent vertices in DFS tree
        // getVulnerableNodes[] --> Store Vulnerable Nodes
        void getVulnerableNodesUtil(int u, boolean visited[], int disc[],
                    int low[], int parent[], boolean getVulnerableNodes[])
        {
     
            // Count of children in DFS Tree
            int children = 0;
     
            // Mark the current node as visited
            visited[u] = true;
     
            // Initialize discovery time and low value
            disc[u] = low[u] = ++time;
     
            // Go through all vertices Adjacent to this
            Iterator<Integer> i = adj[u].iterator();
            while (i.hasNext())
            {
                int v = i.next();  // v is current adjacent of u
     
                // If v is not visited yet, then make it a child of u
                // in DFS tree and recur for it
                if (!visited[v])
                {
                    children++;
                    parent[v] = u;
                    getVulnerableNodesUtil(v, visited, disc, low, parent, getVulnerableNodes);
     
                    // Check if the subtree rooted with v has a connection to
                    // one of the ancestors of u
                    low[u]  = Math.min(low[u], low[v]);
     
                    // u is an vulnerable node in following cases
     
                    // (1) u is root of DFS tree and has two or more children.
                    if (parent[u] == NIL && children > 1)
                        getVulnerableNodes[u] = true;
     
                    // (2) If u is not root and low value of one of its child
                    // is more than discovery value of u.
                    if (parent[u] != NIL && low[v] >= disc[u])
                        getVulnerableNodes[u] = true;
                }
     
                // Update low value of u for parent function calls.
                else if (v != parent[u])
                    low[u]  = Math.min(low[u], disc[v]);
            }
        }
     
        // The function to do DFS traversal. It uses recursive function getVulnerableNodesUtil()
        ArrayList<Integer> getVulnerableNodes()
        {
            // Mark all the vertices as not visited
            ArrayList<Integer> vulnerableNodes = new ArrayList<Integer>(); // final Array list of vulnerable nodes
            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];
            boolean getVulnerableNodes[] = new boolean[V]; // To store Vulnerable Nodes
     
            // Initialize parent and visited, and getVulnerableNodes
            // arrays
            for (int i = 0; i < V; i++)
            {
                parent[i] = NIL;
                visited[i] = false;
                getVulnerableNodes[i] = false;
            }
     
            // Call the recursive helper function to find vulnerable
            // points in DFS tree rooted with vertex 'i'
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    getVulnerableNodesUtil(i, visited, disc, low, parent, getVulnerableNodes);
     
            // Now getVulnerableNodes[] contains Vulnerable Nodes, print them
            for (int i = 0; i < V; i++)
                if (getVulnerableNodes[i] == true)
                    vulnerableNodes.add(i);
         
            
            return vulnerableNodes;
        }
        
        
        // Method to convert Vulnerable Node Keys to its Value
        ArrayList<Integer> VulnerableNodes(HashMap<Integer, Integer> networks){
            ArrayList<Integer> VulnerableNodesKey = getVulnerableNodes();
            ArrayList<Integer> VulnerableNodesValue = new ArrayList<Integer>();
            
            for (int i=0; i< VulnerableNodesKey.size(); i++) {
                VulnerableNodesValue.add(networks.get(VulnerableNodesKey.get(i)));
            }
            
            return VulnerableNodesValue;
        }
    
     
        // Driver method
        public static void main(String args[])
        {
            // Configuring HashMap to map the networks
            HashMap<Integer, Integer> networks = new HashMap<Integer, Integer>();
            networks.put(0, 5);
            networks.put(1, 9);
            networks.put(2, 7);
            networks.put(3, 12);
            networks.put(4, 13);
            
        
            // Create graph 
            Graph graph = new Graph(5);
            graph.addEdge(1, 0);
            graph.addEdge(0, 2);
            graph.addEdge(2, 1);
            graph.addEdge(2, 3);
            graph.addEdge(4, 3);
            
            
            System.out.println("Vulnerable Nodes in the graph:");
            System.out.println(graph.VulnerableNodes(networks));
          
        }

}
