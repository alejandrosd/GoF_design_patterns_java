public class FileSysUtil_Rev {

  public void moveContents(Directory src, Directory dest) throws InterruptedException {
    //System.out.println("src: "+src.hashCode()+"  "+src);
    //System.out.println("dest: "+dest.hashCode()+"   "+dest);
    if (src.hashCode() > dest.hashCode()) {
      
      synchronized (src) {
        Thread.sleep(1000);
        synchronized (dest) {
          System.out.println("Contents Moved Successfully");
        }
      }
    } else {
      synchronized (dest) {
        Thread.sleep(1000);
        synchronized (src) {
          System.out.println("Contents Moved Successfully");
        }
      }
    }
  }
}
