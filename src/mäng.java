import groovyjarjarantlr4.v4.misc.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class mäng extends Canvas implements Runnable{

    public mäng() throws IOException {
        handeler = new handeler();
        aken aken1=new aken(1650,1080,"kk", this);
        ///handeler.addgameobject(new tekst(scale(350),scale(50),ID.tekst,"Gamer"));
        ///handeler.addgameobject(new nupp(scale(200),scale(200),ID.mangija2));
        //handeler.addgameobject(new koht(scale(200),scale(200),ID.enemy, "punkt"));
        this.addKeyListener(new KeyInput(handeler));
        this.addMouseListener(new MouseListener1(handeler,2));
        this.requestFocus();

        ///////siin ta votab listi kohdatest
        HashMap<String,asukoht> kohad = ImportAsukohad.ImportAsukohad();



        int distance = 140;
        int size = 20;
        double xandyration= 0.55;
        for(int i = 0; i<9;i++){
            handeler.addgameobject(new koht(scale(960-size+(i-4)*distance),scale(540-size),ID.mangija2, "punkt"));////////////keskmine  ///!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<7;i++){
            handeler.addgameobject(new koht(scale((int)( 960-size+(i-3)*distance)),scale((int)(540-size-distance*xandyration)),ID.mangija2, "punkt"));  //////yks syles //!!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<7;i++){
            handeler.addgameobject(new koht(scale((int)( 960-size+(i-3)*distance)),scale((int)(540-size+distance*xandyration)),ID.mangija2, "punkt"));  /////yks alla //!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<5;i++){
            handeler.addgameobject(new koht(scale((int)( 960-size+(i-2)*distance)),scale((int)(540-size-distance*2*xandyration)),ID.mangija2, "punkt"));  ///kaks yles //!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<5;i++){
            handeler.addgameobject(new koht(scale((int)( 960-size+(i-2)*distance)),scale((int)(540-size+distance*2*xandyration)),ID.mangija2, "punkt")); ////kaks alla //!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<5;i++){
            handeler.addgameobject(new koht(scale((int)( 960-size+(i-2)*distance)),scale((int)(540-size-distance*3*xandyration)),ID.mangija2, "punkt"));  ///kolm yles //!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<5;i++){
            handeler.addgameobject(new koht(scale((int)( 960-size+(i-2)*distance)),scale((int)(540-size+distance*3*xandyration)),ID.mangija2, "punkt")); ////kolm alla //!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<5;i++){
            handeler.addgameobject(new koht(scale((int)( 960-size+(i-2)*distance)),scale((int)(540-size-distance*4*xandyration)),ID.mangija2, "punkt"));  ///neli yles //!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<5;i++){
            handeler.addgameobject(new koht(scale((int)( 960-size+(i-2)*distance)),scale((int)(540-size+distance*4*xandyration)),ID.mangija2, "punkt")); ////neli alla //!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }

        for(int i = 0; i<5;i++){
            if(i!=2) {
                handeler.addgameobject(new koht(scale((int) (960 - size + (i - 2) * distance)), scale((int) (540 - size - distance * 5 * xandyration)), ID.mangija2, "punkt"));  ///viis yles //!!yhed read
                gameobject tempobject = handeler.object.get(handeler.object.size()-1);
                System.out.println(tempobject.Getx()+" "+tempobject.Gety());
            }
        }
        for(int i = 0; i<5;i++){
            if(i!=2) {
                handeler.addgameobject(new koht(scale((int) (960 - size + (i - 2) * distance)), scale((int) (540 - size + distance * 5 * xandyration)), ID.mangija2, "punkt")); ////viis alla //!!yhed read
                gameobject tempobject = handeler.object.get(handeler.object.size()-1);
                System.out.println(tempobject.Getx()+" "+tempobject.Gety());
            }
        }

        for(int i = 0; i<5;i=i+4){
                handeler.addgameobject(new koht(scale((int) (960 - size + (i - 2) * distance)), scale((int) (540 - size - distance * 6 * xandyration)), ID.mangija2, "punkt"));  ///kuus yles //!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<5;i=i+4){
                handeler.addgameobject(new koht(scale((int) (960 - size + (i - 2) * distance)), scale((int) (540 - size + distance * 6 * xandyration)), ID.mangija2, "punkt")); ////kuus alla //!!yhed read
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }




        for(int i = 0; i<8;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-4)*distance+distance*0.5)),scale( (int)(540-size+distance*0.5*xandyration)),ID.mangija2, "punkt"));////////////yks all  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<8;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-4)*distance+distance*0.5)),scale( (int)(540-size-distance*0.5*xandyration)),ID.mangija2, "punkt"));////////////yks yles  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<6;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-3)*distance+distance*0.5)),scale( (int)(540-size+distance*1.5*xandyration)),ID.mangija2, "punkt"));////////////kaks all  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<6;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-3)*distance+distance*0.5)),scale((int)(540-size-distance*1.5*xandyration)),ID.mangija2, "punkt"));////////////kaks yles  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<4;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-2)*distance+distance*0.5)),scale( (int)(540-size+distance*2.5*xandyration)),ID.mangija2, "punkt"));////////////kolm all  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<4;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-2)*distance+distance*0.5)),scale((int)(540-size-distance*2.5*xandyration)),ID.mangija2, "punkt"));////////////kolm yles  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<4;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-2)*distance+distance*0.5)),scale( (int)(540-size+distance*3.5*xandyration)),ID.mangija2, "punkt"));////////////neli all  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<4;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-2)*distance+distance*0.5)),scale((int)(540-size-distance*3.5*xandyration)),ID.mangija2, "punkt"));////////////neli yles  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<4;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-2)*distance+distance*0.5)),scale( (int)(540-size+distance*4.5*xandyration)),ID.mangija2, "punkt"));////////////viis all  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<4;i++){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-2)*distance+distance*0.5)),scale((int)(540-size-distance*4.5*xandyration)),ID.mangija2, "punkt"));////////////viis yles  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<4;i=i+3){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-2)*distance+distance*0.5)),scale( (int)(540-size+distance*5.5*xandyration)),ID.mangija2, "punkt"));////////////kuus all  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }
        for(int i = 0; i<4;i=i+3){
            handeler.addgameobject(new koht(scale((int)(960-size+(i-2)*distance+distance*0.5)),scale((int)(540-size-distance*5.5*xandyration)),ID.mangija2, "punkt"));////////////kuus yles  ///!!teised read (need mis esimestest nihhkes)
            gameobject tempobject = handeler.object.get(handeler.object.size()-1);
            System.out.println(tempobject.Getx()+" "+tempobject.Gety());
        }






    }
    private handeler handeler;
    private Thread thread;
    private boolean running = false;
    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
        running=true;
    }
    public static int scale(int a){
        double laius =1920;
        double b = a;
        Dimension size = Toolkit. getDefaultToolkit(). getScreenSize();
        double k= size.width;
        b=b/(laius/k);
        int c=(int)b;
        return c;
    }
    public void run(){
        long LastTime = System.nanoTime();
        double amountOfTicks= 60.0;
        double ns= 1000000000/amountOfTicks;
        double delta =0;
        long timer = System.currentTimeMillis();
        int frames =0;
        while(running){
            long now= System.nanoTime();
            delta +=(now - LastTime)/ns;
            LastTime = now;
            while (delta >=1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                //System.out.println(frames);
            }
        }
        stop();
    }
    private void tick(){
        handeler.tick();
    }
    private void render(){
        BufferStrategy bs= this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        BufferedImage image = loadImage("img.png");
        g.drawImage(image, 0, 0, null);

        handeler.render(g);

        g.dispose();
        bs.show();
    }
    public BufferedImage loadImage(String path) {

        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource(path));

        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Image pilt=icon.getImage();
        Image muudetudpilt = pilt.getScaledInstance(scale(1920),scale(1080), Image.SCALE_SMOOTH);
        icon=new ImageIcon(muudetudpilt);

        Graphics g = image.createGraphics();

        icon.paintIcon(null, g, 0, 0);
        g.dispose();

        return image;

    }
    public void stop(){
       try{
           thread.join();
           running=false;
    }catch (Exception e){
       e.printStackTrace();}
    }

    public static void main(String args[]) throws IOException {
        new mäng();

    }
    public String ylehype(String koht1, String koht2, HashMap<String,asukoht> list){
        String vastus = "";


        ArrayList<String> vordub1list= new ArrayList<String>();
        int i = 0;
        while (i<list.get(koht2).korval.length){
            int sarnased = 0;
            for (int k = 0; k< list.get(list.get(koht2).korval[i]).korval.length; k++){
                    if (Arrays.stream(list.get(koht1).korval).anyMatch(list.get(list.get(list.get(koht2).korval[i]).korval[k]).nimi::equals)){
                        sarnased++;
                    }
            }
            if (sarnased==1){
                vordub1list.add(list.get(koht2).korval[i]);
            }
            i++;
        }

        if(vordub1list.size()==1){
            vastus = (vordub1list.get(0));
        }
        else{

            if(list.get(vordub1list.get(0)).korval.length>list.get(vordub1list.get(1)).korval.length){
                vastus = vordub1list.get(0);

            }
            else {
                vastus = vordub1list.get(1);
            }
        }

        return vastus;
    }

    }