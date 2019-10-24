package gblerningLesson6Task1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        System.out.println("Started Client");
    }
}


//    Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения, как на клиентской стороне, так и на серверной.
//        Т.е. если на клиентской стороне написать «Привет», нажать Enter, то сообщение должно передаться на сервер и там отпечататься в консоли.
//        Если сделать то же самое на серверной стороне, то сообщение передается клиенту и печатается у него в консоли.
//        Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд.
//        Такую ситуацию необходимо корректно обработать.