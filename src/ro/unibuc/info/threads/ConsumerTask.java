package ro.unibuc.info.threads;

import static ro.unibuc.info.Main.numbers;

public class ConsumerTask implements Runnable{

  @Override
  public void run() {
    while(true){
      synchronized (numbers){
        if(!numbers.isEmpty()){
          int nr = numbers.get(0);
          numbers.remove(0);
          System.out.println(Thread.currentThread().getName() + " removed number " + nr);
        }
        else {
          try {
            numbers.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println(Thread.currentThread().getName() + "list empty");
        }
      }
    }
  }
}
