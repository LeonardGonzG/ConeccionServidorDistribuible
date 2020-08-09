/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;



public class SocketController {
    private Thread theThread = null;
    private Socket theSocket = null;
    private PrintWriter theOut = null;
    private BufferedReader theIn = null;

    
    private void initStream(Socket newSocket) 
            throws IOException {
        
        OutputStream outStream = null;
        InputStream inStream = null;

        outStream = theSocket.getOutputStream();
        inStream = theSocket.getInputStream();

        theOut = new PrintWriter(outStream, true);
        theIn = new BufferedReader(new InputStreamReader(inStream, 
                StandardCharsets.UTF_8));
    }

    
    public SocketController(String newHostname, int newPort) 
            throws IOException {
             
        theSocket = new Socket(newHostname, newPort);
        initStream(theSocket);
    }

    
    public SocketController(Socket newSocket) 
            throws IOException{
        
        theSocket = newSocket;
        initStream(newSocket);
    }
    
    
    public void start(Runnable r){
        
        theThread = new Thread(r);
        theThread.start();
    }
    
    
    public void close() 
            throws IOException{
        
        theSocket.close();
    }

    
    public Socket getSocket() {
        return theSocket;
    }

    
    public Thread getThread() {
        return theThread;
    }
    
    
    public String readText(){
        try {
            return theIn.readLine();
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    
    public void writeText(String newText){
        theOut.println(newText);
    }
    
    
    public String writeReadText(String newText){
        writeText(newText);
        
        return readText();
    }
    
}
