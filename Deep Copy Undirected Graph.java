// Make a deep copy of an undirected graph, there could be cycles in the original graph.
//
// Assumptions
// The given graph is not null

/*
 * Method 1: DFS
 */
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Corner check
    if (graph == null) {
      return null;
    }
    // Deep copy the graph
    Map<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        map.put(node, new GraphNode(node.key));
        DFS(node, map);
      }
    }
    return new ArrayList<GraphNode>(map.values());
  }
  
  private void DFS(GraphNode node, Map<GraphNode, GraphNode> map) {
    GraphNode copy = map.get(node);
    for (GraphNode nei : node.neighbors) {
      if (!map.containsKey(nei)) {
        map.put(nei, new GraphNode(nei.key));
        DFS(nei, map);
      }
      copy.neighbors.add(map.get(nei));
    }
  }
}

/*
 * Method 2: BFS
 */
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Corner check
    if (graph == null) {
      return null;
    }
    // Deep copy the graph
    List<GraphNode> result = new ArrayList<>();
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        map.put(node, new GraphNode(node.key));
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
          GraphNode cur = queue.poll();
          for (GraphNode nei : cur.neighbors) {
            if (!map.containsKey(nei)) {
              map.put(nei, new GraphNode(nei.key));
              queue.offer(nei);
            }
            map.get(cur).neighbors.add(map.get(nei));
          }
          result.add(map.get(cur));
        }
      }
    }
    return result;
  }
}
