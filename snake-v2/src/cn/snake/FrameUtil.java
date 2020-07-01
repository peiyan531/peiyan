package cn.snake;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

//初始化窗口的工具类
public class FrameUtil {

    public static void initFrame(JFrame frame,int width,int height){
        Toolkit toolkit=Toolkit.getDefaultToolkit();  //获取一个与系统相关的工具类对象
        //返回屏幕的尺寸
        Dimension d=toolkit.getScreenSize();
        int x=(int)d.getWidth();
        int y=(int)d.getHeight();
        frame.setBounds((x-width)/2, (y-height)/2, width, height);
        frame.setVisible(true); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
