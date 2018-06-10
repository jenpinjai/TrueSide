/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.service;

import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;

/**
 *
 * @author Jennarong Pinjai
 */
public class MailService {
   
 
	
    public static boolean sentToSMTP( String fromMail, String toMail, String ccMail, String mailTopic, String mailDetail, ArrayList<String> pathFile) throws Exception {
        boolean isSuccess = false;
    
        final String smtpServer = "prmdbnpr1.truecorp.co.th";
        
        Properties props = new Properties();
        //props.put("mail.smtp.host", smtpServer);"172.19.194.176"
//        props.put("mail.smtp.socketFactory.port", "25");
//        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.host",smtpServer ); // for gmail use smtp.gmail.com
   //     props.put("mail.smtp.auth", "true");
       // props.put("mail.smtp.port", "587"); 
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
      
        

        try {
            Session session = Session.getInstance(props, null);
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMail));
            
            InternetAddress[] toList = InternetAddress.parse(toMail);
            message.setRecipients(Message.RecipientType.TO, toList);
            
            if(ccMail != null && !"".equals(ccMail)){
                InternetAddress[] ccList = InternetAddress.parse(ccMail);
                message.setRecipients(Message.RecipientType.CC, ccList);
            }
            
            MimeBodyPart objBodyPart = new MimeBodyPart();
            objBodyPart.addHeaderLine("Content-Type:multipart/alternative;");
            objBodyPart.addHeaderLine("Content-Transfer-Encoding:base64");
            objBodyPart.setContent(mailDetail, "text/html;charset=UTF-8");
            Multipart objMultipart = new MimeMultipart();
            objMultipart.addBodyPart(objBodyPart);
            message.setSubject(mailTopic, "UTF-8");
            if(pathFile!=null && pathFile.size()>0){
                for (int i = 0; i < pathFile.size(); i++) {
                    objBodyPart = new MimeBodyPart();
                    FileDataSource file = new FileDataSource(pathFile.get(i));
                    DataSource source = file;
                    objBodyPart.setDataHandler(new DataHandler(source));
                    objBodyPart.setFileName(file.getName());
                    objMultipart.addBodyPart(objBodyPart);
                }
            }
            message.setContent(objMultipart);
            
         
            Transport.send(message);

           
            isSuccess = true;
        } catch (MessagingException e) {
           e.printStackTrace();
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
           
        }
        return isSuccess;
    }
}
