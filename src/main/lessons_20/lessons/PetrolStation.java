package main.lessons_20.lessons;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
public class PetrolStation {

    public static void main(String[] args) {

        List<LinkedBlockingQueue<Integer>> queues = IntStream.range(0, 3)
                .mapToObj(i -> new LinkedBlockingQueue<Integer>())
                .toList();// cоздаем потоковую очередь

        queues.forEach(queue -> IntStream.range(0, 5).forEach(n -> queue.add(randomToplyak())));// количество машинок

        List<Thread> gas_stations = IntStream.range(0, 3)// количество заправок и заполнение их от 500 до 5000
                .mapToObj(i -> new Thread(new gasStationWorker(randomValue(), queues.get(i)), "АЗС-" + (i + 1)))
                .toList();


        gas_stations.forEach(Thread::start);
    }


    private static int randomValue() {
        int min = 500;
        int max = 5000;
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    private static int randomToplyak() {
        return ThreadLocalRandom.current().nextInt(30, 101);
    }



}


