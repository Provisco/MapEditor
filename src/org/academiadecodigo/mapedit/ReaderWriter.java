package org.academiadecodigo.mapedit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by codecadet on 25/10/16.
 */
public class ReaderWriter {


    public static void writeFile(char[] chars, String path) throws IOException {

        FileWriter writer = null;

        try {
            writer = new FileWriter(path);
            writer.write(chars);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }


    public static String readFile(String path) throws IOException {

        FileReader reader;
        BufferedReader bReader = null;
        String line = "";
        String result = "";

        try {
            reader = new FileReader(path);
            bReader = new BufferedReader(reader);
            while ((line = bReader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            bReader.close();
            return result;
        }
    }
}
/*       ALTERNATIVE READFILE WITH CHAR[] INSTEAD OF STRING SIGNATURE
    public char[] readFile(String path) throws IOException {

        FileReader reader;
        BufferedReader bReader = null;
        String line = "";
        String result = "";

        try {
            reader = new FileReader(path);
            bReader = new BufferedReader(reader);
            while((line = bReader.readLine()) != null){
                result += line;
            }
        } catch (IOException  e) {
            e.printStackTrace();
        } finally {

            bReader.close();
            return result.toCharArray();
        }
    }

  */

