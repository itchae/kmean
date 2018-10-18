
//import java.util.Pair;
import java.util.*;
import javafx.util.Pair;
import java.lang.*;

public class Data {
    Pair<Double, Double> coord;
    // Cluster cluster;
    int cluster;

    public Data(Double x, Double y) {
        this.coord = new Pair(x, y);
        this.cluster = 1;
        // this.cluster = new Cluster();
    }

    public Pair<Double, Double> getCoord() {
        return this.coord;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public Double getx() {
        return coord.getKey();
    }

    public Double gety() {
        return coord.getValue();
    }

    public int getCluster() {
        return this.cluster;
    }

}