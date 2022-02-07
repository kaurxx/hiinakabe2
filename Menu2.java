import java.awt.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class Menu2 extends MouseAdapter {
    private Menu2 menu2;
    private handeler tegija;
    private mäng mang;

    public Menu2(mäng mäng, handeler handeler) {
        tegija = handeler;
        mang = mäng;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (Menu.mouseover(mx, my, 100, 200, 500, 100)&(mang.gamestate== mäng.state.menu2)) {
            mangulaud();
            try {
                mang.addMouseListener(new MouseListener1(tegija, 2));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            mang.requestFocus();
            HashMap<Integer, ArrayList<String>> algused = new HashMap<>();
            try {
                algused = Importalgused.Importalgused();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            for (int i = 0; i < algused.get(1).size(); i++) {
                tegija.addgameobject(new nupp(mäng.scale(MouseListener1.kohad.get(algused.get(1).get(i)).x), mäng.scale(MouseListener1.kohad.get(algused.get(1).get(i)).y), ID.mangija1));
            }
            for (int i = 0; i < algused.get(4).size(); i++) {
                tegija.addgameobject(new nupp(mäng.scale(MouseListener1.kohad.get(algused.get(4).get(i)).x), mäng.scale(MouseListener1.kohad.get(algused.get(4).get(i)).y), ID.mangija2));
            }

        }
        if (Menu.mouseover(mx, my, 100, 350, 500, 100)&(mang.gamestate== mäng.state.menu2)) {
            mangulaud();
            try {
                mang.addMouseListener(new MouseListener1(tegija, 3));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            mang.requestFocus();
            HashMap<Integer, ArrayList<String>> algused = new HashMap<>();
            try {
                algused = Importalgused.Importalgused();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            for (int i = 0; i < algused.get(1).size(); i++) {
                tegija.addgameobject(new nupp(mäng.scale(MouseListener1.kohad.get(algused.get(1).get(i)).x), mäng.scale(MouseListener1.kohad.get(algused.get(1).get(i)).y), ID.mangija1));
            }
            for (int i = 0; i < algused.get(5).size(); i++) {
                tegija.addgameobject(new nupp(mäng.scale(MouseListener1.kohad.get(algused.get(5).get(i)).x), mäng.scale(MouseListener1.kohad.get(algused.get(5).get(i)).y), ID.mangija2));
            }
            for (int i = 0; i < algused.get(4).size(); i++) {
                tegija.addgameobject(new nupp(mäng.scale(MouseListener1.kohad.get(algused.get(4).get(i)).x), mäng.scale(MouseListener1.kohad.get(algused.get(4).get(i)).y), ID.mangija3));
            }
        }


    }

    public static void tick() {

    }

    public static void render(Graphics g) {
        Font fnt = new Font("arial", 1, 50);
        g.setFont(fnt);
        g.drawRect(100, 200, 500, 100);
        g.drawString("2 mängijat", 300, 250);
        g.drawRect(100, 350, 500, 100);
        g.drawString("3 mängijat", 300, 400);
        g.drawRect(100, 500, 500, 100);
        g.drawString("4 mängijat", 300, 550);
        g.drawRect(950, 200, 500, 100);
        g.drawString("5 mängijat", 1200, 250);
        g.drawRect(950, 350, 500, 100);
        g.drawString("6 mängijat", 1200, 400);
    }


    public void mangulaud(){
        mang.gamestate = mäng.state.mang;
        int distance = 140;
        int size = 20;
        double xandyration = 0.55;
        for (int i = 0; i < 9; i++) {
            tegija.addgameobject(new koht(mäng.scale(960 - size + (i - 4) * distance), mäng.scale(540 - size), ID.enemy, "punkt"));////////////keskmine  ///!!yhed read
        }
        for (int i = 0; i < 7; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 3) * distance)), mäng.scale((int) (540 - size - distance * xandyration)), ID.enemy, "punkt"));
        }
        for (int i = 0; i < 7; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 3) * distance)), mäng.scale((int) (540 - size + distance * xandyration)), ID.enemy, "punkt"));  /////yks alla //!!yhed read
        }
        for (int i = 0; i < 5; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size - distance * 2 * xandyration)), ID.enemy, "punkt"));  ///kaks yles //!!yhed read
        }
        for (int i = 0; i < 5; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size + distance * 2 * xandyration)), ID.enemy, "punkt")); ////kaks alla //!!yhed read
        }
        for (int i = 0; i < 5; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size - distance * 3 * xandyration)), ID.enemy, "punkt"));  ///kolm yles //!!yhed read
        }
        for (int i = 0; i < 5; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size + distance * 3 * xandyration)), ID.enemy, "punkt")); ////kolm alla //!!yhed read
        }
        for (int i = 0; i < 5; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size - distance * 4 * xandyration)), ID.enemy, "punkt"));  ///neli yles //!!yhed read
        }
        for (int i = 0; i < 5; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size + distance * 4 * xandyration)), ID.enemy, "punkt")); ////neli alla //!!yhed read
        }

        for (int i = 0; i < 5; i++) {
            if (i != 2) {
                tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size - distance * 5 * xandyration)), ID.enemy, "punkt"));  ///viis yles //!!yhed read
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 2) {
                tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size + distance * 5 * xandyration)), ID.enemy, "punkt")); ////viis alla //!!yhed read
            }
        }

        for (int i = 0; i < 5; i = i + 4) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size - distance * 6 * xandyration)), ID.enemy, "punkt"));  ///kuus yles //!!yhed read
        }
        for (int i = 0; i < 5; i = i + 4) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance)), mäng.scale((int) (540 - size + distance * 6 * xandyration)), ID.enemy, "punkt")); ////kuus alla //!!yhed read
        }


        for (int i = 0; i < 8; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 4) * distance + distance * 0.5)), mäng.scale((int) (540 - size + distance * 0.5 * xandyration)), ID.enemy, "punkt"));////////////yks all  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 8; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 4) * distance + distance * 0.5)), mäng.scale((int) (540 - size - distance * 0.5 * xandyration)), ID.enemy, "punkt"));////////////yks yles  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 6; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 3) * distance + distance * 0.5)), mäng.scale((int) (540 - size + distance * 1.5 * xandyration)), ID.enemy, "punkt"));////////////kaks all  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 6; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 3) * distance + distance * 0.5)), mäng.scale((int) (540 - size - distance * 1.5 * xandyration)), ID.enemy, "punkt"));////////////kaks yles  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 4; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance + distance * 0.5)), mäng.scale((int) (540 - size + distance * 2.5 * xandyration)), ID.enemy, "punkt"));////////////kolm all  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 4; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance + distance * 0.5)), mäng.scale((int) (540 - size - distance * 2.5 * xandyration)), ID.enemy, "punkt"));////////////kolm yles  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 4; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance + distance * 0.5)), mäng.scale((int) (540 - size + distance * 3.5 * xandyration)), ID.enemy, "punkt"));////////////neli all  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 4; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance + distance * 0.5)), mäng.scale((int) (540 - size - distance * 3.5 * xandyration)), ID.enemy, "punkt"));////////////neli yles  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 4; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance + distance * 0.5)), mäng.scale((int) (540 - size + distance * 4.5 * xandyration)), ID.enemy, "punkt"));////////////viis all  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 4; i++) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance + distance * 0.5)), mäng.scale((int) (540 - size - distance * 4.5 * xandyration)), ID.enemy, "punkt"));////////////viis yles  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 4; i = i + 3) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance + distance * 0.5)), mäng.scale((int) (540 - size + distance * 5.5 * xandyration)), ID.enemy, "punkt"));
            ////////////kuus all  ///!!teised read (need mis esimestest nihhkes)
        }
        for (int i = 0; i < 4; i = i + 3) {
            tegija.addgameobject(new koht(mäng.scale((int) (960 - size + (i - 2) * distance + distance * 0.5)), mäng.scale((int) (540 - size - distance * 5.5 * xandyration)), ID.enemy, "punkt"));////////////kuus yles  ///!!teised read (need mis esimestest nihhkes)


        }
    }
}