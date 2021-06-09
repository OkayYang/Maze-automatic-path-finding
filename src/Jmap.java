import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Jmap{
    private  Stack<Cell> stack;
    private static int[][] map;
    private JButton jb[][];
    private JButton bt_next;
    private JButton bt_begin;
    private static int click=1;
    private JFrame frame = new JFrame("迷宫寻路");


    public JButton getBt_next() {
        return bt_next;
    }

    public JButton getBt_begin() {
        return bt_begin;
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void setMap(int[][] map) {
        Jmap.map = map;
    }

    public Jmap(int[][] graph){
        map = graph;
        init();
    }

    public static int[][] getMap() {
        return map;
    }

    public void setStack(Stack<Cell> stack) {
        this.stack = stack;
    }

    public void init() {
        bt_next = new JButton("下一关");
        bt_begin = new JButton("开始寻路");
        bt_begin.addActionListener(new ActionListener() {
            class Clkbt implements Runnable{

                @Override
                public void run() {
                    showRoad();
                }
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setStack(new Road(new Graph(Jmap.getMap())).findRoad());
                } catch (Exception ex) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(frame,"没有通路！","错误 ",0);
                }
                new Thread(new Clkbt()).start();
            }
        });
        bt_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click==4){
                    click=1;
                }
                frame.dispose();
                Jmap jmap = new Jmap(Task.getTask(++click));

            }
        });


        jb= new JButton[map.length][map[1].length];
        Container panel = new Panel();
        panel.setLayout(new BorderLayout());
        Container panel1 = new Panel();
        panel1.setSize(map[1].length*50,map.length);
        Container panel2 = new Panel();
        panel2.setLayout(new GridLayout(1,2));
        panel2.add(bt_next);
        panel2.add(bt_begin);
        panel1.setLayout(new GridLayout(map.length,map[1].length));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[1].length; j++) {
                jb[i][j]= new JButton();
                panel1.add(jb[i][j]);
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[1].length; j++) {
                if (map[i][j] == 1) {

                    jb[i][j].setBackground(Color.red);
                } else if (map[i][j] == 0) {
                    jb[i][j].setBackground(Color.white);
                }else if (map[i][j] == 2) {
                    jb[i][j].setText("Q");

                }else if (map[i][j] == 3){
                    jb[i][j].setText("Z");
                }
            }
        }
        frame.setSize(map[1].length*50,map.length*50+50);
        panel.add(panel1,BorderLayout.CENTER);
        panel.add(panel2,BorderLayout.SOUTH);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
    public void showRoad(){

        for (int k = 0; k < stack.size(); k++) {
                jb[stack.get(k).getPoint_x()][stack.get(k).getPoint_y()].setBackground(Color.blue);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (k==stack.size()-1){
                JOptionPane.showMessageDialog(frame,"闯关成功！","提示",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }


}
