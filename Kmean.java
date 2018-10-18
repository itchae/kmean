
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
        initClusters();
    }

    public void printCluster() {
        for (Cluster c : clusterSet) {
            System.out.println("Center x : "+ c.centerx);
            System.out.println("center y : "+ c.centery);
            System.out.println("Nb : "+ + c.nCluster);
        }
    }

    public void printDataSet() {
        for (Data d : dataSet) {
            System.out.println(d.getx());
            System.out.println(d.gety());
            System.out.println(d.cluster);
        }
    }

    // Initialisation des clusters aléatoiref
    public void initClusters() {
        Random r = new Random();
        for (int i = 0; i < this.nbClusters; i++) {
            System.out.println("Create cluster"+i);
            this.clusterSet.add(new Cluster(r.nextDouble() * XMAX, r.nextDouble() * YMAX, i));
        }
    }

    // Calcul et association du cluster le plus proche
    public void calculClusterPlusProche() {
        this.isChanged = false;
        // Calcul de la distance
        for (int i = 0; i < nbPoint; i++) { // Pour chaque point
            int clusterPlusProche = 0;

            for (int j = 0; j < nbClusters; j++) { // Pour chaque cluster
                double distanceMin;
                double distanceCalculee;
                double x1 = this.dataSet.get(i).getx();
                double y1 = this.dataSet.get(i).gety();
                double x2 = this.dataSet.get(j).getx();
                double y2 = this.dataSet.get(j).gety();
                distanceCalculee = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
                distanceMin = distanceCalculee;
                // Si premier tour de boucle ou que distance plus petite
                if (j == 0 || distanceMin > distanceCalculee) {
                    distanceMin = distanceCalculee;
                    this.dataSet.get(i).setCluster(j);
                    clusterPlusProche = j;
                    this.isChanged = true;
                }
            }
            // Si on change quelque chose ici, il faut mettre le boolean à True
            this.clusterSet.get(clusterPlusProche).dataSet.add(this.dataSet.get(i));
        }
    }

    // Calcul de la moyenne de points
    public void calculBarycentre() {
        for (int i = 0; i < nbClusters; i++) {
            Double xtot = 0.0;
            Double ytot = 0.0;
            int nbPt = this.clusterSet.get(i).dataSet.size();
            for (int j = 0; j < nbPt; j++) {
                xtot += this.clusterSet.get(i).dataSet.get(j).getx();
                ytot += this.clusterSet.get(i).dataSet.get(j).gety();
            }
            this.clusterSet.get(i).setCenter(xtot / nbPt, ytot / nbPt);
        }
    }
}
