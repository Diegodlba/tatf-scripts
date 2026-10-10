package com.tatf.tests.suites;

import com.tatf.tests.crearCuenta.test.CrearCuentaTesterTest;
import com.tatf.tests.verUsuarios.test.EliminarCuentaTesterTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite por clase: Eliminar cuenta Tester")
@SelectClasses(EliminarCuentaTesterTest.class)
public class SuitePorClaseEliminarCuentaTester {
}
