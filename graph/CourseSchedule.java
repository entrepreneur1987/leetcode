public class Solution {
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
}
