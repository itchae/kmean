
public class Main {
    public static void main() {
        Kmean kmean = new Kmean(2);
        File f = new File();
        kmean.nbPoint = f.parse(kmean, "nomdufichier");
        kmean.initClusters();
        while (kmean.isChanged) {
            kmean.calculClusterPlusProche();
            kmean.calculBarycentre();
        }
        f.writeInFile(kmean, "lefilereponse");

    }
}