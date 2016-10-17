package com.thomaz.ambiduos.support;

/**
 * Created by thomaz on 16/10/16.
 */
public class WSUrlProvider {

    static private final String MAIN_URL = "http://educ.senailondrina.com.br:82/api";

    public static final class Login {
        static public final String URL = MAIN_URL + "/AccountApi/Logar";

        public final class Entry {
            static public final String EMAIL = "Email";
            static public final String SENHA = "Senha";
        }

        public class Exit {
            static public final String USER = "User";
        }
    }

}