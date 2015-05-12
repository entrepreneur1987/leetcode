public class Solution {
    // bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++)
            graph[i] = new ArrayList<Integer>();
        int[] indegrees = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int course = q.poll();
            for(int neighbor : graph[course]){
                indegrees[neighbor]--;
                if(indegrees[neighbor] == 0)
                    q.add(neighbor);
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] != 0)
                return false;
        }
        return true;
        
    }
    
    // dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++)
            graph[i] = new ArrayList<Integer>();
        boolean[] visited = new boolean[numCourses];
        boolean[] mark = new boolean[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        for(int i=0; i<numCourses; i++){
            if(hasCycle(graph, i, visited, mark))
                return false;
        }
        return true;
    }
    
    private boolean hasCycle(List<Integer>[] graph, int curr, boolean[] visited, boolean[] mark){
        if(visited[curr])
            return true;
        if(mark[curr])
            return false;
        visited[curr] = true;
        for(int neighbor: graph[curr]){
            if(hasCycle(graph, neighbor, visited, mark))
                return true;
        }
        mark[curr]=true;
        visited[curr]=false;
        return false;
    }
}
