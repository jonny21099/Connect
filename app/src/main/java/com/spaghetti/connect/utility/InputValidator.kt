package com.spaghetti.connect.utility

import java.lang.Character.*
import java.util.regex.Pattern

class InputValidator {
    companion object{
        /**
         * Check if a given string of email address is valid
         * @param email String
         * @return true if email is the right format
         */
        fun validEmail(email: String): Boolean {
            val pattern = "^[a-zA-Z0-9\\-!#$%&'*+/=?^_`{|}~.]+@\\w+\\.\\w+$"
            val r = Pattern.compile(pattern)
            val m = r.matcher(email)
            return m.find()
        }

        /**
         * Check if a given string of phone number is valid
         * @param phone String
         * @return true if phone is the right format
         */
        fun validPhone(phone: String): Boolean {
            val pattern = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$"
            val r = Pattern.compile(pattern)
            val m = r.matcher(phone)
            return m.find()
        }

        /**
         * Check if a given string of username is valid
         * @param username String
         * @return true if username is the right format
         */
        fun validUsername(username: String): Boolean {
            val pattern = "^[A-Za-z0-9_-]{5,15}$"
            val r = Pattern.compile(pattern)
            val m = r.matcher(username)
            return m.find()
        }

        /**
         * Check if a given string of password os valid
         * Password Rule: len >= 8. has upper, has lower, has number and has special char
         * @param password String
         * @return true is the password is in the right format
         */
        fun validPassword(password: String): Boolean {
            val specialCharacterPattern = "[$&+,:;=?@#|'<>.^*()%!\\-_]"
            val r = Pattern.compile(specialCharacterPattern)
            val validLength = password.length >= 8
            var hasLowerCase = false
            var hasUpperCase = false
            var hasNumber = false
            var hasSpecialChar = false
            for (Char in password.toCharArray()) {
                if (isUpperCase(Char)) {
                    hasUpperCase = true
                } else if (isLowerCase(Char)) {
                    hasLowerCase = true
                } else if (isDigit(Char)) {
                    hasNumber = true
                } else if (!hasSpecialChar) {
                    val m = r.matcher(password)
                    if (m.find()) {
                        hasSpecialChar = true
                    }
                }
            }
            return validLength && hasLowerCase && hasUpperCase && hasSpecialChar && hasNumber
        }
    }
}