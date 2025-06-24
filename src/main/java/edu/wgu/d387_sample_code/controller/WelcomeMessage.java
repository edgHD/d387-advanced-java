package edu.wgu.d387_sample_code.controller;

import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeMessage {

    private final ResourceBundle resourceBundle;

    public WelcomeMessage(String language, String country) {
        Locale locale = new Locale(language, country);
        this.resourceBundle = ResourceBundle.getBundle("lang", locale);
    }

    public String getWelcomeMessage() {
        return resourceBundle.getString("welcomeMessage");
    }
}