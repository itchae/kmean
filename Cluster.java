
import java.util.ArrayList;
import javafx.util.Pair;
import java.lang.*;

class Cluster {
    double centerx;
    double centery;
    int nCluster;
    int nbPoint;
    // Il faudrait qu'un cluster ai son nombre de point alloué

    public Cluster(double x, double y, int nCluster) {
        this.centerx = x;
        this.centery = y;
        this.nCluster = nCluster;
    } 
 
    public void setCenter(double x, double y) {
        this.centerx = x;
        this.centery = y;

    }

    public int getnCluster() {
        return this.nCluster;
    }

    public void setnCluster(int n) {
        this.nCluster = n;
    }

    /*
     * @Override public boolean equals(Object o) { boolean res = false; if
     * (this.centerx == c.centerx) { if (this.centery == c.centery) { if
     * (this.nCluster == c.nCluster) { res = true; } } } return res; }
     */

}