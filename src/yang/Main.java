package yang;

import yang.gui.Jmap;
import yang.mian.Task;

public class Main {

    public static void main(String[] args) {
        /*yang.mian.Graph graph = new yang.mian.Graph(yang.mian.Task.getGrade_three());
        yang.mian.Road road = new yang.mian.Road(graph);
        road.showGraph();
        road.findRoad();*/
        Jmap jmap=new Jmap(Task.getTask(1));
    }

}
