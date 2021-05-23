package user.ancyle.chrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import user.ancyle.chrms.entities.concretes.JobSeeker;

public interface JobSeekerRepo extends JpaRepository<JobSeeker,Integer> {
}
