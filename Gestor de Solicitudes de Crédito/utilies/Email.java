package utilies;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Funcion de envio de correos mediante java
 * 
 * @author KEVIN SALAZAR
 * @version 6.0
 */
public class Email {
  private static final String CORREO = "javamailcorreos@gmail.com";
  private static final String PSSW = "abc123correos";

  /**
   * Constructor principal de la clase Email
   */
  public Email() {

  }

  // metodos accesores
  public static String getCORREO() {
    return CORREO;
  }

  public static String getPSSW() {
    return PSSW;
  }

  /**
   * Crea y envia un correo a una direccion de envío
   * 
   * @param toAddress Direccion de correo del destinatario
   * @param subject   Encabezado del correo
   * @param message   Cuerpo o mensaje del correo
   */
  public static void enviarEmail(String toAddress, String subject, String message)
      throws AddressException, MessagingException {
    try {
      // seteo de propiedades de red y puerto SMTP
      Properties properties = new Properties();
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.user", getCORREO());
      Session session = Session.getDefaultInstance(properties);

      // creacion del correo
      Message msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(getCORREO()));
      InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
      msg.setRecipients(Message.RecipientType.TO, toAddresses);
      msg.setSubject(subject);
      msg.setSentDate(new Date()); // fecha de envio
      msg.setText(message);

      // Envio de email
      Transport t = session.getTransport("smtp");
      t.connect(getCORREO(), getPSSW()); // inicio de sesion
      t.sendMessage(msg, msg.getAllRecipients());
      t.close();
    } catch (MessagingException ex) {
      Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void main(String[] args) throws MessagingException {
    enviarEmail("andyporras6@gmail.com", "correo de prueba", "hola mundo");
  }
}
