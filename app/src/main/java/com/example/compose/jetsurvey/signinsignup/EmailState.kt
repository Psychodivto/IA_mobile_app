package com.example.compose.jetsurvey.signinsignup

import java.util.regex.Pattern

// Consider an email valid if there's some text before and after a "@"
private const val EMAIL_VALIDATION_REGEX = "^(.+)@(.+)\$"

class EmailState :
    TextFieldState(validator = ::isEmailValid, errorFor = ::emailValidationError)

/**
 * Returns an error to be displayed or null if no error was found
 */
private fun emailValidationError(correo: String): String {
    return "Correo invalido: $correo"
}

private fun isEmailValid(correo: String): Boolean {
    return Pattern.matches(EMAIL_VALIDATION_REGEX, correo)
}
