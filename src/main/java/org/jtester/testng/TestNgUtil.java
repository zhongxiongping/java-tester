package org.jtester.testng;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNgUtil {
	/**
	 * 运行testng的单个测试方法
	 * 
	 * @param clazz
	 *            测试类
	 * @param method
	 *            方法名称
	 * @param throwException
	 *            是否抛出测试异常消息
	 * @return
	 */
	public static boolean run(String clazz, String method, boolean throwException) {
		TestNG tng = new TestNG();
		XmlSuite suite = new XmlSuite();
		XmlTest test = new XmlTest(suite);
		test.setName("run testng");
		XmlClass xmlClazz = new XmlClass(clazz);
		xmlClazz.getIncludedMethods().add(method);
		xmlClazz.getExcludedMethods().add(method + ".+");
		test.getXmlClasses().add(xmlClazz);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		tng.setXmlSuites(suites);
		TestListenerAdapter listener = new TestListenerAdapter();
		tng.addListener(listener);
		tng.run();
		int success = listener.getPassedTests().size();
		int failure = listener.getFailedTests().size();
		if (throwException) {
			for (ITestResult rt : listener.getFailedTests()) {
				throw new RuntimeException(rt.getThrowable());
			}
		}
		return success == 1 && failure == 0;
	}
}
