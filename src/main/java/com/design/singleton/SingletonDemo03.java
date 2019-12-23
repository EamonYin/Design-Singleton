package com.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * DCL（双重检查加锁）懒汉式
 *
 * @Author XiaoMing
 * @create 2019/12/23 15:34
 */
public class SingletonDemo03 {

    //1.私有化构造器
    private SingletonDemo03() {

        synchronized (SingletonDemo03.class){
            if(instance!=null){
                throw new RuntimeException("不要用反射试图破坏单例");
            }
        }

    }

    //2.类初始化的时候，立即加载该对象
    /**
     * 添加volatile（避免指令重排）是为了
     * 有线程在对这个变量进行修改的时候，另一个变量中的缓存就失效了，直接读取内存中的值
     * 在第一个线程进入并创建（或者改变）对象，
     * 第二个线程中变量的值是立即生效的
     */
    private volatile static SingletonDemo03 instance;

    //3.提供获取该对象的方法，有 synchronized ,效率较低！
    public static SingletonDemo03 getInstance() {
        //a.线程刚进来发现对象没有被创建（只有第一次会进if方法，后面直接return）
        if (instance == null) {
            //b.和其他本类线程竞争本类的锁
            synchronized (SingletonDemo03.class) {
                //c.获得锁之后，再次检查，发现自己为空，则自己是第一个进来的，则这个线程负责创建对象
                if (instance == null)
                    instance = new SingletonDemo03();
            }
        }
        return instance;
    }
    // 1.分配内存
    // 2.执行构造方法
    // 3.指向地址
}
class SingletonDemo03Test {
    public static void main(String[] args) throws Exception {

        SingletonDemo03 instance01 = SingletonDemo03.getInstance();
        SingletonDemo03 instance02 = SingletonDemo03.getInstance();

        System.out.println(instance01 == instance02);

        System.out.println("-----------------利用反射破坏单例（再创建第二个实例的时候抛出上面构造器RuntimeException异常）---------------------");

        SingletonDemo03 instance03 = SingletonDemo03.getInstance();
        Constructor<SingletonDemo03> declaredConstructor = SingletonDemo03.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        //newInstance()创建实例
        SingletonDemo03 instance04 = declaredConstructor.newInstance();

        System.out.println(instance03 == instance04);
        System.out.println("instance03HashCode:"+instance03.hashCode());
        System.out.println("instance04HashCode:"+instance04.hashCode());
    }
}