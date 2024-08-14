package com.example.test2.java;

public class Singleton {
    private static Singleton instance;
    public Singleton(){}

    public synchronized static Singleton getInstance(){
         if(instance == null){
             instance = new Singleton();
         }
         return instance;
    }

    public void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}

