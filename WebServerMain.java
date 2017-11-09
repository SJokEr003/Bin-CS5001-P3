import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CS5001-P3: A Java web server which can response to some HTTP/1.1 request.
 * 
 * @author bl41
 *
 */
public class WebServerMain {
    /**
     * Main method for running the server.
     * 
     * @param args
     *            Command line arguments
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Print usage message if inadequate arguments
        if (args.length < 2) {
            System.out.println("Usage: java WebServerMain <document_root> <port>");
            System.exit(0);
        }
        // Get port number and path
        int port = Integer.valueOf(args[1]);
        String path = args[0];
        // Run the server
        try {
            // Support multiple concurrent client connection request
            ServerSocket ss = new ServerSocket(port);
//            for (int i = 0; i < Configurations.CLIENT_LIMIT; i++) {
//                Socket socket = ss.accept();
//                  Date requestTime = new Date();
//                  long getTime = System.currentTimeMillis();
//                  SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//                  String time = format.format(requestTime) + " ";
//                  // Log request accept time into log file
//                  LoggingFile.witeLog(time);
//                  SingleRequestHandler.requestHandler(path, socket);
//                  // Log request response time into log file
//                  long handleTime = System.currentTimeMillis() - getTime;
//                  LoggingFile.witeLog(" " + String.valueOf(handleTime) + "ms\r\n");
//            }
            /////////////////////////////////////////////////////////////////////////////////////////////
            // Uncomment the loop above and comment loop below to make program support multiple client //
            /////////////////////////////////////////////////////////////////////////////////////////////
            while (true) {
                Socket socket = ss.accept();
                Date requestTime = new Date();
                long getTime = System.currentTimeMillis();
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String time = format.format(requestTime) + " ";
                // Log request accept time into log file
                LoggingFile.witeLog(time);
                SingleRequestHandler.requestHandler(path, socket);
                // Log request response time into log file
                long handleTime = System.currentTimeMillis() - getTime;
                LoggingFile.witeLog(" " + String.valueOf(handleTime) + "ms\r\n");
            }
            // socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
