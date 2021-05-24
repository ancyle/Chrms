package user.ancyle.chrms.business.abstracts

import user.ancyle.chrms.core.utilities.result.Result
import user.ancyle.chrms.entities.concretes.Confirmation
import user.ancyle.chrms.entities.concretes.User

interface ConfirmationService {
    fun newConfirmation(user:User):Result
    fun findByToken(token:String):Confirmation
    fun verifyAccount(confirmation:Confirmation)
}