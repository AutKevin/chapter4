package com.autumn.threadlocal;

/**
 * @program: SequenceB
 * @description: 用ThreadLocal实现线程共享
 * @author: Created by Autumn
 * @create: 2018-11-21 15:45
 */
public class SequenceC implements Sequence {
    //private static int number = 0;
    private static MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get()+1);
        return numberContainer.get();
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceC();
        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
