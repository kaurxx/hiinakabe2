

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Importalgused {
    public static HashMap<Integer, ArrayList<String>> Importalgused() throws IOException {
        HashMap<Integer, ArrayList<String>> algsed = new HashMap<>();
        Path file = Paths.get("alguspunktid.txt");
        Scanner s = new Scanner(file);

        ArrayList<String> list = new ArrayList<String>();

        int i = 0;
        while (s.hasNextLine()){
            String rida = s.nextLine();
            if(rida.equals("-")){
                if (i!=0) {
                    algsed.put(i,list);
                }
                list = new ArrayList<String>();
                i++;
            }
            else{
                list.add(rida);
            }
        }

        i = 0;
        while (i<6){
            i++;
            for(int k = 0; k<algsed.get(i).size();k++){
                System.out.println(i+" "+algsed.get(i).get(k));
            }
        }



        return algsed;
    }
}