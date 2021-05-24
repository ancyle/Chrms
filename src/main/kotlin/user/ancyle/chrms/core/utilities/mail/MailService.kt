package user.ancyle.chrms.core.utilities.mail

import user.ancyle.chrms.core.utilities.result.Result

interface MailService {

    fun sendMail(mail:String,token:String):Result;
    fun createToken():String;
}