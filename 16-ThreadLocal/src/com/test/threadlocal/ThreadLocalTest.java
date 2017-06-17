package com.test.threadlocal;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsongyan on 2017/6/17.
 * email: wangsongyan921@163.com
 */
public class ThreadLocalTest {

    @Test
    public void func1() {

        ThreadLocal<String> tl = new ThreadLocal<>();
        //tl.set("hello");
        //String s = tl.get();
        //System.out.println(s);

        new Thread(new Runnable() {
            @Override
            public void run() {
                tl.set("内部类");
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(tl.get());

        tl.remove();
    }
}

/**
 * Mock ThreadLocal
 *
 * @param <T>
 */
class TL<T> {

    private Map<Thread, T> map = new HashMap<>();

    public void set(T t) {
        map.put(Thread.currentThread(), t);
    }

    public T get() {
        return map.get(Thread.currentThread());
    }

    public void remove() {
        map.remove(Thread.currentThread());
    }
}
