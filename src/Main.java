import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    private static void URLtoTXT(String directory) throws IOException {
        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles();
        ArrayList<String> url = new ArrayList<>();
        assert listOfFiles != null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {

                try (BufferedReader br = new BufferedReader(new FileReader(listOfFile))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        // process the line.
                        try {
                            if (line.substring(0, 4).equals("URL=")) {
                                url.add(line.substring(4));
                            }
                        } catch (NullPointerException ignored) {

                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        editTxt(dir, url);

    }

    private static void editTxt(File directory, ArrayList<String> urlList) throws IOException {
        Path file = directory.toPath();
        file = (Path) Paths.get(file.toString(), "url.txt");
        Files.write(file, urlList, StandardCharsets.UTF_8);

    }

    public static void main(String[] args) throws IOException {
        URLtoTXT(args[0]);
    }
}
