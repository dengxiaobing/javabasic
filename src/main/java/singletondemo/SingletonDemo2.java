package singletondemo;

/**
 * 单例模式：懒汉模式
 *
 * @author:deng
 * @date: 2019/5/26
 * @time: 4:08 PM
 * @email 657563945@qq.com
 */

public class SingletonDemo2 {
    public static void main(String[] args) {
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order1 == order2);

    }
}


class Order {
    /**
     * volatile声明作用即是内存变量共享的作用
     */
    private static volatile Order instance = null;

    /**
     * 构造私有化
     */
    private Order() {
    }

    /**
     * 提供公有的获取方法
     *
     * @return order
     */
    public static Order getInstance() {
        if (instance == null) {
            //解决线程安全问题
            synchronized (Order.class) {
                if (instance == null) {
                    instance = new Order();
                }
            }
        }
        return instance;
    }

}