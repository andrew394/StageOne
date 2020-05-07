package com.epam.learn.multithread;

import com.epam.learn.multithread.entity.CarThread;

import java.util.concurrent.Semaphore;

public class CarParkRunner {
//2. Car park
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            new CarThread(semaphore, "Car-" + i).start();
        }
    }
}
