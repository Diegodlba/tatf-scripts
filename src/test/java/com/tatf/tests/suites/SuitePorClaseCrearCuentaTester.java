package com.tatf.tests.suites;

import com.tatf.tests.crearCuenta.test.CrearCuentaTesterTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite por clase: Crear cuenta Tester")
@SelectClasses(CrearCuentaTesterTest.class)
public class SuitePorClaseCrearCuentaTester {
}
