import java.awt.*;

public class nupp extends gameobject{
    protected Color varv=Color.blue;
    nupp(int x, int y, ID id){
        super(x,y,id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        if(id==ID.mangija1){g.setColor(varv);}
        else if(id==ID.mangija2) {
            g.setColor(Color.green);}
        else if(id==ID.mangija3) {
            g.setColor(Color.cyan);}
        else if(id==ID.mangija4) {
            g.setColor(Color.white);}
        else if(id==ID.mangija5) {
            g.setColor(Color.magenta);}
        else {
            g.setColor(Color.red);}
        g.fillOval(x,y,mäng.scale(40),mäng.scale(40));

    }

}
