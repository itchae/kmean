
//import java.util.ArrayList;
//import java.util.Random;
import java.util.*;
import javafx.util.Pair;
import java.lang.*;

public class Kmean {
    public boolean isChanged;
    public int nbPoint;
    public int nbClusters;
    public ArrayList<Data> dataSet;
    public ArrayList<Cluster> clusterSet;

    public static final double XMAX = 100;
    public static final double YMAX = 100;

    public Kmean(int nbCluster) {
        this.nbClusters = nbCluster;
        this.nbPoint = 2;
        this.isChanged = false;
        this.clusterSet = new ArrayList<Cluster>();
        this.dataSet = new ArrayList<Data>();
        initData();
        initClusters();
    }

    // Initialisation des clusters aléatoire
    public void initClusters() {
        Random r = new Random();
        for (int i = 0; i < this.nbClusters; i++) {
            this.clusterSet.add(new Cluster(r.nextDouble() * XMAX, r.nextDouble() * YMAX));
        }
    }

    // Calcul et association du cluster le plus proche
    public void calculClusterPlusProche() {

        // Calcul de la distance
        for (int i = 0; i < nbPoint; i++) { // Pour chaque point
            double clusterPlusProche;
            for (int j = 0; j < nbClusters; j++) { // Pour chaque cluster
                double distanceMin;
                double distanceCalculee;
                double x1 = this.dataSet.get(i).getx();
                double y1 = this.dataSet.get(i).gety();
                double x2 = this.dataSet.get(j).getx();
                double y2 = this.dataSet.get(j).gety();
                distanceCalculee = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

                // Si premier tour de boucle ou que distance plus petite
                if (j == 0 || distanceMin > distanceCalculee) {
                    distanceMin = distanceCalculee;
                    this.dataSet.get(i).setCluster(j);
                    clusterPlusProche = j;
                }
            }
            // Si on change quelque chose ici, il faut mettre le boolean à True
            this.clusterSet[clusterPlusProche].add(this.dataSet[i]);
        }
    }

    // Calcul de la moyenne de points
    public void calculBarycentre() {
        for (int i = 0; i < nbClusters; i++) {
            int xtot;
            int ytot;
            int nbPt = this.clusterSet[i].dataSet.size();
            for (int j = 0; j < nbPt; j++) {
                xtot += this.clusterSet.get(i).dataSet.get(j).getx;
                ytot += this.clusterSet.get(i).dataSet.get(j).gety;
            }
            this.clusterSet[i].setCenter(xtot / nbPt, ytot / nbPt);
        }
    }
}
