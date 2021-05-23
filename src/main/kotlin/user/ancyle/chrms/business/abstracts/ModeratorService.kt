package user.ancyle.chrms.business.abstracts

import user.ancyle.chrms.core.utilities.result.DataResult
import user.ancyle.chrms.core.utilities.result.Result
import user.ancyle.chrms.entities.concretes.Moderator

public interface ModeratorService {
    fun newModerator(moderator:Moderator):Result
    fun listAllModerators():DataResult<List<Moderator>>;
}