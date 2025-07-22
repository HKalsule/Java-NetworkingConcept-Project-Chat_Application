import java.net.*;       // for ServerSocket and Socket
import java.io.*;        // for IOException (optional but good)class Server

class Server
{   
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

public Server()
{
    try {
        server = new ServerSocket(0);  // 🔥 Let OS assign a free port
        System.out.println("Server is ready to accept connections...");
        System.out.println("Listening on port: " + server.getLocalPort());
        socket = server.accept();
        System.out.println("Connection established with client");


        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());

        startReading();
        startWriting();
        } 
        catch (Exception e) 
        {
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
                System.out.println("Client Terminated The Chat!!");
                break;
            }
                System.out.println("Client : "+msg);
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
        System.out.println("This is Server...Strating...");
        new Server();
    }
}