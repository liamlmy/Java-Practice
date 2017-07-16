// Determine if an undirected graph is bipartite.
// A bipartite graph is one in which the nodes can be divided into two groups
// such that no nodes have direct edges to other nodes in the same group.
//
// Examples
// 1  --   2
//
//     /   
//
// 3  --   4
// is bipartite (1, 3 in group 1 and 2, 4 in group 2).
// 1  --   2
//
//     /   |
//
// 3  --   4
// is not bipartite.
//
// Assumptions
// The graph is represented by a list of nodes, and the list of nodes is not null.

public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    // We use 0 and 1 to denote different groups.
    // The map maintains for each node which it group belongs to.
    Map<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
    // The graph can be represented as a list of node (if it is not guaranteed to be connected).
    // We have to do BFS from each of the node.
    for (GraphNode node : graph) {
      if (!BFS(node, visited)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean BFS(GraphNode node, Map<GraphNode, Integer> visited) {
    // If the node has been traversed, no need to do BFS again.
    if (visited.containsKey(node)) {
      return true;
    }
    // Start Breadth-first-search from the node, since the node is not visited, we can assign it to any
    // of the group, for example, group 0 or group 1.
    Queue<GraphNode> queue = new LinkedList<GraphNode>();
    queue.offer(node);
    visited.put(node, 0);
    while (!queue.isEmpty()) {
      GraphNode curNode = queue.poll();
      // The group assigned for cur node.
      Integer curGroup = visited.get(curNode);
      // The group assigned for any neighbor node.
      Integer neiGroup = curGroup == 0 ? 1 : 0;
      List<GraphNode> neighbors = curNode.neighbors;
      for (GraphNode neiNode : neighbors) {
        // If the neighbor node has not been visited, just put it to the queue,
        // and assign it the correct group.
        if (!visited.containsKey(neiNode)) {
          queue.offer(neiNode);
          visited.put(neiNode, neiGroup);
        } else if (visited.get(neiNode) == curGroup) {
          // Only if the neighbor node has been traversed and the group does not match to the desired one,
          // return false.
          return false;
        }
      }
    }
    return true;
  }
}
