package com.tasks.SourceCodeChannel.AnonimClasses;


public class AnonymousTaskMain {

  /*  public static void main(String[] args) {
        AnonymousTask task = new AnonymousTask() {
            @Override
            public void run() {
                System.out.println("Run Task");
            }
        };
        task.run();
    }*/
  public static void main(String[] args) {
      AonymousRunnable aonymousRunnable = new AonymousRunnable() {
          @Override
          public void run() {
              System.out.println("RUNSSSSS");;
          }

          @Override
          public void srop() {
              System.out.println("Stopsss!!!!");
          }
      };
      aonymousRunnable.run();
      aonymousRunnable.srop();
      // Узнаем в каком классе был создан анонимный класс и его порядковый номер
      System.out.println(aonymousRunnable.getClass().toString());
  }

}
