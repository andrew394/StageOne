package com.epam.learn.multithread.entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CarThread extends Thread {

    private Semaphore semaphore;
    private String model;

    public CarThread(Semaphore semaphore, String model) {
        this.semaphore = semaphore;
        this.model = model;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().toString() + " is waiting for a parking space");
            if (semaphore.tryAcquire(2, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().toString() + " is parking");
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().toString() + " is leaving a parking space");
                semaphore.release();
            } else {
                System.out.println("All parking spaces are occupied. " + Thread.currentThread().toString() + " goes away for another car park");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            semaphore.release();
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return "CarThread{model='" + model + "'}";
    }
}
