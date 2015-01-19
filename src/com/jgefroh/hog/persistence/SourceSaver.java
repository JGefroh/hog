package com.jgefroh.hog.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SourceSaver {
    
    public static void save(final String outputPath, final String text) {
        PrintWriter writer = null;
        try {
            File file = new File(outputPath);
            file.getParentFile().mkdirs();
            writer = new PrintWriter(file, "UTF-8");
            writer.print(text);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
