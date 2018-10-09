
import java.util.ArrayList;
import javafx.util.Pair;
import java.lang.*;

class Cluster {
    ArrayList<Data> dataSet;
    double centerx;
    double centery;

    public Cluster(double x, double y) {
        this.centerx = x;
        this.centery = y;
    }
}