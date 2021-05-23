package user.ancyle.chrms.business.constants

public sealed class Messages {
    companion object {
        const val success = "The process has been successfully completed."
        const val error = "The process couldn't pass some rules."
        const val failure = "An error occurred while processing request."
        const val maintenance="System is currently under Maintenance"
    }
}
