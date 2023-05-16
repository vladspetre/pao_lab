package ro.unibuc.info.threads;

public class PrintNumbersRunnable implements Runnable{

  @Override
  public void run() {

    System.out.println(Thread.currentThread().getName() + "Starting printing numbers");
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " "+ i);
    }

  }
}
