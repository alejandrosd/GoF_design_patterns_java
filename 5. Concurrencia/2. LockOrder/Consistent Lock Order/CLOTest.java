public class CLOTest {

    public static void main(String[] args) {
        Directory dir1 = new Directory("Directory 1");
        Directory dir2 = new Directory("Directory 2");

        FileTransfer transfer1 = new FileTransfer(dir1, dir2);
        FileTransfer transfer2 = new FileTransfer(dir2, dir1);

        transfer1.start();
        transfer2.start();
    }

}

class FileTransfer extends Thread {
    Directory src, dest;

    public FileTransfer(Directory src, Directory dest) {
        this.src = src;
        this.dest = dest;
    }

    @Override
    public void run() {
        FileSysUtil_Rev futil = new FileSysUtil_Rev();
        try {
            futil.moveContents(src, dest);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
