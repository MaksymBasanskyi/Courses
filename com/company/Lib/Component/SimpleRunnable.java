package com.company.Lib.Component;

import com.company.DataManagement.Component.OutputInterface;

public class SimpleRunnable implements Runnable {
    private String message;
    private int interval;
    private int count;
    private OutputInterface output;

    public SimpleRunnable(String message, int interval, int count, OutputInterface output) {
        this.message = message;
        this.interval = interval;
        this.count = count;
        this.output = output;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            output.publishRow(message);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
