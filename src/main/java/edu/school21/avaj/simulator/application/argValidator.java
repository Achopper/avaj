package edu.school21.avaj.simulator.application;

import edu.school21.avaj.simulator.exeptions.IllegalSimulationParametrs;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class argValidator {

    private final String[] TYPES = {"Balloon", "JetPlane", "Helicopter"};

    public void validate(String path) throws IOException, NoSuchAlgorithmException {
        String line;
        Optional<InputStream> in = Optional.ofNullable(argValidator.class.getResourceAsStream(path));
        BufferedReader br = new BufferedReader(new InputStreamReader(in.orElseThrow(() -> new FileNotFoundException("File not found"))));
        ArrayList<String> types = new ArrayList<>(Arrays.asList(TYPES));
        while ((line = br.readLine()) != null) {
            if (Main.numOfSimulations == null){
                int tmp = Integer.parseInt(line);
                if (tmp < 1)
                    throw new IllegalSimulationParametrs("Wrong simulation parameter: " + line);
                Main.numOfSimulations = tmp;
                continue;
            }
            if (!parseLine(line, types))
                throw new IllegalSimulationParametrs("Wrong simulation parameter: " + line);
            Main.args.add(getLine(line.substring(0, line.indexOf(" ")), types, line));
        }
        br.close();
    }

    private boolean parseLine(String line, ArrayList<String> types) throws NoSuchAlgorithmException {
        String[] split = line.split(" ");
        return split.length == 5 &&
                (types.contains(split[0]) || checkHash(split[0], types))&&
                Integer.parseInt(split[2]) >= 0 &&
                Integer.parseInt(split[3]) >= 0 &&
                Integer.parseInt(split[4]) >= 1;
    }

    String MD5Encrypter(String toEncrypt) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("MD5");
        byte[] digest;

        mDigest.reset();
        mDigest.update(toEncrypt.getBytes());
        digest = mDigest.digest();

        BigInteger bigInt = new BigInteger(1, digest);
        return bigInt.toString(16);
    }

    boolean checkHash(String string, ArrayList<String> types) throws NoSuchAlgorithmException {
        for (String type : types) {
            if (MD5Encrypter(type).equals(string)){
                return true;
            }
        }
        return false;
    }

    String getLine(String string, ArrayList<String> types, String line) throws NoSuchAlgorithmException {
        for (String type : types) {
            if (MD5Encrypter(type).equals(string)){
                line = line.replace(MD5Encrypter(type), type);
                return line;
            }
        }
        return line;
    }
}
