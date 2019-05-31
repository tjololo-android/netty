package com.example.testserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) throws Exception {
        final ServerSocket serverSocket = new ServerSocket(8000);
        new Thread(){
        	public void run(){
	            while (true){
	                try {
	                    final Socket socket = serverSocket.accept();	
	                    new Thread(){
	                    	public void run(){
	                        try {
	                            byte[] data = new byte[1024];
	                            InputStream inputStream = socket.getInputStream();
	                            while (true) {
	                                int len;
	                                while ((len = inputStream.read(data)) != -1) {
	                                    System.out.println(new String(data, 0, len));
	                                }
	                            }
	                        } catch (IOException e) {
	                        }
	                    	}
	                    }.start();	
	                } catch (IOException e) {
	                }
	            }       	
        	}  
        }.start();
    }
}