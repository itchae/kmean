import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Map;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import java.util.Scanner;

public class File {

    public static final String FILENAME = "results.txt";

    public int parseFile(Kmean k, FileReader file) {
        // System.out.println("Parsefile");
        int nbPoints = 0;
        Scanner scanner1 = new Scanner(file);
        String lineX = scanner1.nextLine();
        String[] resX = lineX.split("\\s+");
        String lineY = scanner1.nextLine();
        String[] resY = lineY.split("\\s+");
       
        for (int i=1; i<resX.length;i++){
            k.dataSet.add(new Data(Double.parseDouble(resX[i]), Double.parseDouble(resY[i])));
            //System.out.println(k.dataSet.size());
            //System.out.println("x : " + resX[i]);
            //System.out.println("y : " + resY[i]);
            nbPoints++;
        }
        return nbPoints;

    }

    public void writeInFile(Kmean k) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter(FILENAME, "UTF-8");
        String xData = "";
        String yData = "";
        String clusterData = "";
        int cpt = 0;
        for (Map.Entry<Data, Cluster> me : k.map.entrySet()) {
            xData += me.getKey().getx() + " ";
            yData += me.getKey().gety() + " ";
            clusterData += me.getValue().getnCluster() + " ";
            cpt++;
        }
        pw.print(xData + "\n" + yData + "\n" + clusterData);
        pw.close();

    }
}
