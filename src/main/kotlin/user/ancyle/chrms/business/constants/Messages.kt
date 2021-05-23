package user.ancyle.chrms.business.constants

sealed class Messages {
    companion object {
        const val success = "The process has been successfully completed."
        const val error = "An error occurred while processing request."
        const val failure = "Something went wrong."
        const val maintenance="System is currently under Maintenance"
    }
}
