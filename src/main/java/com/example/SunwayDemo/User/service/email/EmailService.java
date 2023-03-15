package com.example.SunwayDemo.User.service.email;

import com.example.SunwayDemo.User.entity.emailDetail.EmailDetail;

public interface EmailService {


    String sendSimpleMail(EmailDetail details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetail details);
}
