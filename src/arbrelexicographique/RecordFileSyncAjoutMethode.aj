package arbrelexicographique;

// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.nio.charset.Charset;
// import java.nio.file.FileSystemNotFoundException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.nio.file.StandardOpenOption;

// https://www.safaribooksonline.com/library/view/aspectj-cookbook/0596006543/ch04s03.html
public aspect RecordFileSyncAjoutMethode {

    // final static String homeDir = System.getProperty("user.home");
    // final static Path directory = Paths.get(homeDir,"/workspace");
    // final static Path file = Paths.get(directory.toString(), "/treeSauvTmp.txt");
    //
    // static {
    //
    // 	// TODO test it
    //     if (!Files.isDirectory(directory)) {
    //         throw new FileSystemNotFoundException(directory + "does not exist.");
    //     }
    //
    //     try {
    //         if (Files.isRegularFile(file)) {
    //             Files.delete(file);
    //         }
    //         else if (Files.exists(file)) {
    //             throw new RuntimeException("'" + file + "' exist but isn't a regular file (it could be for example an directory).");
    //         }
    //         Files.createFile(file);
    //     } catch (IOException x) {
    //         System.err.format("IOException: %s%n", x);
    //     }
    //
    //
    // }
    //
    // pointcut callAjout(String s) :
    //     target(ArbreLexicographique) &&
    //     call(boolean ajout(String)) &&
    //     args(s);
    //
    // // runs after calls to int Foo.m(int) that return normally
    // after (String s) returning : callAjout(s) {
    //     // System.out.println("blop" + s + "blop");
    //
    //
    //     try (BufferedWriter writer = Files.newBufferedWriter(file, Charset.defaultCharset(), StandardOpenOption.APPEND)) {
    //         writer.write(s, 0, s.length());
    //         writer.write("\n");
    //     } catch (IOException x) {
    //         System.err.format("IOException: %s%n", x);
    //     }
    // }
}

// vim:ft=java
