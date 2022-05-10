package edu.school21.avaj.simulator.application;

import edu.school21.avaj.simulator.exeptions.IllegalSimulationParametrs;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class argValidator {

    private final String[] TYPES = {"Balloon", "JetPlane", "Helicopter"};

    public void validate(String path) throws IOException, NoSuchMethodException {
        String line;
        Optional<InputStream> in = Optional.ofNullable(argValidator.class.getResourceAsStream(path));
        BufferedReader br = new BufferedReader(new InputStreamReader(in.orElseThrow(() -> new FileNotFoundException("File not found"))));
        while ((line = br.readLine()) != null) {
            if (Main.numOfSimulations == null){
                int tmp = Integer.parseInt(line);
                if (tmp < 1)
                    throw new IllegalSimulationParametrs("Wrong simulation parameter: " + line);
                Main.numOfSimulations = tmp;
                continue;
            }
            if (!parseLine(line))
                throw new IllegalSimulationParametrs("Wrong simulation parameter: " + line);
            Main.args.add(line);
        }
    }

    private boolean parseLine(String line){
        ArrayList<String> types = new ArrayList<>(Arrays.asList(TYPES));
        String split[] = line.split(" ");
        return split.length == 5 &&
                types.contains(split[0]) &&
                Integer.parseInt(split[2]) >= 0 &&
                Integer.parseInt(split[3]) >= 0 &&
                Integer.parseInt(split[4]) >= 1;
    }

}
