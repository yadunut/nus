import java.util.Scanner;

/**
 * This class implements a shop simulation.
 *
 * @author Yadunand Prem
 * @version CS2030S AY22/23 Semester 2
 */
class ShopSimulation extends Simulation {

  /**
   * The list of customer arrival events to populate
   * the simulation with.
   */
  private Event[] initEvents;

  /**
   * Constructor for a shop simulation.
   *
   * @param sc A scanner to read the parameters from. The first
   *           integer scanned is the number of customers; followed
   *           by the number of service counters. Next is a
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */
  public ShopSimulation(Scanner sc) {
    initEvents = new Event[sc.nextInt()];
    int numOfCounters = sc.nextInt();
    int maxCounterQueueSize = sc.nextInt();
    int maxShopQueueSize = sc.nextInt();

    Shop shop = new Shop(numOfCounters, maxShopQueueSize, maxCounterQueueSize);

    int id = 0;
    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      double serviceTime = sc.nextDouble();
      initEvents[id] = new ArrivalEvent(new Customer(serviceTime, arrivalTime), shop);
      id += 1;
    }
  }

  /**
   * Retrieve an array of events to populate the
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
