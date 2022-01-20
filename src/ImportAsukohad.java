import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ImportAsukohad {

    public static HashMap<String,asukoht> ImportAsukohad() throws IOException {
        HashMap<String,asukoht> asukohad = new HashMap<String,asukoht>();

        Path fileasukohad = Paths.get("asukohad.txt");
        Path filekordinaadid = Paths.get("kordinaadid.txt");

        Scanner sk =new Scanner(filekordinaadid);
        Scanner sa =new Scanner(fileasukohad);


        HashMap<String,String[]> listasukohad = new HashMap<String,String[]>();



        while (sa.hasNextLine()){
            String esimene = sa.nextLine();
            String[] teine = esimene.split("=");
            String[] kolmas = new String[1];


            try {
                kolmas = teine[1].split(" ");

            } catch (Exception e) {

                kolmas[0]=teine[1];
            }
            listasukohad.put(teine[0],kolmas);
        }
        int i = 0;
        while(sk.hasNextLine()){
            String[] esimene = sk.nextLine().split("=");
            String[] teine = esimene[1].split(" ");
            asukoht asub = new asukoht(esimene[0],listasukohad.get(esimene[0]), Integer.parseInt(teine[0]), Integer.parseInt(teine[1]));
            asukohad.put(esimene[0],asub);
            i++;
        }



        return asukohad;
    }
}
