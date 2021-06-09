import java.util.Stack;

public class Road {
    private Graph graph;
    private Stack<Cell> list_pass = new Stack<>();
    public Road(Graph graph) {
        this.graph = graph;
    }
    public void showGraph(){
        graph.showGraph();
    }
    public Stack<Cell> findRoad() throws Exception{
        Cell cell = new Cell(graph.getBegin_x(), graph.getBegin_y());
        resetCell(cell);
        list_pass.push(cell);
        while (list_pass.peek().getPoint_x()!= graph.getOver_x()||list_pass.peek().getPoint_y()!= graph.getOver_y()){
            if (list_pass.peek().isTop()){
                list_pass.peek().setTop(false);
                cell = new Cell(list_pass.peek().getPoint_x()-1, list_pass.peek().getPoint_y());
                resetCell(cell);
                cell.setBottom(false);
                list_pass.push(cell);
            }
            else if (list_pass.peek().isRight()){
                list_pass.peek().setRight(false);
                cell = new Cell(list_pass.peek().getPoint_x(), list_pass.peek().getPoint_y()+1);
                resetCell(cell);
                cell.setLeft(false);
                list_pass.push(cell);
            }
            else if (list_pass.peek().isBottom()){
                list_pass.peek().setBottom(false);
                cell = new Cell(list_pass.peek().getPoint_x()+1, list_pass.peek().getPoint_y());
                resetCell(cell);
                cell.setTop(false);
                list_pass.push(cell);
            }
            else if (list_pass.peek().isLeft()){
                list_pass.peek().setLeft(false);
                cell = new Cell(list_pass.peek().getPoint_x(), list_pass.peek().getPoint_y()-1);
                resetCell(cell);
                cell.setRight(false);
                list_pass.push(cell);
            }
            else if(true){
                list_pass.pop();
            }
        }
        for (int i = 0; i < list_pass.size(); i++) {
            System.out.print("("+list_pass.get(i).getPoint_x()+","+list_pass.get(i).getPoint_y()+")");

        }
        System.out.println();
        return list_pass;

    }
    public  void resetCell(Cell cell){
        if (graph.getGraph()[cell.getPoint_x()-1][cell.getPoint_y()]==1){
            cell.setTop(false);
        }
        if (graph.getGraph()[cell.getPoint_x()][cell.getPoint_y()+1]==1){
            cell.setRight(false);
        }
        if (graph.getGraph()[cell.getPoint_x()+1][cell.getPoint_y()]==1){
            cell.setBottom(false);
        }
        if (graph.getGraph()[cell.getPoint_x()][cell.getPoint_y()-1]==1){
            cell.setLeft(false);
        }
    }

}
