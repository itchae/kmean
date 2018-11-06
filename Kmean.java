
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
    public HashMap<Data, Cluster> map;

    // Constructeur
    public Kmean(int nbCluster) {
        this.nbClusters = nbCluster;
        this.nbPoint = 2;
        this.isChanged = true;
        this.clusterSet = new ArrayList<Cluster>();
        this.dataSet = new ArrayList<Data>();
        this.map = new HashMap<Data, Cluster>();
    }

    // Remplissage de la liste de points
    // nbData : le nombre de points désirés
    // xmin, xmax : la range sur x voulue
    // ymin, ymax : la range sur y voulue
    public void initData(int nbData, double xmin, double xmax, double ymin, double ymax) {
        Random r = new Random();
        for (int i = 0; i < nbData; i++) {
            Data d = new Data(xmin + (xmax - xmin) * r.nextDouble(), ymin + (ymax - ymin) * r.nextDouble());
            this.dataSet.add(d);
        }
    }

    // Initialisation des clusters aléatoire
    public boolean initClusters() {
        Random r = new Random();
        if (this.nbPoint >= this.nbClusters) {
            for (int i = 0; i < this.nbClusters; i++) {
                System.out.println("Create cluster" + i);
                int numeroPoint = r.nextInt(nbPoint)/* %nbPoint */;
                System.out.println("Point numero : " + numeroPoint);
                Data d = this.dataSet.get(numeroPoint);
                this.clusterSet.add(new Cluster(d.getx(), d.gety(), i));
                System.out.println(d.getx() + "    " + d.gety());
            }
            return true;
        } else {
            return false;
        }

    }

    // Initialisation de la hashmap
    public void initHash() {
        for (int i = 0; i < nbPoint; i++) { // Pour chaque point
            int clusterPlusProche = 0;
            double distanceMin = this.distance(this.clusterSet.get(0).centerx, this.clusterSet.get(0).centery,
                    this.dataSet.get(i).getCoord());
            // System.out.println("Point " + i + " Dist min : " + distanceMin);
            this.map.put(this.dataSet.get(i), this.clusterSet.get(0));
            for (int j = 0; j < nbClusters; j++) { // Pour chaque cluster
                double distanceCalculee;
                double dx = this.dataSet.get(i).getx();
                double dy = this.dataSet.get(i).gety();
                double cx = this.clusterSet.get(j).centerx;
                double cy = this.clusterSet.get(j).centery;
                distanceCalculee = this.distance(cx, cy, this.dataSet.get(i).getCoord());
                // System.out.println("Dist calculée : " + distanceCalculee);
                if (distanceMin > distanceCalculee /* & ancien.nbPoint > 1 */) {
                    distanceMin = distanceCalculee;
                    System.out.println("Je suis plus proche de " + this.clusterSet.get(j).getnCluster());
                    this.map.put(this.dataSet.get(i), this.clusterSet.get(j));
                    this.isChanged = true;
                }
            }
        }
    }

    // Calcul de la distance entre deux points
    public double distance(double cx, double cy, Pair<Double, Double> p) {
        return Math.sqrt(Math.pow(cy - p.getValue(), 2) + Math.pow(cx - p.getKey(), 2));
    }

    // Calcul et association du cluster le plus proche
    public void calculClusterPlusProche() {
        System.out.println("Calcul Cluster le plus proche");
        this.isChanged = false;
        // Calcul de la distance
        for (int i = 0; i < nbPoint; i++) { // Pour chaque point
            int clusterPlusProche = 0;
            double distanceMin = this.distance(this.clusterSet.get(0).centerx, this.clusterSet.get(0).centery,
                    this.dataSet.get(i).getCoord());

            if (!this.map.containsKey(this.dataSet.get(i))) {

                this.map.put(this.dataSet.get(i), this.clusterSet.get(0));
                distanceMin = this.distance(this.clusterSet.get(0).centerx, this.clusterSet.get(0).centery,
                        this.dataSet.get(i).getCoord());
            } else {
                Cluster c = this.map.get(this.dataSet.get(i));
                distanceMin = this.distance(c.centerx, c.centery, this.dataSet.get(i).getCoord());
            }

            for (int j = 0; j < nbClusters; j++) { // Pour chaque cluster
                double distanceCalculee;
                double dx = this.dataSet.get(i).getx();
                double dy = this.dataSet.get(i).gety();
                double cx = this.clusterSet.get(j).centerx;
                double cy = this.clusterSet.get(j).centery;
                distanceCalculee = this.distance(cx, cy, this.dataSet.get(i).getCoord());
                // System.out.println("Dist calculée : " + distanceCalculee);
                // distanceCalculee = Math.sqrt((cy - dy) * (cy - dy) + (cx - dx) * (cx - dx));
                // Si premier tour de boucle ou que distance plus petite
                // Cluster ancien = this.map.get(this.dataSet.get(i));
                if (distanceMin > distanceCalculee /* & ancien.nbPoint > 1 */) {
                    distanceMin = distanceCalculee;
                    // System.out.println("Je suis plus proche de " +
                    // this.clusterSet.get(j).getnCluster());
                    // Put met a jour car on ne peut pas avoir deux clés de même valeur
                    this.map.put(this.dataSet.get(i), this.clusterSet.get(j));
                    this.isChanged = true;
                    // ancien.nbPoint--;
                    // this.clusterSet.get(j).nbPoint++;
                    // TODO : Vérifier que chaque cluster ai au moins un point
                }
            }
        }
    }

    // Calcul de la moyenne de points
    public void calculBarycentre() {
        System.out.println("Calcul Barycentre");
        for (int i = 0; i < nbClusters; i++) {
            Double xtot = 0.0;
            Double ytot = 0.0;
            int cpt = 0;
            Set cles = this.map.entrySet();
            Iterator it = cles.iterator();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next(); // tu peux typer plus finement ici
                Cluster valeur = (Cluster) pair.getValue(); // tu peux typer plus finement ici

                if (valeur.equals(this.clusterSet.get(i))) { // Attention je ne suis pas sur ici
                    Data d = (Data) pair.getKey();
                    xtot += d.getx();
                    ytot += d.gety();
                    cpt++;
                }
            }

            /*
             * Set cles = this.map.entrySet(); Iterator it = cles.iterator(); while
             * (it.hasNext()) { Map.Entry pair = (Map.Entry)it.next();
             * System.out.println(pair.getKey()); System.out.println(pair.getValue()); }
             */
            // System.out.println(xtot / cpt);
            // System.out.println(ytot / cpt);
            this.clusterSet.get(i).centerx = xtot / cpt;
            this.clusterSet.get(i).centery = ytot / cpt;

        }
    }

    public void printCluster() {
        System.out.println("AFFICHAGE DU CLUSTER");
        for (Cluster c : clusterSet) {
            System.out.println("Center x : " + c.centerx);
            System.out.println("center y : " + c.centery);
            System.out.println("Nb : " + +c.nCluster);
            System.out.println("Nombre de points : " + c.nbPoint);
        }

    }

    public void printDataSet() {

        System.out.println("AFFICHAGE DES POINTS");
        for (Data d : dataSet) {

            System.out.println(d.gety());
        }
    }

    public void printHash() {

        System.out.println("AFFICHAGE DE LA HASHMAP");

        Set cles = this.map.entrySet();
        Iterator it = cles.iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }

    }
}
