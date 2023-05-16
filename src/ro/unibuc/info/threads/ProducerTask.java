package ro.unibuc.info.threads;

import static ro.unibuc.info.Main.numbers;

import java.util.Random;

public class ProducerTask implements Runnable {

  @Override
  public void run() {
    Random rand = new Random();
    while (true) {
      synchronized (numbers) {
        if (numbers.size() < 10) {
          int nr = rand.nextInt();
          numbers.add(nr);
          System.out.println(Thread.currentThread().getName() + " added number " + nr);
          numbers.notifyAll();
        } else {
          try {
            numbers.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println(Thread.currentThread().getName() + "list full");
        }
      }
    }

  }
}
