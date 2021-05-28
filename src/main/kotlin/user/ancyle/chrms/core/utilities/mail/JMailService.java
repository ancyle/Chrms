package user.ancyle.chrms.core.utilities.mail;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import user.ancyle.chrms.core.utilities.result.ErrorResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.core.utilities.result.SuccessResult;

import java.util.UUID;

@Service
public class JMailService implements MailService{

    private final JavaMailSender mailSender;

    @Autowired
    public JMailService(JavaMailSender javaMailSender){
        this.mailSender=javaMailSender;
    }

    @NotNull
    @Override
    public Result sendMail(@NotNull String mail, @NotNull String token) {
        var mime=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mime);
        try{
            helper.setTo(mail);
            helper.setSubject("Account Activation");
            helper.setText("To Activate Your Account Follow Link : "+
                    "http://localhost:8080/confirm-account?token="+token);
            mailSender.send(mime);
            return new SuccessResult();
        }
        catch (Exception ex){
            return new ErrorResult(ex.getMessage());
        }
    }

    @NotNull
    @Override
    public String createToken() {
        return UUID.randomUUID().toString();
    }
}
