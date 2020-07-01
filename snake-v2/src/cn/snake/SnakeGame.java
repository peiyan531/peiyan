package cn.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame {




        public static final int  width=35;
        public static final  int height=9;

        private char[][] background=new char[height][width];
        LinkedList<Point> snake=new LinkedList<Point>();

/**
        public void moveLeft(){
            Point head =snake.getFirst();
            snake.addFirst(new Point(head.x-1,head.y));
            snake.removeLast();

        }
        public void moveRight(){
            Point head =snake.getFirst();
            snake.addFirst(new Point(head.x+1,head.y));
            snake.removeLast();

        }
        public void moveUp(){
            Point head=snake.getFirst();
            snake.addFirst(new Point(head.x,head.y-1));
            snake.removeLast();

        }
        public void moveDown(){
            Point head =snake.getFirst();
            snake.addFirst(new Point(head.x,head.y+1));
            snake.removeLast();

        }
*/
        Point food;

        public static final int UP_DIRECTION=1;
    public static final int DOWN_DIRECTION=-1;
    public static final int LEFT_DIRECTION=2;
    public static final int RIGHT_DIRECTION=-2;
    int currentDirection=-2;//蛇默认往右走

     static boolean isGameOver=false;//游戏默认不结束

    public void move(){
        Point head=snake.getFirst();
        switch (currentDirection){
            case UP_DIRECTION: snake.addFirst(new Point(head.x,head.y-1)); break;
            case DOWN_DIRECTION: snake.addFirst(new Point(head.x,head.y+1)); break;
            case LEFT_DIRECTION:
                if (head.x==0){snake.addFirst(new Point(width-1,head.y));}//左穿越
                else {snake.addFirst(new Point(head.x-1,head.y));}break;
            case RIGHT_DIRECTION:
                if (head.x==width-1){snake.addFirst(new Point(0,head.y));}//右穿越
                else{snake.addFirst(new Point(head.x+1,head.y)); }break;
            default:break;
        }
        if (eatFood()){crateFood();}
        else {snake.removeLast();}
    }

    public void changeDirection(int newDirection){//判断新方向是否与当前方向相反，
        if(newDirection+currentDirection!=0){this.currentDirection=newDirection;}

    }

        public void crateFood(){
            Random random=new Random();
            while (true){
                int x=random.nextInt(width);int y=random.nextInt(height);
                if (background[y][x]!='*'){food=new Point(x,y);break;}
            }
            // int x=random.nextInt(width-2)+1;
            //int y=random.nextInt(height-2)+1;
        }
        public void showFood(){
            background[food.y][food.x]='@'; }




        public void initSnake(){
            int x=width/2;
            int y=height/2;
            snake.addFirst(new Point(x-1,y));
            snake.addFirst(new Point(x,y));
            snake.addFirst(new Point(x+1,y));
        }


        public void showSnake(){

            for (int i=1;i<snake.size();i++){
                Point body=snake.get(i);
                background[body.y][body.x]='#';

            }
            Point head=snake.getFirst();//调换显示顺序以显示蛇头
            background[head.y][head.x]='$';
        }
        public void initBackground(){
            for(int rows=0;rows<background.length;rows++){
                for(int cols=0;cols<background[rows].length;cols++){
                    if (rows==0||rows==(height-1)/*||cols==0||cols==(width-1)显示左右边框*/){
                        background[rows][cols]='*';}else{background[rows][cols]=' ';}
                }
            }

        }

        public void showBackground() {
            for(int rows=0;rows<background.length;rows++){
                for(int cols=0;cols<background[rows].length;cols++){
                    System.out.print(background[rows][cols]);
                }System.out.println();
            }
        }
        public void refrash(){
            initBackground();
            showSnake();
            showFood();
            showBackground();
        }

        public boolean eatFood(){
        //获取原来蛇头
            Point head=snake.getFirst();
            if (head.equals(food)){
                //snake.addLast(new Point());
                return true;}
            return false;
        }

        public void isGameOver(){
             Point head=snake.getFirst();
             if (background[head.y][head.x]=='*'){isGameOver=true;}
             for (int i=1;i<snake.size();i++){
                 Point body=snake.get(i);
                 if (head.equals(body)){isGameOver=true;}
             }
        }



        public static  void main(String[]args) throws InterruptedException {
            SnakeGame snakeGame =new SnakeGame();
            snakeGame.initBackground();

            snakeGame.initSnake();
            snakeGame.showSnake();

            snakeGame.crateFood();
            snakeGame.showFood();

            snakeGame.showBackground();

            JFrame frame=new JFrame("方向盘");
            frame.add(new JButton("↑"),BorderLayout.NORTH);
            frame.add(new JButton("↓"),BorderLayout.SOUTH);
            frame.add(new JButton("←"),BorderLayout.WEST);
            frame.add(new JButton("→"),BorderLayout.EAST);
            JButton button=new JButton("点击控制方向");
            frame.add(button);

           FrameUtil.initFrame(frame,300,300);

           //给按钮添加事件监听器
            button.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int code=e.getKeyCode();
                    switch (code){
                        case KeyEvent.VK_UP:snakeGame.changeDirection(UP_DIRECTION);break;
                        case KeyEvent.VK_DOWN:snakeGame.changeDirection(DOWN_DIRECTION);break;
                        case KeyEvent.VK_LEFT:snakeGame.changeDirection(LEFT_DIRECTION);break;
                        case KeyEvent.VK_RIGHT:snakeGame.changeDirection(RIGHT_DIRECTION);break;
                        default:break;
                    }
                    snakeGame.move();

                    snakeGame.isGameOver();
                    snakeGame.refrash();
                    if (isGameOver){System.out.println("你好蔡啊！！");System.exit(0);}

                }
            });

            button.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int code=e.getKeyCode();
                    switch (code){
                        case 37:
                    }
                }
            });
/**
            for (int i=0;i<3;i++){
              //  snakeGame.moveUp();
                snakeGame.changeDirection(UP_DIRECTION);
                snakeGame.move();
                snakeGame.refrash();
                Thread.sleep(500);
            }
            for (int i=0;i<3;i++){
               // snakeGame.moveLeft();
                snakeGame.changeDirection();
                snakeGame.refrash();
                Thread.sleep(500);
            }
            for (int i=0;i<3;i++){
                //snakeGame.moveDown();
                snakeGame.refrash();
                Thread.sleep(500);
            }
            for (int i=0;i<3;i++){
                //snakeGame.moveRight();
                snakeGame.refrash();
                Thread.sleep(500);
            }
 */
        }
    }


