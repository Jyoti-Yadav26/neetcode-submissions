class DSU{
    int[] parent;
    int[] size;

    DSU(int n){
        parent= new int[n];
        size= new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    // find parent
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        // path compression
        return parent[x]=find(parent[x]);
    }

    // union two sets - are they connected?
    boolean union(int a,int b){
        int pa= find(a);
        int pb= find(b);

        // already connected(same set)
        if(pa==pb) return false;

        if(size[pa]<size[pb]){
            int temp=pa;
            pa=pb;
            pb=temp;
        }
        parent[pb]=pa;
        size[pa]+=size[pb];

        return true;
    }

    boolean connected(int a,int b){
        return find(a)==find(b);
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        DSU dsu=new DSU(n+1);

        for(int i=0;i<n;i++){
            int a= edges[i][0];
            int b= edges[i][1];

            if(!dsu.union(a,b)){
                return new int[]{a,b};
            }
        }

        return new int[]{};
    }
}
