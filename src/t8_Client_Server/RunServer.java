package t8_Client_Server;

import java.io.*;
import java.util.Scanner;

public class RunServer {

    public static class TestClientHandler implements ClientHandler{
        BufferedReader in;
        PrintWriter out;

        @Override
        public void handle(InputStream inFromClient, OutputStream outToClient) {
            try{
                // the BufferdReader expects Reader, so we wrap the inFromClient with an InputStreamReader (Object Adapter design pattern)
                // the BufferedReader is a Decorator: it's a Reader,
                // and it implements Reader with a Reader he received in his constructor
                // the InputStreamReader is an Object Adapter: with an inputStream, it implements Reader
                in = new BufferedReader(new InputStreamReader(inFromClient));
                // Print writer can wrap Reader, and Stream
                out = new PrintWriter(outToClient, true); // auto flush = true

                String line;
                while(!(line = in.readLine()).equals("bye")) {
                    out.println("the length of \"" + line + "\" is " + line.length()); // print to client the length of the line
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void close() {
            try{
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //run: RunServer first, and then RunClient. the sever continues to be open until we write "stop" at the console

    public static void main(String[] args) {
        System.out.println("SERVER SIDE");
        MyServer server = new MyServer(8080, new TestClientHandler());
//        MyServer server = new MyServer(8080, new HTTPClientHandler());

        server.start();
        System.out.println("server started");
        Scanner s = new Scanner(System.in);
        String input;
        do {
            input = s.next();
        } while(!input.equals("stop"));
        s.close();
        server.stop();
        System.out.println("server stopped");

    }
}
