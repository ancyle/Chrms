package user.ancyle.chrms.business.abstracts

import user.ancyle.chrms.core.utilities.result.DataResult
import user.ancyle.chrms.core.utilities.result.Result
import user.ancyle.chrms.entities.concretes.Confirmation
import user.ancyle.chrms.entities.concretes.JobSeeker

interface JobSeekerService {
    fun newJobSeeker(jobSeeker:JobSeeker,password:String):Result;
    fun listAllJobSeekers():DataResult<List<JobSeeker>>;
    fun getJobSeekerByUserId(userId:Short):JobSeeker
}