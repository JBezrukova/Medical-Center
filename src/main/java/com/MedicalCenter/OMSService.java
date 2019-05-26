package com.MedicalCenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OMSService {

    public static boolean checkOMS(String oms) {
        String file = "./OMSBase.txt";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(oms))
                    return true;
            }
        } catch (IOException e) {
            System.err.format(e.toString());
        }
        return false;
    }
}
