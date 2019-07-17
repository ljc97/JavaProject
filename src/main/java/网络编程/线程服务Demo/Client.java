package 网络编程.线程服务Demo;

import java.io.*;
import java.net.Socket;

/**
 * @version 1.0
 * @description: //TODO description
 * @author: 林经翀（jingchong.lin@ucarinc.com）
 * @date 2019/7/17 11:10
 */
public class Client {
    /**
     * 服务端
     */
    private static final String HOST_NAME = "127.0.0.1";

    /**
     * 服务端口
     */
    private static final int PORT = 8888;

    public static void main(String[] args) {
        System.out.println("客户端启动...");
        System.out.println("当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n");
        sendMsg();
    }

    private static void sendMsg() {
        while (true) {
            Socket socket = null;
            try {
                //创建一个流套接字并将其连接到指定主机上的指定端口号
                socket = new Socket(HOST_NAME, PORT);

                //读取服务器端数据
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                //向服务器端发送数据
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                System.out.print("请输入: \t");
                String content = new BufferedReader(new InputStreamReader(System.in)).readLine();
                dos.writeUTF(content);

                String retMsg = dis.readUTF();
                System.out.println("服务器端返回过来的是: " + retMsg);
                // 如果发送的信息为END，接收到 "OK" 则断开连接
                if ("END".equals(content.toUpperCase()) && "OK".equals(retMsg.toUpperCase())) {
                    System.out.println("客户端将关闭连接");
                    Thread.sleep(500);
                    break;
                }
                dos.close();
                dis.close();
            } catch (Exception e) {
                System.out.println("客户端异常:" + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        socket = null;
                        System.out.println("客户端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }
}
