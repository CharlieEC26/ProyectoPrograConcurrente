/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoprogra;

import com.sun.jdi.connect.Transport;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author carlo
 */
public class clEmailConfirmation {

    private final Properties properties = new Properties();

    private String password;

    private Session session;

    private void init() {

        properties.put("mail.smtp.host", "mail.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 25);
        properties.put("mail.smtp.mail.sender", "emisor@gmail.com");
        properties.put("mail.smtp.user", "usuario");
        properties.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);
    }

    public void sendEmail(String email) {

        init();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Prueba");
            message.setText("Texto");
            Transport t = session.getTransport("smtp");
            t.connect((String) properties.get("mail.smtp.user"), "password");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (Exception me) {
            return;
        }

    }
}
