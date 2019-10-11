package com.linjc.网络编程.线程服务Demo;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @version 1.0
 * @description: //TODO description
 * @author: 林经翀（jingchong.lin@ucarinc.com）
 * @date 2019/7/17 11:00
 */
public class Serve {
    /**
     * 服务端
     */
    private static final String HOST_NAME = "127.0.0.1";

    /**
     * 服务端口
     */
    private static final int PORT = 8888;

    public static void main(String[] args) {
        Serve serve = new Serve();
        serve.init();
    }

    private void init() {
        try {
            SocketAddress socketAddress = new InetSocketAddress(HOST_NAME, PORT);
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(socketAddress);
            System.out.println("服务端初始化完成！");
            while (true) {
                Socket socket = serverSocket.accept();
                new HandlerThread(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandlerThread implements Runnable {
    private Socket socket;

    public HandlerThread(Socket socket) {
        this.socket = socket;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            // 读取客户端数据
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            //这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
            String content = dis.readUTF();
            // 处理客户端数据
            System.out.println("客户端发过来的内容:" + content);

//          TODO  处理客户端发送的内容的方法
//            doSomeThing()
            // 向客户端回复信息
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.print("请输入:\t");
            // 发送键盘输入的一行
            String retMsg = new BufferedReader(new InputStreamReader(System.in)).readLine();
//            返回数据
            dos.writeUTF(retMsg);
            // 如果接收到 "END" 则断开连接,发送的信息为OK,则终止服务
            if ("END".equals(content.toUpperCase()) && "OK".equals(retMsg.toUpperCase())) {
                System.out.println("客户端将关闭连接");
                Thread.sleep(500);
            }
            dos.close();
            dis.close();
        } catch (Exception e) {
            System.out.println("服务器 run 异常: " + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    socket = null;
                    System.out.println("服务端 finally 异常:" + e.getMessage());
                }
            }
        }
    }
}
