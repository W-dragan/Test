package com.example.demo.thread;

/**
 * @Author: wanglong
 * @Date: 2021/5/17 16:42
 */
public class OrderPrint {
    private int flag = 1;

    public synchronized void printA(){

        while (flag != 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        System.out.println("1");
        flag = 2;
        this.notifyAll();
    }

    public synchronized void printB() {
        while (flag != 2) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        System.out.println("2");
        flag = 3;
        this.notifyAll();
    }

    public synchronized void printC(){
        while (flag != 3) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        System.out.println("3");
        flag = 1;
        this.notifyAll();
    }
}
