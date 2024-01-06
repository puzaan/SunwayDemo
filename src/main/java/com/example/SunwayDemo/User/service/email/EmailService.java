package com.example.SunwayDemo.User.service.email;

import com.example.SunwayDemo.User.entity.emailDetail.EmailDetail;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface EmailService {


    String sendSimpleMail(EmailDetail details) throws DocumentException, IOException;

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetail details);
}
