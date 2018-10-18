import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;



public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Kmean kmean = new Kmean(2);
        File f = new File();
        kmean.nbPoint = f.parseFile(kmean, new FileReader("data.txt"));
        while (kmean.isChanged) {
            kmean.calculClusterPlusProche();
            kmean.calculBarycentre();
        }
        kmean.printCluster();
        kmean.printDataSet();
        f.writeInFile(kmean);

    }
}