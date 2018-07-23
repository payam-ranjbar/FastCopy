import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String origin = "music.mp3";
        String dest = "copy-music.mp3";
        File file = new File(origin);
        
        File destFile = new File(dest);
        destFile.createNewFile();
        FileOutputStream f = new FileOutputStream(file);
        ThreadMaker threadMaker = new ThreadMaker();

        threadMaker.copy(origin, dest,file.length());
    }
}
