/*
package com.APISurvey.Application.generique.denquete.util;

import com.APISurvey.Application.generique.denquete.Modeles.Presentation;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class rmarkdown {

    private File createRMarkdownFile(Presentation presentation) {
        // code to create rmarkdown file from presentation data
        try {
            // create a new file with a .Rmd extension
            File rMarkdownFile = new File(presentation.getTitle() + ".Rmd");
            // create a new FileWriter
            FileWriter fileWriter = new FileWriter(rMarkdownFile);
            // write the presentation data to the rmarkdown file
            fileWriter.write(presentation.getContent().getId());
            // close the fileWriter
            fileWriter.close();
            return rMarkdownFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
 */
/*
    private void sendEmail(String email, File rMarkdownFile) {
        // code to send the email with the rmarkdown file as attachment
        try {
            // create a new instance of the JavaMailSender
            JavaMailSender mailSender = new JavaMailSenderImpl();
            // create a new MimeMessage
            MimeMessage message = mailSender.createMimeMessage();
            // create a new MimeMessageHelper
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            // set the recipient email address
            helper.setTo(email);
            // set the subject of the email
            helper.setSubject("Presentation Sharing");
            // set the text of the email
            helper.setText("Please find the attached presentationin the R markdown format.");
// add the rmarkdown file as an attachment
            helper.addAttachment(rMarkdownFile.getName(), rMarkdownFile);
// send the email
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

  private void shareOnFacebook(File rMarkdownFile) {
// code to share the rmarkdown file on Facebook
        try {
            FacebookClient fbClient = new DefaultFacebookClient(accessToken);
            InputStream is = new FileInputStream(rMarkdownFile);
            FacebookType response = fbClient.publish("me/photos", FacebookType.class, BinaryAttachment.with(rMarkdownFile.getName(), is), Parameter.with("message", "Sharing my presentation on Facebook"));
            System.out.println("fb.com/"+response.getId());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*//*


  */
/*  private void shareOnWhatsapp(File rMarkdownFile, String phoneNumber) {
// code to share the rmarkdown file on WhatsApp
        try {
//create the URL with the phone number and the Rmarkdown file
            URL url = new URL("https://api.whatsapp.com/send?phone=" + phoneNumber + "&file="+rMarkdownFile.getAbsolutePath()+"&text=Sharing my presentation on WhatsApp");
// open the URL in a web browser
            Desktop.getDesktop().browse(url.toURI());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }*//*



}
*/
