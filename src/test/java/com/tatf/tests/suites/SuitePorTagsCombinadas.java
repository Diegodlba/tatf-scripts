package com.tatf.tests.suites;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Suite combinada: crearCuenta + humo")
@SelectPackages("com.tatf.tests")
@IncludeTags("modulo-crearCuenta & humo")
@ExcludeTags("debug") //Actualmente ningun test tiene el tag Debug ya que ninguno está en desarrollo.
@IncludeClassNamePatterns(".*Test")
public class SuitePorTagsCombinadas {
}
