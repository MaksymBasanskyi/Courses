package com.company.ThreeThreads.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.SimpleRunnable;
import com.company.Lib.Component.TaskInterface;

public class ThreeThreadsTask implements TaskInterface {
    private OutputInterface output;

    public ThreeThreadsTask(OutputInterface output) {
        this.output = output;
    }

    @Override
    public void run() {
        Thread thread1 = new Thread(new SimpleRunnable("firstThread", 0, 5, output));
        Thread thread2 = new Thread(new SimpleRunnable("secondThread", 0, 5, output));
        Thread thread3 = new Thread(new SimpleRunnable("thirdThread", 0, 5, output));
        try {
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            thread3.start();
        } catch (InterruptedException e) {
            output.publishRow(e.getMessage());
        }
    }
}
