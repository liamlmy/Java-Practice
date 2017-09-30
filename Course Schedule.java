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
    ArrayList[] graph = new ArrayList[numCourses];
    int[] degree = new int[numCourses];
    Queue queue = new LinkedList();
    int count=0;
        
    for(int i=0;i<numCourses;i++) {
      graph[i] = new ArrayList();
    }
            
    for(int i=0; i<prerequisites.length;i++) {
      degree[prerequisites[i][1]]++;
      graph[prerequisites[i][0]].add(prerequisites[i][1]);
    }
    for(int i=0; i<degree.length;i++) {
      if(degree[i] == 0) {
        queue.add(i);
        count++;
      }
    }
        
    while(queue.size() != 0) {
      int course = (int)queue.poll();
      for (int i = 0; i < graph[course].size(); i++) {
        int pointer = (int)graph[course].get(i);
        degree[pointer]--;
        if (degree[pointer] == 0) {
          queue.add(pointer);
          count++;
        }
      }
    }
    if (count == numCourses) {
      return true;
    } else {
      return false;
    }
}
