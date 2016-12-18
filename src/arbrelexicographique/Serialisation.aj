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

    // TODO delete it !!!!!
    final static String homeDir = System.getProperty("user.home");
    final static Path directory = Paths.get(homeDir,"/workspace");
    final static Path file = Paths.get(directory.toString(), "/treeSauvTmp.txt");


    declare parents : arbrelexicographique.ArbreLexicographique implements Serializable;

    public void ArbreLexicographique.save(String fileName) {

        // TODO Make rather an alert Windows
        // Test if parent directory exist
        System.out.println("essai");
        if (!Files.isDirectory(directory)) {
            throw new FileSystemNotFoundException(directory + "does not exist.");
        }

        // TODO Make rather an alert Windows
        // Test if file exit
        if (Files.isRegularFile(file)) {
            System.out.println("Warning : file exist !");
            try {
				Files.delete(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
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

        try (BufferedReader reader = Files.newBufferedReader(file, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                this.ajout(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }
}

// vim:ft=java
