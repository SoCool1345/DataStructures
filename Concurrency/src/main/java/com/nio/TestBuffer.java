package com.nio;

import jdk.jfr.StackTrace;

import java.nio.ByteBuffer;

/**
 * 除boolean外，其他基本数据类型，都提供了相应缓冲区
 * 用allocate()获取缓冲区
 * 用put()和get()存取缓冲区
 */
public class TestBuffer {
    public static void main(String[] args) {
        String str="abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());

        buffer.put(str.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.flip();//切换到读模式，position置为0，limit变为5
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        byte[] dst=new byte[buffer.limit()];
        buffer.get(dst,2,3);
        System.out.println(new String(dst));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.get(dst,2,2);

        System.out.println(new String(dst));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.rewind();//可重复读
        buffer.clear();//清空缓冲区，回到最初状态，但是缓冲区中的数据依然存在，但处于“被遗忘”状态

    }

}
