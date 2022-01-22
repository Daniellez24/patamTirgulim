package t8_Client_Server;

import java.io.InputStream;
import java.io.OutputStream;

public interface ClientHandler {
    void handle(InputStream inFromClient, OutputStream outToClient); // handling the client
    void close(); // closes the Streams
}
