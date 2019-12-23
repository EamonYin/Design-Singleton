package com.design.singleton;

/**
 * 懒汉单例
 * @Author XiaoMing
 * @create 2019/12/23 15:11
 */
public class SingletonDemo02 {
    //1.私有化构造器
    private SingletonDemo02(){

    }
    //2.类初始化的时候，立即加载该对象
    private static SingletonDemo02 instance;
    //3.提供获取该对象的方法，有 synchronized ,效率较低！
    public static synchronized  SingletonDemo02 getInstance(){
        if(instance == null){
            instance = new SingletonDemo02();
        }
        return instance;
    }

}
class SingletonDemo02Test {
    public static void main(String[] args) {

        SingletonDemo02 instance01 = SingletonDemo02.getInstance();
        SingletonDemo02 instance02 = SingletonDemo02.getInstance();

        System.out.println(instance01 == instance02);
    }
}
