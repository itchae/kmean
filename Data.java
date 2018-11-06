
//import java.util.Pair;
import java.util.*;
import javafx.util.Pair;
import java.lang.*;

@SuppressWarnings("unchecked")
public class Data {
    public Pair<Double, Double> coord;

    public Data(Double x, Double y) {
        this.coord = new Pair(x, y);
    }

    public Pair<Double, Double> getCoord() {
        return this.coord;
    }

    public Double getx() {
        return coord.getKey();
    }

    public Double gety() {
        return coord.getValue();
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Data) {
            Data d = (Data) o;

            if (this.getx() == d.getx() && this.gety() == d.gety()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new int[] { (int) Math.round(this.getx()), (int) Math.round(this.gety()) });
    }
}
