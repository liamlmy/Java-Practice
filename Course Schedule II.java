// There are a total of n courses you have to take, labeled from 0 to n - 1.
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
// which is expressed as a pair: [0,1]
// Given the total number of courses and a list of prerequisite pairs,
// return the ordering of courses you should take to finish all courses.
// There may be multiple correct orders, you just need to return one of them.
// If it is impossible to finish all courses, return an empty array.
// For example:
// 2, [[1,0]]
// There are a total of 2 courses to take.
// To take course 1 you should have finished course 0. So the correct course order is [0,1]
// 4, [[1,0],[2,0],[3,1],[3,2]]
// There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
// Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
// Another correct ordering is[0,2,1,3].

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1 step: use a List[] to maintain all the courses taking order
        // 2 step: use a int[] to maintain how many prerequisites courses for each courses
        List[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        int[] result = new int[numCourses];
        int index = 0;
        // 3 step: add all courses which have no prerequisites into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 4 step: BFS
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            List<Integer> next = graph[cur];
            result[index++] = cur;
            for (Integer num : next) {
                indegree[num]--;
                if (indegree[num] == 0) {
                    queue.offer(num);
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }
}
