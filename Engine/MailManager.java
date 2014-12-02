package Engine;

import java.net.*;
import java.io.*;

/*
 * Super simple email class that sends an email using SMTP. Currently I'm using the GSU mail server, not sure if that is okay... haha
 */
public class MailManager {

    public void sendMail(String guestEmail, String message) {
        try {
            Socket GSUmail = new Socket("mail.gsu.edu", 25);
            outStream = new PrintWriter(GSUmail.getOutputStream());
            inStream = new BufferedReader(new InputStreamReader(GSUmail.getInputStream()));
            String host = InetAddress.getLocalHost().getHostName();
            send("HELO " + host);
            send("MAIL FROM: " + "hotelmanagementsystem@codekillers.com");
            send("RCPT TO: " + guestEmail);
            send("DATA\n"+message+"\n.");
            send("QUIT");
            GSUmail.close();
            outStream.close();
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}

    public void send(String s) throws IOException {
        if (s != null) {
            outStream.println(s);
            outStream.flush();
        }
        String line;
        if ((line = inStream.readLine()) != null)
        {
            System.out.println(line);
        }
    }

    private PrintWriter outStream;
    private BufferedReader inStream;
}
