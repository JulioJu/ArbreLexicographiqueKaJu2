package arbrelexicographique;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public aspect Serialisation {

    declare parents : arbrelexicographique.ArbreLexicographique implements Serializable;

    public void ArbreLexicographique.save(String fileName) {

        // Not check if parent directory exists, because make with JFileChooser
        Path file = Paths.get(fileName);

        // TODO Make rather an alert Windows
        // Test if file exit
        if (Files.isRegularFile(file)) {
            System.out.println("Warning : file exist !");
            try {
                Files.delete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (Files.exists(file)) {
            throw new RuntimeException("'" + file + "' exist but isn't a regular file (it could be for example a directory).");
        }

        // Create and write file
        try (BufferedWriter writer = Files.newBufferedWriter(file, Charset.defaultCharset())) {
            System.out.println("Recording in progress…");
            writer.write(this.toString());
            System.out.println("File recording performed");
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }

    public void ArbreLexicographique.load(String fileName) {

        Path file = Paths.get(fileName);

        try (BufferedReader reader = Files.newBufferedReader(file, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                line = line.replace(System.getProperty("line.separator"), "");
                line = line.replace("\n", "").replace("\r", "");
                this.ajout(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }
}

// vim:ft=java
