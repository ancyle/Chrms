package user.ancyle.chrms.core.utilities.business

import user.ancyle.chrms.business.constants.Messages
import user.ancyle.chrms.core.utilities.result.ErrorResult
import user.ancyle.chrms.core.utilities.result.Result
import user.ancyle.chrms.core.utilities.result.SuccessResult

sealed class RuleVerifier {
    companion object {
        open fun verify(vararg rules: Result): Result {
            for (rule in rules) {
                if (!rule.isSuccess) return ErrorResult(rule.message)
            }
            return SuccessResult();
        }
    }
}
