package t8_Client_Server;

import t7_streaming_fileSearch_dataStructures.CacheFileSearcher;
import t7_streaming_fileSearch_dataStructures.FileSearcher;

import java.io.*;

public class HTTPClientHandler implements ClientHandler{

    BufferedReader in;
    PrintWriter out;
    FileSearcher fs;

    public HTTPClientHandler() {
//        fs = new CacheFileSearcher();
//        fs.loadFile("resources/mobydick.text");
    }

    @Override
    public void handle(InputStream inFromClient, OutputStream outToClient) {
        try {
            in = new BufferedReader(new InputStreamReader(inFromClient));
            out = new PrintWriter(outToClient, true);

            // Connection Protocol when connecting to a browser
            out.println("HTTP/1.1 200"); // Version & status code
            out.println("Content-Type: text/plain"); // the type of data
//            out.println("Content-Type: text/html"); // the type of data

            out.println("Connection: close"); // will close stream
            out.println(""); // End of headers

            String line;
            while ((line = in.readLine()).length() > 0) { // print what the client (=the browser) writes
                System.out.println(line);
            }

            out.println("hello from server"); // respond to the client
        } catch(Exception e) {}
    }

    @Override
    public void close() {
        try{
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
