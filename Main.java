import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Kmean kmean = new Kmean(2);
        File f = new File();
        System.out.println("Remplissage des points ...");
        kmean.nbPoint = f.parseFile(kmean, new FileReader("data.txt"));
        System.out.println("Remplissage terminé : "+ kmean.nbPoint + " ajoutés");
        //kmean.dataSet.add(new Data(2.0, 2.0));
        //kmean.dataSet.add(new Data(4.0, 4.0));
        // kmean.printDataSet();
        //kmean.nbPoint = 2;
        if (kmean.initClusters()) {
            //kmean.printCluster();
            
            //System.out.println("Initialisation de la hashmap");
            kmean.initHash();
            //System.out.println("Initialisation terminée");
            // System.out.println("Taille Hashmap : "+kmean.map.size());
            // kmean.printHash();
            while (kmean.isChanged) {
                // System.out.println("Je suis en train de boucler");
                kmean.calculClusterPlusProche();
                // System.out.println("Taille Hashmap : "+kmean.map.size());
                kmean.calculBarycentre();
                // System.out.println("Taille Hashmap : "+kmean.map.size());
                // kmean.printCluster();
            }
        }

        // kmean.printCluster();
        // kmean.printDataSet();
        // f.writeInFile(kmean);

    }
}