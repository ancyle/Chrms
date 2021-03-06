package user.ancyle.chrms.business.abstracts

import user.ancyle.chrms.core.utilities.result.DataResult
import user.ancyle.chrms.core.utilities.result.Result
import user.ancyle.chrms.entities.concretes.Employer

interface EmployerService {
    fun newEmployer(employer:Employer,password:String):Result;
    fun listAllEmployers():DataResult<List<Employer>>
    fun deleteEmployer(byMail:String):Result;
}