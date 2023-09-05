package org.sendmail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
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


            BodyPart messagebody = new MimeBodyPart();
            System.out.println("Mail body");
            String body = scan.nextLine();
            messagebody.setText(body);
            //attachment
            MimeBodyPart msgbody = new MimeBodyPart();
            msgbody.attachFile(new File("C:/Users/gobin/OneDrive/Desktop/arrays/arrays.docx"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagebody);
            multipart.addBodyPart(msgbody);

            mailmessage.setContent(multipart);


            Transport.send(mailmessage);
            System.out.println("Mail sent succesfullyly..!!!");
        }catch (Exception ex){
            System.out.println("Error during sending mail");
            System.out.println(ex);
        }


    }
}
