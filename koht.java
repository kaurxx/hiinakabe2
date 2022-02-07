import java.awt.*;

public class koht extends gameobject {
    protected String nimi2;
    koht(int x, int y, ID id, String nimi) {
        super(x, y, id);
        nimi2=nimi;
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
            g.setColor(Color.darkGray);
        g.fillOval(x,y,mäng.scale(40),mäng.scale(40));

    }
    public String Getnimi(){
        return nimi2;
    }
}
