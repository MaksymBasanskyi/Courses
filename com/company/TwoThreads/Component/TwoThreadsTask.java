package com.company.TwoThreads.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.SimpleRunnable;
import com.company.Lib.Component.TaskInterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwoThreadsTask implements TaskInterface {
    private OutputInterface output;

    public TwoThreadsTask(OutputInterface output) {
        this.output = output;
    }

    @Override
    public void run() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            executorService.execute(new SimpleRunnable(
                    "Hello, world", //message
                    2000, //interval
                    5, //count
                    output
            ));
            executorService.execute(new SimpleRunnable(
                    "Peace in the peace", //message
                    3000, //interval
                    5, //count
                    output
            ));
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            output.publishRow(e.getMessage());
        }
        output.publishRow("My name is …");
    }
}
