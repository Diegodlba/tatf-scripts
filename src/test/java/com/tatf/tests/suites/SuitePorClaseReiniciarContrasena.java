package com.tatf.tests.suites;

import com.tatf.tests.reiniciarContrasena.test.ReiniciarContrasenaTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite por clase: Reiniciar contrasena")
@SelectClasses(ReiniciarContrasenaTest.class)
public class SuitePorClaseReiniciarContrasena {
}
