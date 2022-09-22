import java.io.BufferedOutputStream;

public class Main {
    public static void main(String[] args) {
        final int port = 8800;
        final int threads = 64;

        Server server = new Server(threads);

        // добавление handler'ов (обработчиков)
//        server.addHandler("GET", "/messages", new Handler() {
//
//            @Override
//            public void handle(Request request, BufferedOutputStream responseStream) {
//
//            }
//        });
//
//        server.addHandler("POST", "/messages", new Handler() {
//
//            @Override
//            public void handle(Request request, BufferedOutputStream responseStream) {
//
//            }
//        });

        server.start(port);
    }
}
