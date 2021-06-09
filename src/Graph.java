public class Graph {
    private int begin_x;
    private int begin_y;
    private int over_x ;
    private int over_y ;
    //1，代表枪，0代表可走
    private int[][] graph;

    public Graph(int[][] graph) {
        this.graph = graph;
        this.setBegin_point();
        this.setOver_point();
    }

    private void setBegin_point() {
        for (int i = 0; i < this.graph.length; i++) {
            for (int j = 0; j < this.graph[i].length; j++) {
                if (graph[i][j]==2){
                    this.begin_x=i;
                    this.begin_y=j;
                }
            }
        }
    }


    private void setOver_point() {
        for (int i = 0; i < this.graph.length; i++) {
            for (int j = 0; j < this.graph[i].length; j++) {
                if (graph[i][j]==3){
                    this.over_x=i;
                    this.over_y=j;
                }
            }
        }
    }



    public int getBegin_x() {
        return begin_x;
    }

    public int getBegin_y() {
        return begin_y;
    }

    public int getOver_x() {
        return over_x;
    }

    public int getOver_y() {
        return over_y;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void showGraph() {
        for (int i = 0; i < this.graph.length; i++) {
            for (int j = 0; j < this.graph[i].length; j++) {
                System.out.print(this.graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
