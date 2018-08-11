package com.example.nio;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {

    /**
     * 从nio中读取数据
     */
    @Test
    public void demo01(){
        try {
            FileInputStream fileInputStream = new FileInputStream("c:\\test.txt");
            //获取通道
            FileChannel channel = fileInputStream.getChannel();
            //创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //读取数据到缓冲区
            channel.read(buffer);
            /*
                由于position被设置为0，
                所以可以保证在下一步输出时读取到的是缓冲区中的第一个字节，
                而limit被设置为当前的position，
                可以保证读取的数据正好是之前写入到缓冲区中的数据
             */
            buffer.flip();
            /*
                remaining()方法返回limit与position这段区间的长度
             */
            while (buffer.remaining()>0) {
                byte b = buffer.get();
                System.out.print(((char)b));
            }
            //关闭流
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用NIO向文件中写入数据的例子
     */
    private static final byte message[] = { 83, 111, 109, 101, 32,
            98, 121, 116, 101, 115, 46 };
    @Test
    public void demo02(){
        try {
            FileOutputStream fout = new FileOutputStream("c:\\test.txt");
            FileChannel channel = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //向缓冲区中写入数据
            for (int i=0; i<message.length; ++i) {
                buffer.put( message[i] );
            }
            buffer.flip();
            channel.write(buffer);
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
