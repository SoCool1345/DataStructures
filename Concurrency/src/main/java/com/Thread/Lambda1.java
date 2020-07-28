package com.Thread;

public class Lambda1 {
    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }
    public static void main(String[] args) {
        ILike like=new Like();
        like.lambda();
        like=new Like2();
        like.lambda();
        //局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        like=new Like3();
        like.lambda();
        //匿名内部类,没有类的名称，只有借助接口或者父类
        like=new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();
        //用lambda简化
        like=() ->{
            System.out.println("i like lambda5");
        };
        like.lambda();
        //有参数lambda
        Love love=(a)->{
            System.out.println(a);
        };
        love.love(1);
        //简化括号，只有一个参数可简化
        love=a -> {
            System.out.println(a);
        };
        love.love(2);
        //简化花括号,只能有一行
        love=a -> System.out.println(a);
        love.love(3);

    }
}
//必须是函数式接口，只能有一个方法
interface ILike{
    void lambda();
}
interface Love{
    void love(int a);
}
//实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
