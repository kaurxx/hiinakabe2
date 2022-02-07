import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Math.abs;

public class MouseListener1 implements java.awt.event.MouseListener {
    private handeler handeler;
    public int arv1 = 0;
    public gameobject tempnupp;
    public int käik = 1;
    private int käikudearv;
    public static HashMap<String, asukoht> kohad;

    static {
        try {
            kohad = ImportAsukohad.ImportAsukohad();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    MouseListener1(handeler handeler, int käikudearv) throws IOException {
        this.handeler = handeler;
        this.käikudearv = käikudearv;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(Menu.mouseover(e.getX(),e.getY(),1350, 0, 200,60)){
            mäng.gamestate= mäng.state.menu;
        }
        if (käik == 1) {
            System.out.println("0");
            for (int i = 0; i < handeler.object.size(); i++) {
                gameobject tempobject = handeler.object.get(i);
                if (tempobject.GetID() == ID.mangija1) {
                    if (abs(e.getX() - (tempobject.Getx() + mäng.scale(20))) < mäng.scale(25) & abs(e.getY() - (tempobject.Gety()) - mäng.scale(20)) < mäng.scale(25)) {
                        arv1 = 1;
                        //tempobject.varvi(Color.cyan);
                        tempnupp = tempobject;
                        System.out.println("1");

                    }
                }
            }
            if ((arv1 == 1) & (käik == 1)) {
                System.out.println("2");
                for (int c = 0; c < handeler.object.size(); c++) {
                    gameobject tempobejct2 = handeler.object.get(c);
                    if (tempobejct2.GetID() == ID.enemy) {
                        if ((abs(e.getX() - (tempobejct2.Getx() + mäng.scale(20))) < mäng.scale(25)) & (abs(e.getY() - (tempobejct2.Gety()) - mäng.scale(20)) < mäng.scale(25))) {
                            System.out.println("3");
                            ArrayList<asukoht> list = new ArrayList<asukoht>(kohad.values());
                            for (int k = 0; k < list.size(); k++) {
                                asukoht tempkordinaat = list.get(k);
                                if ((tempnupp.Getx() == mäng.scale(tempkordinaat.x)) & (tempnupp.Gety() == mäng.scale(tempkordinaat.y))) {
                                    System.out.println("4");
                                    String[] list2 = tempkordinaat.korval;
                                    for (int b = 0; b < list2.length; b++) {
                                        for (int v = 0; v < handeler.object.size(); v++) {
                                            if(!handeler.object.get(v).GetID().equals(ID.enemy)){
                                                if(kohad.get(list2[b])!=null){
                                            if((mäng.scale(kohad.get(list2[b]).x)==handeler.object.get(v).x)&(mäng.scale(kohad.get(list2[b]).y)==handeler.object.get(v).y)){

                                            for (int l = 0; l < list2.length; l++){
                                                System.out.println("hästi3");
                                                if (mäng.scale(kohad.get(list2[l]).y)==handeler.object.get(v).y&mäng.scale(kohad.get(list2[l]).x)==handeler.object.get(v).x){
                                                    try {

                                                    if ((abs(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi,kohad.get(list2[l]).nimi,kohad)).x + mäng.scale(20))-e.getX())<25) & ((abs((mäng.scale(kohad.get(ylehype(tempkordinaat.nimi,kohad.get(list2[l]).nimi,kohad)).y)+ mäng.scale(20))-e.getY())<25))){
                                                        tempnupp.Setx(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi,kohad.get(list2[l]).nimi,kohad)).x));
                                                        tempnupp.Sety(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi,kohad.get(list2[l]).nimi,kohad)).y));
                                                        käik = 2;
                                                        arv1 = 0;

                                                    }}catch (Exception as){}}}
                                            }
                                            }
                                            }}
                                        if ((abs(e.getX() - (mäng.scale((kohad.get(list2[b])).x) + mäng.scale(20))) < mäng.scale(25)) & (abs(e.getY() - (mäng.scale((kohad.get(list2[b])).y) + mäng.scale(20))) < mäng.scale(25))) {
                                            arv1 = 0;
                                            System.out.println("5");
                                            tempnupp.Sety(tempobejct2.Gety());
                                            tempnupp.Setx(tempobejct2.Getx());
                                            käik = 2;

                                        }
                                    }
                                }
                            }
                        }
                    }
                }


            }

        } else if (käik == 2) {

            käik=mangijad(2, 2,käikudearv,kohad,handeler,ID.mangija2,e);
        }
        else if (käik == 3) {
            käik=mangijad(3, 3,käikudearv,kohad,handeler,ID.mangija3,e);
        }
        else if (käik == 4) {
            käik=mangijad(4, 4,käikudearv,kohad,handeler,ID.mangija4,e);
        }
        else if (käik == 5) {
            käik=mangijad(5,5,käikudearv,kohad,handeler,ID.mangija5,e);
        }
        else if (käik == 6) {
            käik=mangijad(6,6,käikudearv,kohad,handeler,ID.mangija1,e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public String ylehype(String koht1, String koht2, HashMap<String, asukoht> list) {
        String vastus = "";


        ArrayList<String> vordub1list = new ArrayList<String>();
        int i = 0;
        while (i < list.get(koht2).korval.length) {
            int sarnased = 0;
            for (int k = 0; k < list.get(list.get(koht2).korval[i]).korval.length; k++) {
                try {
                    if (Arrays.stream(list.get(koht1).korval).anyMatch(list.get(list.get(list.get(koht2).korval[i]).korval[k]).nimi::equals)) {
                        sarnased++;
                    }
                }catch (Exception e){}

            }
            if (sarnased == 1) {
                vordub1list.add(list.get(koht2).korval[i]);
            }
            i++;
        }

        if (vordub1list.size() == 1) {
            vastus = (vordub1list.get(0));
        }
        else if(vordub1list.size() == 0){
            vastus="";
        }
        else {

            if (list.get(vordub1list.get(0)).korval.length > list.get(vordub1list.get(1)).korval.length) {
                vastus = vordub1list.get(0);

            } else {
                vastus = vordub1list.get(1);
            }
        }

        return vastus;
    }
    public int mangijad(int mängija, int käik, int käikudearv, HashMap<String, asukoht> kohad, handeler handeler, ID id, MouseEvent e) {
        if(mängija==käik) {
            for (int i = 0; i < handeler.object.size(); i++) {
                gameobject tempobject = handeler.object.get(i);
                if (tempobject.GetID() == id) {
                    if (abs(e.getX() - (tempobject.Getx() + mäng.scale(20))) < mäng.scale(25) & abs(e.getY() - (tempobject.Gety()) - mäng.scale(20)) < mäng.scale(25)) {
                        arv1 = 1;
                        tempnupp = tempobject;
                        System.out.println("1");

                    }
                }
            }
            if (arv1 == 1) {
                System.out.println("2");
                for (int c = 0; c < handeler.object.size(); c++) {
                    gameobject tempobejct2 = handeler.object.get(c);
                    if (tempobejct2.GetID() == ID.enemy) {
                        if ((abs(e.getX() - (tempobejct2.Getx() + mäng.scale(20))) < mäng.scale(25)) & (abs(e.getY() - (tempobejct2.Gety()) - mäng.scale(20)) < mäng.scale(25))) {
                            System.out.println("3");
                            ArrayList<asukoht> list = new ArrayList<asukoht>(kohad.values());
                            for (int k = 0; k < list.size(); k++) {
                                asukoht tempkordinaat = list.get(k);
                                if ((tempnupp.Getx() == mäng.scale(tempkordinaat.x)) & (tempnupp.Gety() == mäng.scale(tempkordinaat.y))) {
                                    System.out.println("4");
                                    String[] list2 = tempkordinaat.korval;
                                    for (int b = 0; b < list2.length; b++) {
                                        for (int v = 0; v < handeler.object.size(); v++) {
                                            if (!handeler.object.get(v).GetID().equals(ID.enemy)) {
                                                if ((mäng.scale(kohad.get(list2[b]).x) == handeler.object.get(v).x) & (mäng.scale(kohad.get(list2[b]).y) == handeler.object.get(v).y)) {
                                                    System.out.println("hästi3");
                                                    for (int l = 0; l < list2.length; l++) {
                                                        try {
                                                            if (mäng.scale(kohad.get(list2[l]).y) == handeler.object.get(v).y & mäng.scale(kohad.get(list2[l]).x) == handeler.object.get(v).x) {
                                                                try {
                                                                    if ((abs(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).x + mäng.scale(20)) - e.getX()) < 25) & ((abs((mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).y) + mäng.scale(20)) - e.getY()) < 25))) {
                                                                        tempnupp.Setx(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).x));
                                                                        tempnupp.Sety(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).y));
                                                                        arv1 = 0;
                                                                        if (käik == käikudearv) {
                                                                            return (1);
                                                                        } else {
                                                                            return (käik + 1);
                                                                        }
                                                                    }
                                                                } catch (Exception a) {
                                                                }

                                                            }
                                                        }catch (Exception a){}
                                                    }
                                                }
                                            }
                                            if ((abs(e.getX() - (mäng.scale((kohad.get(list2[b])).x) + mäng.scale(20))) < mäng.scale(25)) & (abs(e.getY() - (mäng.scale((kohad.get(list2[b])).y) + mäng.scale(20))) < mäng.scale(25))) {
                                                System.out.println("5");
                                                tempnupp.Sety(tempobejct2.Gety());
                                                tempnupp.Setx(tempobejct2.Getx());
                                                arv1 = 0;
                                                if(käik==käikudearv){
                                                käik = 1;}
                                                else{
                                                    käik+=1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

                return käik;

        }
        public static void renders(Graphics g){
            Font fnt = new Font("arial", 1, 50);
            g.setFont(fnt);
            g.drawRect(1350,0,200,60);
        g.drawString("MENU",1350,50);
        }
        public static void tick(){};
    }



