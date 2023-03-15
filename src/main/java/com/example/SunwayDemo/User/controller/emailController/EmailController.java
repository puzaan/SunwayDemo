package com.example.SunwayDemo.User.controller.emailController;

import com.example.SunwayDemo.User.entity.emailDetail.EmailDetail;
import com.example.SunwayDemo.User.service.email.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetail details)
    {
        if(details.getAttachment() !=null && !details.getAttachment().isEmpty()){
            String status = emailService.sendMailWithAttachment(details);
            return status;
        }else {
            String status = emailService.sendSimpleMail(details);
            return status;


        }

    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetail details)
    {
        String status = emailService.sendMailWithAttachment(details);

        return status;
    }
}
