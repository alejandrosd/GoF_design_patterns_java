public class GSTest {
  public static void main(String[] args) {
    ParkingLot parking = new ParkingLot();
    new Member("Client1", parking);
    new Member("Client2", parking);
    new Member("Client3", parking);
    new Member("Client4", parking);
    new Member("Client5", parking);
    new Member("Client6", parking);
    new Member("Client7", parking);
    new Member("Client8", parking);
    new Member("Client9", parking);
    new Member("Client10", parking);

  }

} class ParkingLot {
  //Assume 4 parking slots for simplicity
  public static final int MAX_CAPACITY = 4;
  private int totalParkedCars = 0;

  public synchronized void park(String member) {
    while (totalParkedCars >= MAX_CAPACITY) {
      try {
        System.out.println(" The store capacity is full " +
                           member + " has to wait ");
        wait();
      } catch (InterruptedException e) {
        //
      }
    }
    //precondition is true
    System.out.println(member + " has enter to the store");
    totalParkedCars = totalParkedCars + 1;
  }
  public synchronized void leave(String member) {
    totalParkedCars = totalParkedCars - 1;
    System.out.println(member +
                       " has left, notify a waiting member");
    notify();
  }
}

class Member extends Thread {
  private ParkingLot parking;
  private String name;

  Member(String n, ParkingLot p) {
    name = n;
    parking = p;
    start();
  }
  public void run() {
    System.out.println(name + " is ready to access the store");
    parking.park(name);
    try {
      sleep(1000);
    } catch (InterruptedException e) {
      //
    }
    //leave after 1000ms
    parking.leave(name);
  }
}
