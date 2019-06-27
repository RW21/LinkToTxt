import java.io.File;

public class Main {

    public static void showFiles(String directory) {
        File dir = new File(directory);
        File[] directoryListing = dir.listFiles();
        System.out.println(directoryListing);

    }

    public static void main(String[] args) {
	// write your code here
        showFiles("C:\\Users\\RW\\Desktop\\code\\compass\\compass");
    }
}
