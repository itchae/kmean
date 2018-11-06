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

        // kmean.dataSet.add(new Data(1.0, 1.0));
        // kmean.dataSet.add(new Data(4.0, 4.0));
        // kmean.dataSet.add(new Data(4.5, 4.5));
        // kmean.dataSet.add(new Data(2.0, 2.0));
        // kmean.nbPoint = 4;
        System.out.println("Remplissage terminé : " + kmean.nbPoint + " ajoutés");

        if (kmean.initClusters()) {
            while (kmean.isChanged) {
                kmean.calculClusterPlusProche();
                kmean.calculBarycentre();
            }
        }

        f.writeInFile(kmean);

    }
}
