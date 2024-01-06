package com.example.SunwayDemo.User.service.email;

import com.example.SunwayDemo.Canteen.dto.foodDto.FoodDto;
import com.example.SunwayDemo.Canteen.service.foodService.FoodService;
import com.example.SunwayDemo.User.entity.emailDetail.EmailDetail;
import com.example.SunwayDemo.util.AttachmentStorageProperties;
import com.example.SunwayDemo.util.PdfGenerator;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Service
public class EmailImp implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PdfGenerator pdfGenerator;

    @Value("${spring.mail.username}") private String sender;

    private final static String rootPath = new AttachmentStorageProperties().getPATH();

    @Override
    public String sendSimpleMail(EmailDetail details) throws DocumentException, IOException {

        try {
            Boolean isCreated = pdfGenerator.generatePdf("dasdd", "app1.pdf");
            if(isCreated){
                for (String recipient: details.getRecipient()){
                    // Creating a simple mail message
                    SimpleMailMessage mailMessage = new SimpleMailMessage();
                    // Setting up necessary details
                    mailMessage.setFrom(sender);
                    mailMessage.setTo(recipient);
                    //            mailMessage.setTo(details.getRecipient());
                    mailMessage.setText(details.getMsgBody());
                    mailMessage.setSubject(details.getSubject());
                    // Sending the mail
//                    javaMailSender.send(mailMessage);
                }
                return "Mail Sent Successfully...";
            }else {
                return "error creating pdf file";
            }

        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            System.out.println(e);
            return "Error while Sending Mail";
        }
    }

    @Override
    public String sendMailWithAttachment(EmailDetail details) {



        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;


        try {
            Boolean isCreated = pdfGenerator.generatePdf("dasdd", "app1.pdf");
            if(isCreated) {
                for (String recipient : details.getRecipient()) {
                    // Setting multipart as true for attachments to
                    mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
                    mimeMessageHelper.setFrom(sender);
                    mimeMessageHelper.setTo(recipient);
                    mimeMessageHelper.setText(details.getMsgBody());
                    mimeMessageHelper.setSubject(details.getSubject());
                    // Adding the attachment
                    FileSystemResource file = new FileSystemResource(new File(rootPath.concat("/"+"app1.pdf")));
                    mimeMessageHelper.addAttachment(file.getFilename(), file);
                    // Sending the mail
                    javaMailSender.send(mimeMessage);
                }
                return "Mail sent Successfully";
            }else {
                return "error creating pdf file";
            }
        }
        // Catch block to handle MessagingException
        catch (MessagingException | IOException | DocumentException e) {
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
}
