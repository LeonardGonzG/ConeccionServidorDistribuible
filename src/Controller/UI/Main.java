package Controller.UI;

import Controller.Server.SocketListener;
import Controller.Server.SocketController;
import java.io.IOException;

/**
 *
 * @author prog
 */
public class Main {

    public static void main(String[] args) {
        SocketController sc = null;
        SocketListener socketListener = null;
        int port1 = -1;
        String hostname = "";
        int port2 = -1;
        String resp = "";

        if (args.length == 3) {

            try {
                port1 = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: invalid port");
                return;
            }

            hostname = args[1];

            try {
                port2 = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: invalid port");
                return;
            }

           
            try {
                sc = new SocketController(hostname, port2);
            }
            catch (IOException ex) {
                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);           
            }
            
            if (sc != null) {
                resp = sc.readText();
                
                sc.writeText("REGISTER " + port1);
                try {
                    sc.close();
                }
                catch (IOException ex) {
                    //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Registered");
            }
            else {
                System.out.println("Error: IPs Manager Server not found");
            }
            
            socketListener = new SocketListener(port1);
            System.out.println("Basic Expert System Server");

            System.out.println("Basic Expert System Server Started");
            System.out.println("Listening in port " + port1);
            socketListener.run();
            System.out.println("Basic Expert System Server Finished");

        }

        else {
            System.out.println("Error: invalid parameters");
        }

    }

}
