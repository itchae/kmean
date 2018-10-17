import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.UnsupportedEncodingException;

public class File {

    public static final String FILENAME = "results.txt";
    public int parseFile(Kmean k,FileReader file){
        int nbPoints = 0;
        Scanner scanner1 = new Scanner(file);
        Scanner scanner2 = new Scanner(file);
        scanner2.nextLine();
        while (scanner1.hasNext() && scanner2.hasNext()) {
            double value1 = scanner1.nextDouble();
            double value2 = scanner2.nextDouble();
            k.dataSet.add(new Data(value1, value2));
            nbPoints++;
        }
        return nbPoints;

    }

    public void writeInFile(Kmean k) throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter pw = new PrintWriter(FILENAME, "UTF-8");
        String xData = "";
        String yData = "";
        String clusterData = "";

        for (Data data : k.dataSet) {
            xData = +data.getx() + " ";
            yData = +data.gety() + " ";
            clusterData = +data.getCluster().getnCluster() + " ";
        }

        pw.print(xData +"\n"+yData+"\n"+clusterData);
        
    }
}