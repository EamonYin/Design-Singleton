package com.design.singleton;

/**
 * 饿汉式单例
 * 保证一个类只有一个实例，并且提供一个访问该实例的全局访问点
 * @Author XiaoMing
 * @create 2019/12/23 14:52
 */
public class SingletonDemo01 {
    //1.私有化构造器
    private SingletonDemo01(){

    }
    //2.类初始化的时候，立即加载该对象
    private static SingletonDemo01 instance = new SingletonDemo01();
    //3.提供获取该对象的方法，没有 synchronized ,效率高！
    public static SingletonDemo01 getInstance(){
        return instance;
    }

}
class SingletonDemo01Test{
    public static void main(String[] args) {

        /*
         *new SingletonDemo01();会报下面的错误
         *SingletonDemo01' has private access in ' com. design. singleton. SingletonDemo01'
         * 要使用上面的public方法getInstance()获取对象
         */

        SingletonDemo01 instance01 = SingletonDemo01.getInstance();
        SingletonDemo01 instance02 = SingletonDemo01.getInstance();

        //打印结果是true，所以 SingletonDemo01.getInstance(); 拿的是一个对象
        System.out.println(instance01 == instance02);
    }
}
