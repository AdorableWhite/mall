package com.taizilibai.mall;

import com.taizilibai.mall.manager.SocketTransceiver;
import com.taizilibai.mall.manager.TcpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MallApplication {

    static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        SpringApplication.run(MallApplication.class, args);

        TcpClient c1 = new TcpClient() {

            @Override
            public void onReceive(SocketTransceiver st, String s) {
                System.out.println("Client1 Receive: " + s);
            }

            @Override
            public void onDisconnect(SocketTransceiver st) {
                System.out.println("Client1 Disconnect");
            }

            @Override
            public void onConnect(SocketTransceiver transceiver) {
                System.out.println("Client1 Connect");
            }

            @Override
            public void onConnectFailed() {
                System.out.println("Client1 Connect Failed");
            }
        };
        TcpClient c2 = new TcpClient() {

            @Override
            public void onReceive(SocketTransceiver st, String s) {
                System.out.println("Client2 Receive: " + s);
            }

            @Override
            public void onDisconnect(SocketTransceiver st) {
                System.out.println("Client2 Disconnect");
            }

            @Override
            public void onConnect(SocketTransceiver transceiver) {
                System.out.println("Client2 Connect");
            }

            @Override
            public void onConnectFailed() {
                System.out.println("Client2 Connect Failed");
            }
        };
        c1.connect("127.0.0.1", 1234);
        c2.connect("127.0.0.1", 1234);
        delay();
        while (true) {
            if (c1.isConnected()) {
                c1.getTransceiver().send("Hello1");
            } else {
                break;
            }
            delay();
            if (c2.isConnected()) {
                c2.getTransceiver().send("Hello2");
            } else {
                break;
            }
            delay();
        }


    }

}
