public class FileSysUtil {

  public void moveContents(Directory src, Directory dest) throws InterruptedException {
    synchronized (src) {
      Thread.sleep(1000);
      synchronized (dest) {
        System.out.println("Contents Moved Successfully");
      }
    }
  }
}
