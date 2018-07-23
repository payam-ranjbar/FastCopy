public class ThreadMaker {
    private long chunkSize;

    public ThreadMaker(){
        chunkSize = 1024;
    }
    public void copy(String filePath, String destPath, long Size) {
        int reminder = (int) (Size % chunkSize);
        int chunkNumber = (int)(Size / chunkSize);
        Copier[] copiers = new Copier[chunkNumber];
        for (int i = 0; i < chunkNumber; i++) {
            System.out.println("Make Copier: " + i);
            if(chunkNumber - i != 1) {
                copiers[i] = new Copier(filePath, destPath, i, chunkSize);
            } else {
                copiers[i] = new Copier(filePath, destPath, i, reminder);
            }
        }

        Thread [] threads = new Thread[chunkNumber];

        for (int j = 0; j < chunkNumber; j++) {
            System.out.println("Make Thread: " + j);
            threads[j] = new Thread(copiers[j], "thread number" + String.valueOf(j));
            threads[j].start();
        }
    }
}
