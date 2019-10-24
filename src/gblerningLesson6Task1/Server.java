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

//    Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения, как на клиентской стороне, так и на серверной.
//        Т.е. если на клиентской стороне написать «Привет», нажать Enter, то сообщение должно передаться на сервер и там отпечататься в консоли.
//        Если сделать то же самое на серверной стороне, то сообщение передается клиенту и печатается у него в консоли.
//        Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд.
//        Такую ситуацию необходимо корректно обработать.