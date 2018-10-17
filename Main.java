import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Kmean kmean = new Kmean(2);
        File f = new File();
        kmean.nbPoint = f.parseFile(kmean, new FileReader("./data.txt"));
        kmean.initClusters();
        while (kmean.isChanged) {
            kmean.calculClusterPlusProche();
            kmean.calculBarycentre();
        }
        f.writeInFile(kmean);

    }
}