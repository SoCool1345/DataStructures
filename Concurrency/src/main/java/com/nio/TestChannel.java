package com.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannel {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf1=new RandomAccessFile("1.txt","rw");
        FileChannel channel1=raf1.getChannel();
        ByteBuffer buf1=ByteBuffer.allocate(100);
        ByteBuffer buf2=ByteBuffer.allocate(1024);
        ByteBuffer[] bufs={buf1,buf2};
        channel1.read(bufs);
        for (ByteBuffer buf : bufs) {
            buf.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

    }
}
