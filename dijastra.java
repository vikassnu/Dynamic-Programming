package dynamic_programming;
/*
1.prim's algorithm is used here;
     1.1. Time Complexity: O(v^2)
     1.2. Space Complexity: O(V)
     1.3. shortest distance is calculated
     1.4. shortest path is  calculated
*/
public class Dijastra_algorithm {
    static final int V=9;
    void   dijastra(int[][] graph, int src){
        int dist[] = new int[graph.length];
        boolean check[] = new boolean[graph.length];
        int parent[] = new int[V];
        for(int i=0;i<graph.length;i++){
                dist[i]=Integer.MAX_VALUE;
            check[i]=false;
            parent[i]=-1;
        }

        dist[src] = 0;
        for(int j=0;j<graph.length;j++){
            int u = relax(dist,check);
            check[u]=true;
            for(int v=0;v<V;v++){
                if(!check[v] && graph[u][v]!=0 && (dist[u] + graph[u][v])<dist[v]){
                    dist[v] =dist[u] + graph[u][v];
                    parent[v]=u;
                }
            }

        }
        printdistance(dist);
        printdistance(parent);
    }
    static int relax(int dist[], boolean check[]){
        int min = Integer.MAX_VALUE;
        int index=-1;
        for(int v=0;v<V;v++){
        if(check[v]==false && dist[v]<=min){
            index =v;
            min = dist[v];
        }

        }
        return index;
    }
    void printdistance(int dist[]){
        System.out.println("solution:");
        for (int i=0;i<V;i++){
            System.out.println(i+":"+dist[i]);
        }
    }

    public static void main(String[] args) {
        int graph[][] =  new int[][]{
                {0,4 ,0,0 ,0,0 ,0,8 ,0},
                {4,0 ,8,0 ,0,0 ,0,11,0},
                {0,8 ,0,7 ,0,4 ,0,0 ,2},
                {0,0 ,7,0 ,9,14,0,0 ,0},
                {0,0 ,0,9 ,0,10,0,0 ,0},
                {0,0 ,4,14,0,10,2,0 ,0},
                {0,4 ,0,0 ,0,2 ,0,1 ,6},
                {8,11,0,0 ,0,0 ,1,0 ,7},
                {0,0 ,2,0 ,0,0 ,6,7 ,0},
        };
        int src = 0;
        Dijastra_algorithm dp = new Dijastra_algorithm();
        dp.dijastra(graph, src);

    }


}
