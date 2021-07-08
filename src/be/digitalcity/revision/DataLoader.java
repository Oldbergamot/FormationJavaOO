package be.digitalcity.revision;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//singleton
public class DataLoader {

    private static DataLoader dataLoader;

    private DataLoader() {

    }

    public static DataLoader getInstance() {
        if(dataLoader == null) {
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public List<Option> load(String path) {
        List <Option> options = new ArrayList<>();
        boolean firstLine = true;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));

            String line;
            String [] optionString = new String [4];
            boolean temp = false;

            while ((line = in.readLine()) != null) {
                if(firstLine){firstLine = false;
                    continue;
                }
                optionString = line.split(",");
                temp = Integer.parseInt(optionString[3]) == 1;

                    if(optionString[2].equals("JOURNALIER")) options.add(new Option(optionString[0],Double.parseDouble(optionString[1]), Frequency.JOURNALIER,temp));
                    else if(optionString[2].equals("SPORADIQUE")) options.add(new Option(optionString[0],Double.parseDouble(optionString[1]), Frequency.SPORADIQUE,temp));
                    else if (optionString[2].equals("SEMAINE")) options.add(new Option(optionString[0],Double.parseDouble(optionString[1]), Frequency.SEMAINE,temp));

                    //ignore les coquilles

            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return options;
    }
}
