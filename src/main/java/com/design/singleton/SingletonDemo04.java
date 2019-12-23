package com.design.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 静态内部类实现
 * @Author XiaoMing
 * @create 2019/12/23 15:57
 */
public class SingletonDemo04 {
    private SingletonDemo04() {

    }
    //匿名内部类中private static final保证了线程安全，
    // 不调用外部类的时候，SingletonDemo04对象不会被创建
    public static class InnerClass{
        private static final SingletonDemo04 instance = new SingletonDemo04();
    }

    public static SingletonDemo04 getInstance(){
        return InnerClass.instance;
    }
}

class SingletonDemo04Test {
    public static void main(String[] args) throws Exception {

        SingletonDemo04 instance01 = SingletonDemo04.getInstance();
        SingletonDemo04 instance02 = SingletonDemo04.getInstance();

        System.out.println(instance01 == instance02);

        //反射机制中可以无视private
        System.out.println("------------------反射机制中可以无视private---------------------");

        SingletonDemo04 instance03 = SingletonDemo04.getInstance();
        Constructor<SingletonDemo04> declaredConstructor = SingletonDemo04.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        //newInstance()创建实例
        SingletonDemo04 instance04 = declaredConstructor.newInstance();

        System.out.println(instance03 == instance04);
        System.out.println("instance03HashCode:"+instance03.hashCode());
        System.out.println("instance04HashCode:"+instance04.hashCode());

    }
}
