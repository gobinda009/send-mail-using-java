package org.sendmail;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class Mailhandlerbase {
    Scanner scan = new Scanner(System.in);
    public void sendMail(){
        //addind properties
        Properties sysproperties = System.getProperties();
        sysproperties.put("mail.smtp.host","smtp.gmail.com"); //smtp server
        sysproperties.put("mail.smtp.port","465"); //server post
        sysproperties.put("mail.smtp.ssl.enable","true"); //ssl-secure
        sysproperties.put("mail.smtp.auth","true"); //authentication

        //authentication

        Authenticator custauth = new Custoauthen();
        //session
        Session mailsession = Session.getInstance(sysproperties,custauth);

        MimeMessage mailmessage = new MimeMessage(mailsession);
        try {
            mailmessage.setFrom(mailconstant.SENDER);
            System.out.println("Send TO");
            String email = scan.nextLine();
            mailmessage.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
            System.out.println("Subject");
            String subject = scan.nextLine();
            mailmessage.setSubject(subject);
            System.out.println("Mail body");
            String body = scan.nextLine();
            mailmessage.setText(body);
            Transport.send(mailmessage);
            System.out.println("Mail sent succesfullyly..!!!");
        }catch (Exception ex){
            System.out.println("Error during sending mail");
        }


    }
}
