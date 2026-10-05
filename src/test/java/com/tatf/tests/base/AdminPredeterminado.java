package com.tatf.tests.base;

import com.tatf.core.util.ConfigReader;

public class AdminPredeterminado {
    private static final ConfigReader CONFIG = new ConfigReader("config.properties");
    public static final String EMAIL = CONFIG.asString("adminces.admin.email");
    public static final String PASSWORD = CONFIG.asString("adminces.admin.password");
    public static final String NOMBRE = CONFIG.asString("adminces.admin.nombre");
}

