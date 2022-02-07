import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Menu extends MouseAdapter {
    private handeler tegija;
    private mäng mang;
    private Menu2 menu2;

    public Menu(mäng mäng, handeler handeler) {
        tegija=handeler;
        mang= mäng;
    }
    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();
        if(mouseover(mx,my,550,100,500,100)&(mäng.gamestate==mäng.state.menu)){
            menu2=new Menu2(mang,tegija);
            mang.addMouseListener(menu2);
            mang.gamestate= mäng.state.menu2;

        }
        if(mouseover(mx,my,550,300,500,100)&(mäng.gamestate==mäng.state.menu)){
            System.exit(0);

        }

    }
    public void mouseReleased(MouseEvent e){

    }
    public static boolean mouseover(int mx, int my, int x, int y, int width, int height){
        if(mx>x && mx < x+width){
            if(my>y && my < y+height){
                return true;
            }
            else return false;
        }
        else return false;
    }
    public void tick(){

    }
    public void render(Graphics g){
        Font fnt=new Font("arial",1,50);
        g.setFont(fnt);
        g.drawString("alusta",700,175);
        g.drawRect(550,100,500,100);
        g.drawString("lõpeta",700,375);
        g.drawRect(550,300,500,100);
    }
}
