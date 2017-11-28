// 假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。
// 迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。
// 迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。
// 请设计一个算法，帮助探险家找到脱困的最短路径。
// 如前所述，迷宫是通过一个二维矩阵表示的，每个元素的值的含义如下
// 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应大写字母所代表的门的钥匙
// 迷宫边长不超过100, 门不超过10扇。

public class Solution {
  static class Node {
    int x;
    int y;
    int key;
    int step;
    
    public Node (int x, int y, int key, int step) {
      this.x = x;
      this.y = y;
      this.key = key;
      this.step = step;
    }
  }

  public int findPath(char[][] maze) {
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[0].length; j++) {
        if (maze[i][j] == '2') {
          return BFS(maze, i, j);
        }
      }
    }
  }
  
  private int BFS(char[][] maze, int si, int sj) {
    Queue<Node> queue=new LinkedList<>();
    int[][][] mp=new int[101][101][1025];
    int[][] next={{-1,0},{0,-1},{1,0},{0,1}};
         
    queue.offer(new Node(si,sj,0,0));
    while(!queue.isEmpty()){
      Node node=queue.poll();
      for(int i=0;i<4;i++){
        int x=node.x+next[i][0];
        int y=node.y+next[i][1];
        int key=node.key;
        if(x<0||x>=N||y<0||y>=M||G[x][y]=='0') {
          continue;
        } else if(G[x][y]=='3') {
          return node.step+1;
        } else if(G[x][y]<='z'&&G[x][y]>='a') {
          key=key|(1<<(G[x][y]-'a'));
        } else if(G[x][y]<='Z'&&G[x][y]>='A'&&(key&(1<<(G[x][y]-'A')))==0) {
          continue;
        }
        if(mp[x][y][key]==0){
          mp[x][y][key]=1;
          queue.offer(new Node(x,y,key,node.step+1));
        }
      }
    }
    return -1;
  }
}
