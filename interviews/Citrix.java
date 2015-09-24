package interviews;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 *  Read in a file with lines consisting of "<city>,<state>,<population>"
 *  Print Lines of Top N Populations
 */
public class Citrix {

    private static String filePath = "C:\\dev\\interviews\\citrix_cities.txt";

    public static void main (String[] args) {

        int topCities = 3;
        topPopulation(readValues(filePath), topCities);
    }

    public static List<Line> readValues(String file) {

        BufferedReader br = null;
        String line = "";
        List<Line> list = new ArrayList<Line>();

        try {
            br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                Line row = new Line(values[0], values[1], Integer.parseInt(values[2]));
                list.add(row);
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }

        return list;
    }

    public static void topPopulation (List<Line> list, int num) {
        Collections.sort(list, new PopulationComparator());
        for(int i=0; i<num; i++) {
            System.out.println(list.get(i));
        }
    }

}

class Line extends Citrix {
    private String city;
    private String state;
    private int population;

    public Line(String city, String state, int population) {
        this.city = city;
        this.state = state;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public String toString() {
        return "City: " + city + "; State: " + state + "; Population: " + population;
    }
}

class PopulationComparator implements Comparator<Line> {
    @Override
    public int compare(Line a, Line b) {
        return b.getPopulation() - a.getPopulation();
    }
}

