package com.example.compose.jetsurvey.signinsignup

class PasswordState :
    TextFieldState(validator = ::isPasswordValid, errorFor = ::passwordValidationError)

class ConfirmPasswordState(private val passwordState: PasswordState) : TextFieldState() {
    override val isValid
        get() = passwordAndConfirmationValid(passwordState.text, text)

    override fun getError(): String? {
        return if (showErrors()) {
            passwordConfirmationError()
        } else {
            null
        }
    }
}

private fun passwordAndConfirmationValid(contraseña: String, confirmedPassword: String): Boolean {
    return isPasswordValid(contraseña) && contraseña == confirmedPassword
}

private fun isPasswordValid(contraseña: String): Boolean {
    return contraseña.length > 3
}

@Suppress("UNUSED_PARAMETER")
private fun passwordValidationError(contraseña: String): String {
    return "Invalid password"
}

private fun passwordConfirmationError(): String {
    return "Passwords don't match"
}
