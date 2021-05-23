package user.ancyle.chrms.business.abstracts

import user.ancyle.chrms.core.utilities.result.DataResult
import user.ancyle.chrms.core.utilities.result.Result
import user.ancyle.chrms.entities.concretes.Position

public interface PositionService {
    fun allPositions(): DataResult<List<Position>>
    fun newPosition(position: Position): Result
}