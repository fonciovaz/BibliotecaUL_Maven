/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Nobrega
 */
public class Email {
    
    private final String username = "fonciovazdomingos@gmail.com";
    private final String password = "fonciovaz";
    private final String smtp = "smtp.googlemail.com";
    private final String nome = "Foncio Domingos";
    
    public void sendSimpleEmail(String mail) throws EmailException{
        SimpleEmail email = new SimpleEmail();
        email.setHostName(smtp);
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setSSL(true);
        email.setFrom(username, nome);
        email.addTo(mail);
        email.setSubject("Teste");
        email.setMsg("1,2 1,2 experimentando");
        email.send();
    }
    
    public void sendBlockEmail(String mail, String motivo) throws EmailException{
        SimpleEmail email = new SimpleEmail();
        email.setHostName(smtp);
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setSSL(true);
        email.setFrom(username, nome);
        email.addTo(mail);
        email.setSubject("CONTA BLOQUEADA");
        email.setMsg("Caro utente! A Sua conta foi bloqueada pelo seguinte motivo: "+motivo+".");
        email.send();
    }
    
    public void sendUnblockEmail(String mail) throws EmailException{
        SimpleEmail email = new SimpleEmail();
        email.setHostName(smtp);
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setSSL(true);
        email.setFrom(username, nome);
        email.addTo(mail);
        email.setSubject("CONTA DESBLOQUEADA");
        email.setMsg("Caro utente! A Sua conta foi desbloqueada.");
        email.send();
    }
}
