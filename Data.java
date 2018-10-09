
//import java.util.Pair;
import java.util.*;
import javafx.util.Pair;
import java.lang.*;

public class Data {
    Pair<Double,Double>coord;
    Cluster cluster;

    public Data(Double x, Double y) {
        this.coord = new Pair(x, y);
    }

    public Pair<Double,Double> getCoord(){
        return this.coord;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public Cluster getCluster() {
        return this.cluster;
    }

}