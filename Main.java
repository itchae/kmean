import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Kmean kmean = new Kmean(2);
        File f = new File();
        System.out.println("Remplissage des points ...");
        kmean.nbPoint = f.parseFile(kmean, new FileReader("data.txt"));

        //kmean.dataSet.add(new Data(1.0, 1.0));
        //kmean.dataSet.add(new Data(4.0, 4.0));
        //kmean.dataSet.add(new Data(4.5, 4.5));
        //kmean.dataSet.add(new Data(2.0, 2.0));
        //kmean.nbPoint = 4;
        System.out.println("Remplissage terminé : "+  kmean.nbPoint + " ajoutés");
        // kmean.printDataSet();

        if (kmean.initClusters()) {
            // kmean.printCluster();

            // System.out.println("Initialisation de la hashmap");
            // kmean.initHash();
            // System.out.println("Initialisation terminée");
            // System.out.println("Taille Hashmap : "+kmean.map.size());
            // kmean.printHash();
            int i = 0;
            while (kmean.isChanged & i < 10) {
                // System.out.println("Je suis en train de boucler");
                kmean.calculClusterPlusProche();
                // System.out.println("Taille Hashmap : "+kmean.map.size());
                kmean.calculBarycentre();
                // System.out.println("Taille Hashmap : "+kmean.map.size());
                // kmean.printCluster();
                i++;
            }
        }
        
        // kmean.printCluster();
        // kmean.printDataSet();
        f.writeInFile(kmean);

    }
}

