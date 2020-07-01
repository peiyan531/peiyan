package cn.view;

import cn.snake.FrameUtil;

import javax.swing.*;
import java.awt.*;

public class Demo extends JPanel {//面板

    @Override
    public void paint(Graphics g) {//画笔对象
        //画矩形
        g.setColor(Color.GRAY);
        g.fill3DRect(0,0,20,20,true);
        g.fill3DRect(20,0,20,20,true);
        g.setColor(Color.GREEN);
        g.fill3DRect(20,20,20,20,true);
        //写字
        g.setColor(Color.RED);
        g.setFont(new Font("宋体",Font.BOLD,30));
        g.drawString("你好菜啊",300,200);
    }

    public static void main(String[]args){
        JFrame frame=new JFrame("test");
        Demo demo=new Demo();
        frame.add(demo);
        FrameUtil.initFrame(frame,700,500);


     }
}
