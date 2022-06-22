package com.emrap.app.core.utilities.regex;

public interface RegexService {

    boolean isEmailValid(String emailInput);

    boolean isFirstNameFormat(String firstNameFormat);

    boolean isLastNameFormat(String lastNameFormat);

    boolean isDateOfBirthFormat(String dateOfBirthFormat);

    boolean isPhoneNumberFormat(String phoneNumberFormat);

    boolean isPasswordFormat(String passwordFormat);
}
