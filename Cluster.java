
import java.util.ArrayList;
import javafx.util.Pair;
import java.lang.*;

class Cluster {
    ArrayList<Data> dataSet;
    double centerx;
    double centery;
    int nCluster;

    public Cluster(double x, double y) {
        this.centerx = x;
        this.centery = y;
    }

    public void setCenter(double x, double y){
        this.centerx = x;
        this.centery = y;
    
    }
    public int getnCluster(){
        return this.nCluster;
    }
    
    public void setnCluster(int n){
        this.nCluster = n;
    }
}