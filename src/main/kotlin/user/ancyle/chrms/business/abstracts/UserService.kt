package user.ancyle.chrms.business.abstracts

import user.ancyle.chrms.core.utilities.result.DataResult
import user.ancyle.chrms.core.utilities.result.Result
import user.ancyle.chrms.entities.concretes.JobSeeker
import user.ancyle.chrms.entities.concretes.User

interface UserService {
    fun newUser(user:User):Result;
    fun allUsers():DataResult<List<User>>;
    fun getUserByMail(jobSeeker: JobSeeker):Result;
}