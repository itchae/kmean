import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import java.util.Scanner;




public class File {

    public static final String FILENAME = "results.txt";
    public int parseFile(Kmean k,FileReader file){
        System.out.println("Parsefile");
        int nbPoints = 0;
        Scanner scanner1 = new Scanner(file);
        String lineX = scanner1.nextLine();
        String lineY = scanner1.nextLine();
        String[] resX = lineX.split(" +");
        String[] resY = lineX.split(" +");
        for (int i=0; i<resX.length;i++){
            k.dataSet.add(new Data(Double.parseDouble(resX[i]), Double.parseDouble(resY[i])));
            //System.out.println(resX[i]);
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
            clusterData =+ data.getCluster().getnCluster() + " ";
        }

        pw.print(xData +"\n"+yData+"\n"+clusterData);
        
    }
}