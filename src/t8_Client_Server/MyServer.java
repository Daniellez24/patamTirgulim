package t8_Client_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer {

    int port;
    boolean stop;
    ClientHandler ch;

    public MyServer(int port, ClientHandler ch) {
        this.port = port;
        this.ch = ch;
    }

    public void start(){
        stop = false;
        new Thread(()->startServer()).start(); // so we'll be able to call stop() from the main thread

    }

    private void startServer() {
        try {
            ServerSocket server = new ServerSocket(port);
            server.setSoTimeout(1000);
            while (!stop) {
                try {
                    Socket client = server.accept(); // waiting for a client. if within 1 second no client was connected - throw exception
                    ch.handle(client.getInputStream(), client.getOutputStream()); // get the input+output stream of the client, and give it to the CH. the ch handles the client
                    ch.close(); // when handling client is finished - close client handler
                    client.close(); // close the client socket
                } catch (SocketTimeoutException e) {} // catch the unchecked exception: so we can return to the while loop until !stop.
                // so we can close the server
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        stop = true;
    }
}
