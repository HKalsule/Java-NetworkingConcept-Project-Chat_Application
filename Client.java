import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    BufferedReader br;
    PrintWriter out;
    Socket socket;

    public Client(){
        try {
            BufferedReader portReader = new BufferedReader(new FileReader("port.txt"));
            int port = Integer.parseInt(portReader.readLine().trim());
            portReader.close();
            
            System.out.println("Sending request to the Server");
            socket = new Socket("127.0.0.1",port);
            System.out.println("Connection done");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
            
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void startWriting()
{
    Runnable r1=()->
    {
        System.out.println("Writer Started...");
        while(true)
        {
        try{
            String msg = br.readLine();
            if(msg.equals("Exit"))
            {
                System.out.println("Server Terminated The Chat!!");
                break;
            }
                System.out.println("Server : "+msg);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    };
    new Thread(r1).start();
}
public void startReading()
{
    Runnable r2=()->
    {
        System.out.println("Writer Started...");
        while(true)
        {
            try
            {
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            String content = br1.readLine();
            out.println(content);
            out.flush();
            }
            catch(Exception e)
            {
            e.printStackTrace();
            }
        }
    };
    new Thread(r2).start();
}
    public static void main(String[] args) {
        System.out.println("This is Client...");
        new Client();
    }
}
 