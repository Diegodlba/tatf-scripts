package com.tatf.tests.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite por tag: humo")
@SelectPackages("com.tatf.tests")
@IncludeTags("humo")
public class SuitePorTagHumo {
}
