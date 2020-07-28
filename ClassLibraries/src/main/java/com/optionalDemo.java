package com;

import java.util.Optional;
@FunctionalInterface
interface IMessage{
    public void send(String msg);
}
class Factory{
    private Factory(){};
    public static Optional<IMessage> getInstance(){
        return Optional.of((msg)->{
            System.out.println("消息发送"+msg);
        });
    }
}
public class optionalDemo {
    public static void main(String[] args) {
        IMessage message=Factory.getInstance().get();
        message.send("aaa");
    }
}
