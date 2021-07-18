import org.jsoup.nodes.Node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

public class Main {


    public static void main(String[] args) throws IOException {
        //ParsingSite parsingSite = new ParsingSite();
        //parsingSite.getLinks("https://lenta.ru/");
        File file = new File("D:\\VasilievAV\\Desktop\\test\\SiteMap.txt");
        FileWriter fr = null;
        fr = new FileWriter(file);


        String root = "https://lenta.ru/";
        TreeMap<String, String> herf = new ForkJoinPool().invoke(new ParsingSite(root));
        //System.out.println(herf);

        fr.write(root + "\n");
        TreeSet<String> states = new TreeSet<String>();
        for (String key : herf.keySet()) {
            int lengthKey = herf.get(key).length();
            if (lengthKey > 0) {
                //allContact = allContact + phoneBook.get(key) + " - " + key;
                //states.add(herf.get(key) + " - " + key);
                //System.out.println("  " + key);
                fr.write("  " + key + "\n");
            }
        }
        fr.close();

        //System.out.println(states);


    }



}
