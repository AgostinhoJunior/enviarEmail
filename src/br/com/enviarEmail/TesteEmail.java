/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enviarEmail;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ADJ-PC
 */
public class TesteEmail {

    private String email = "vindieseltransportes@gmail.com";
    private String senha = "Wpadmin321";

    public void testandoEnvioEmail() {
        try {
            //configurando as propriedades
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true"); //autorizacao
            properties.put("mail.smtp.starttls", "true"); //autenticacao
            properties.put("mail.smtp.host", "smtp.gmail.com"); // servidor gmail google
            properties.put("mail.smtp.port", "465"); //porta do servidor
            properties.put("mail.smtp.socketFactory.port", "465"); //expecifica a porta a ser conectada pelo socket
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //classe socket de conexao ao SMTP

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, senha);
                }

            });

            Address[] toUser = InternetAddress.parse("agostinhojunior96@gmail.com");

            Message mensagem = new MimeMessage(session);
            mensagem.setFrom(new InternetAddress(email)); //quem esta enviando
            mensagem.setRecipients(Message.RecipientType.TO, toUser); //emails de destino
            mensagem.setSubject("chegou o email enviado com java"); //assunto do email
            mensagem.setText("Ola programador voce acaba de receber um email enviado de um programa java"); //corpo do email

            Transport.send(mensagem);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
