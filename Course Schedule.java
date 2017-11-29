// There are a total of n courses you have to take, labeled from 0 to n - 1.
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
// which is expressed as a pair: [0,1]
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
// For example:
// 2, [[1,0]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
// 2, [[1,0],[0,1]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0,
// and to take course 0 you should also have finished course 1. So it is impossible.
//
// Note:
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
// Read more about how a graph is represented.
// You may assume that there are no duplicate edges in the input prerequisites.

/*
 * Method 1: DFS
 */
/*
public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList[] graph = new ArrayList[numCourses];
    for(int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList();
    }           
    boolean[] visited = new boolean[numCourses];
    for(int i = 0; i < prerequisites.length; i++) {
      graph[prerequisites[i][1]].add(prerequisites[i][0]);
    }

    for(int i = 0; i < numCourses; i++) {
      if(!dfs(graph, visited, i)) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
    if(visited[course]) {
      return false;
    } else {
      visited[course] = true;
    }

    for(int i = 0; i < graph[course].size(); i++) {
      if(!dfs(graph,visited,(int)graph[course].get(i))) {
        return false;
      }
    }
    visited[course] = false;
    return true;
  }
}
*/

/*
 * Method 2: BFS
 */
public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList<Integer>();
    }
    // indegree[i] means how many prerequisites are needed to take course i
    int[] indegree = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      graph[prerequisites[i][1]].add(prerequisites[i][0]);
      indegree[prerequisites[i][0]]++;
    }
    int count = 0;
    Queue<Integer> queue = new LinkedList<>();
    // Find the entrance of the graph which are the courses that have no prerequisites
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      count++;
      List<Integer> nexts = graph[cur];
      for (int i = 0; i < nexts.size(); i++) {
        Integer nextCourse = nexts.get(i);
        indegree[nextCourse]--;
        if (indegree[nextCourse] == 0) {
          queue.offer(nextCourse);
        }
      }
    }
    return count == numCourses;
  }
}
