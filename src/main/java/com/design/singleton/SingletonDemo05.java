package com.design.singleton;

/**
 * 枚举单例
 *
 * @Author XiaoMing
 * @create 2019/12/23 16:36
 */
public enum SingletonDemo05 {
    INSTANCE;

    public SingletonDemo05 getInstance() {
        return INSTANCE;
    }
}

class SingletonDemo05Test {
    public static void main(String[] args) {
        SingletonDemo05 instance = SingletonDemo05.INSTANCE;
        SingletonDemo05 instance2 = SingletonDemo05.INSTANCE;
        System.out.println(instance == instance2);
    }
}