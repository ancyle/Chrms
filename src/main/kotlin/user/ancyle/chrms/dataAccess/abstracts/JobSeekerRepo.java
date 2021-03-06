package user.ancyle.chrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import user.ancyle.chrms.entities.concretes.JobSeeker;

@Repository
@Transactional
public interface JobSeekerRepo extends JpaRepository<JobSeeker,Short> {
    JobSeeker getJobSeekerByUser_UserId(short userId);
}
