package Controller.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener {

    private int thePort = 0;

    public SocketListener(int newPort) {
        thePort = newPort;
    }

    public void run() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        boolean isRunning = true;
        //SocketController socketCtrl = null;
        // String command = "";

        CommandProcessor cmdProc = new CommandProcessor();

        try {
            serverSocket = new ServerSocket(thePort);
        } catch (IOException ex) {

        }
        if (serverSocket != null) {

            System.out.println("Basic Expert System Server running... :)");
            do {
                try {
                    socket = serverSocket.accept();
                } catch (IOException ex) {
                    System.out.println("Falla en socket");
                }
                try {
                    final SocketController socketCtrl = new SocketController(socket);
                    socketCtrl.start(() -> {
                        String command1 = null;

                        boolean quitUser = false;
                        socketCtrl.writeText("BES Server - Leonardo Gonzalez");
                        command1 = socketCtrl.readText();

                        if (command1 == null) {
                            quitUser = true;
                        }

                        while (!quitUser) {
                            // command1 = socketCtrl.readText();
                            if (command1 != null) {   
                                if (!command1.trim().toLowerCase().equals("quit")) {
                                    socketCtrl.writeText(cmdProc.responseCommand(command1));
                                    command1 = socketCtrl.readText();
                                }else{
                                    quitUser = true;
                                }
                            } else {
                                quitUser = true;
                            }
                        }
                       
                        try {
                            socketCtrl.writeText("0500 Closed Connection :(");
                            
                            socketCtrl.close();
                            System.out.println("0500 Closed Connection :(");
 
                        } catch (IOException ex) {
                            
                            socketCtrl.writeText("Error: Closed Connection :(");
                            System.out.println("Error: Closed Connection");
                        }
                    });
                } catch (IOException ex) {
                  
                }

            } while (isRunning);

        }
    }

}
