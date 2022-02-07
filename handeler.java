import java.awt.*;
import java.util.LinkedList;

public class handeler {
    static LinkedList<gameobject> object= new LinkedList<gameobject>();
    public void tick(){
        try {
        for (gameobject tempObject : object) {
            tempObject.tick();
        }
        }catch (Exception e){}
    }
    public void render(Graphics g){
        try {

            for (gameobject tempObject : object) {
                tempObject.render(g);
            }
        }catch (Exception e){}

    }
    public static void addgameobject(gameobject object){
        handeler.object.add(object);
    }
    public void removegameobject(gameobject object){
        handeler.object.remove(object);
    }
}
