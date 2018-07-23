import java.io.*;

public class Copier implements Runnable {
    private String filePath , destPath;
    private int chunkIndex;
    private long chunkSize;
    public Copier(String filepath, String destination, int chunkIndex, long chunkSize) {
        filePath = filepath;
        destPath = destination;
        this.chunkSize = chunkSize;
        this.chunkIndex = chunkIndex;
    }

    @Override
    public void run() {
        System.out.println("thread: " + Thread.currentThread() + "is running");
        byte [] chunk = new byte[(int) chunkSize];

        File file = new File(filePath);
        File destFile = new File(destPath);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(chunkIndex*chunkSize);
            randomAccessFile.read();
            RandomAccessFile dest = new RandomAccessFile(destFile,"rw");
            dest.seek(chunkIndex*chunkSize);
            dest.write(chunk);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
