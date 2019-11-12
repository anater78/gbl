package gblerningLesson6Task1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Server createServer(){

        System.out.println("Create Server");

        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {

            socket = serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    public Server getMessage() throws IOException {

       in = new DataInputStream(socket.getInputStream());
        System.out.println(in.readUTF());

        while (true) {
            String str = in.readUTF();
            if (str.equals("/end")) {
                break;
            }
            out.writeUTF("Эхо: " + str);
        }

        return this;
    }

    public static void main(String[] args) {

        System.out.println("Started Server");

        Server s = new Server();

        try {
            s.createServer().getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

