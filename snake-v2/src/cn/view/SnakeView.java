package cn.view;

import cn.snake.FrameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class SnakeView extends JPanel {
    //地图
    public static final int  width=40;
    public static final  int height=30;
    //格子
    public static final int  gwidth=20;
    public static final  int gheight=20;
    private boolean[][] background=new boolean[height][width];

    LinkedList<Point> snake=new LinkedList<Point>();
    public void initSnake(){
        int x=width/2;
        int y=height/2;
        snake.addFirst(new Point(x-1,y));
        snake.addFirst(new Point(x,y));
        snake.addFirst(new Point(x+1,y));
    }

    public void moveUp(){
        Point head=snake.getFirst();
        snake.addFirst(new Point(head.x,head.y-1));
        snake.removeLast();

    }

    public void initBackground(){
        for(int rows=0;rows<background.length;rows++){
            for(int cols=0;cols<background[rows].length;cols++){
                if (rows==0||rows==(height-1)/*||cols==0||cols==(width-1)显示左右边框*/){
                    background[rows][cols]=true;}
            }
        }

    }
    @Override
    public void paint(Graphics g) {
        //画地图
        for(int rows=0;rows<background.length;rows++){
            for(int cols=0;cols<background[rows].length;cols++){
                if (background[rows][cols]){g.setColor(Color.GRAY);}else {g.setColor(Color.WHITE);}
                g.fill3DRect(cols*gwidth,rows*gheight,gwidth,gheight,true);
            }

        }
        //花蛇


       g.setColor(Color.GREEN);
            for (int i=1;i<snake.size();i++){
                Point body=snake.get(i);
                g.fill3DRect(body.x*gwidth,body.y*gheight,gwidth,gheight,true);
            }
        Point head=snake.getFirst();//调换显示顺序以显示蛇头
        g.setColor(Color.RED);
        g.fill3DRect(head.x*gwidth,head.y*gheight,gwidth,gheight,true);



    }
    public static void main(String[]args){
        JFrame frame=new JFrame("贪吃蛇");
        SnakeView snakeView=new SnakeView();
        snakeView.initBackground();
        snakeView.initSnake();
        frame.add(snakeView);
        FrameUtil.initFrame(frame,width*gwidth+20,height*gheight+50);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code=e.getKeyCode();
                switch (code){

                    case KeyEvent.VK_UP:
                        snakeView.moveUp();
                        snakeView.repaint();
                    break;
                    default:break;
                    }
            }
        });
    }
}
