package com.news_app.mobile.constants;

public class LoginPageConstants {
    public static final String PAGE_NAME = "Log In";

    public enum TEXT {
        LOG_IN_WITH("Log In with"),
        OR("or"),
        LETS_GO("Let's Go"),
        FORGOT_PASSWORD("Forgot Password?"),
        I_AM_STUCK_AND_NEED_HELP("I'm stuck and need help"),
        EMAIL("Email");

        private String text;

        TEXT(String text) {
            this.text = text;
        }

        public String getValue() {
            return text;
        }
    }

    public enum LABEL_FORMAT {
        BUTTON("%s-Button"),
        ENABLED_BUTTON("Enabled-%s-Button"),
        DISABLED_BUTTON("Disabled-%s-Button"),
        ICON("%s Icon"),
        ICON_O("%s-o Icon"),
        VERSION_KEY("versionKey-%s"),
        VERSION_VALUE("versionValue-%s"),
        SELECTED_BUTTON("selected-%s-Button"),
        NON_SELECTED_BUTTON("non-selected-%s-Button");

        private String format;

        LABEL_FORMAT(String format) {
            this.format = format;
        }

        public String getValue() {
            return format;
        }
    }

    public enum ACCESS_ID {
        LOGIN_WITH("Log In with"),
        LOGIN_WITH_FACEBOOK(String.format(LABEL_FORMAT.BUTTON.getValue(), "facebook")),
        LOGIN_WITH_GOOGLE(String.format(LABEL_FORMAT.BUTTON.getValue(), "google")),
        LOGIN_WITH_AMAZON(String.format(LABEL_FORMAT.BUTTON.getValue(), "amazon")),
        FORGOT_PASSWORD("Forgot Password?"),
        IM_STUCK_AND_NEED_HELP("I'm stuck and need help"),
        EMAIL("email"),
        PASSWORD("password"),
        INVALID_EMAIL_MSG("Invalid Email"),
        HIDE_EYE_ICON(String.format(LABEL_FORMAT.ICON.getValue(),"eye")),
        SHOW_EYE_ICON(String.format(LABEL_FORMAT.ICON.getValue(),"eye-slash")),
        DISABLED_LETS_GO_BUTTON(String.format(LABEL_FORMAT.DISABLED_BUTTON.getValue(), "Disabled-Let's Go")),
        ENABLED_LETS_GO_BUTTON(String.format(LABEL_FORMAT.ENABLED_BUTTON.getValue(), "Enabled-Let's Go")),
        OR_TEXT(String.format(LABEL_FORMAT.BUTTON.getValue(), TEXT.OR.getValue()));

        private String access_id;

        ACCESS_ID(String label) {
            this.access_id = label;
        }

        public String getValue() {
            return access_id;
        }
    }
}
