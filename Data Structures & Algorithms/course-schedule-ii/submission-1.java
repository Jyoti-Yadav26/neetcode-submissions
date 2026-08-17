class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n= prerequisites.length;

        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] inorder= new int[numCourses];
        for(int i=0;i<n;i++){
            int a=prerequisites[i][0];
            int b= prerequisites[i][1];

            adj.get(b).add(a);
            inorder[a]++;
        }

        // for(int el:inorder) System.out.print(el+" ");
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inorder[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> arr= new ArrayList<>();
        while(!q.isEmpty()){
            int front= q.poll();
            arr.add(front);
            for(int neighbor:adj.get(front)){
                inorder[neighbor]--;
                if(inorder[neighbor]==0){
                    q.offer(neighbor);
                }
            }
        }
        if(arr.size()!=numCourses) return new int[]{};
        int[] res= new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}
