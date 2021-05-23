package user.ancyle.chrms.business.constants

sealed class Messages {
    companion object {
        const val success = "The process has been successfully completed."
        const val error = "The process couldn't pass some rules."
        const val failure = "An error occurred while processing request."
        const val maintenance="System is currently under Maintenance"
        const val mernis="Mernis validation failed."
        const val passwordFail="Passwords are different."
        const val userExists="User already exists."
        const val corpMailInvalid="Corporation mail is invalid."
        const val positionNameExists="This Position is already exists."
    }
}
