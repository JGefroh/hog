package com.jgefroh.hog.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SourceSaver {
    
    public static void save(final FilePath path, final TextContent content) {
        PrintWriter writer = null;
        try {
            File file = new File(path.toString());
            file.getParentFile().mkdirs();
            writer = new PrintWriter(file, "UTF-8");
            writer.print(content.toString());
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
