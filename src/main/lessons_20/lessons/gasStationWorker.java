package main.lessons_20.lessons;


import java.util.concurrent.LinkedBlockingQueue;


import static java.lang.Thread.sleep;

class gasStationWorker implements  Runnable{
    private int amount;
    private final LinkedBlockingQueue<Integer> queue;

    public gasStationWorker(int amountе, LinkedBlockingQueue<Integer> queue) {
        this.amount = amountе;
        this.queue = queue;
    }

    public static int getRefuelTime(int fuelAmount) {
            return (fuelAmount / 10);
        }

    public void run() {
        while (!queue.isEmpty()) {
            int fuelNeeded = 0;
            try {
                fuelNeeded = queue.take();
                int fuel_time = getRefuelTime(fuelNeeded);
                sleep(fuel_time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this) {
                if (amount >= fuelNeeded) {
                    amount -= fuelNeeded;
                    System.out.println(Thread.currentThread().getName() + " была заправлена на  " + fuelNeeded + " за " + getRefuelTime(fuelNeeded) + " секунды Остаток " + amount);

                } else if (amount < fuelNeeded){ System.out.println("Не хватка топляка для станции " + Thread.currentThread().getName());
                break;}

            }
        }
    }
}

