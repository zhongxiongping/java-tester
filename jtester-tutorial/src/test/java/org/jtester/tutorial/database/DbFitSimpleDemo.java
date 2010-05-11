package org.jtester.tutorial.database;

import org.jtester.testng.JTester;
import org.jtester.tutorial.services.PhoneBookService;
import org.jtester.unitils.dbfit.DbFit;
import org.jtester.unitils.spring.AutoBeanInject;
import org.jtester.unitils.spring.AutoBeanInject.BeanMap;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByName;

@Test
@SpringApplicationContext( { "spring/data-source.xml" })
@AutoBeanInject(maps = { @BeanMap(intf = "**.*", impl = "**.impl.*Impl") })
public class DbFitSimpleDemo extends JTester {
	@SpringBeanByName
	PhoneBookService phoneBookService;

	@DbFit(when = "simpleDemo.when.wiki", then = "simpleDemo.then.wiki")
	public void simpleDemo() {
		phoneBookService.insertPhoneBook("darui.wu", "15922225555", "classmate");
	}

	@DbFit(when = "simpleDemo.when.wiki", then = "orderQuery.then.wiki")
	public void orderQuery() {
		phoneBookService.insertPhoneBook("darui.wu", "15922225555", "classmate");
	}

	@DbFit(when = "simpleDemo.when.wiki", then = "delete.then.wiki")
	public void delete() {
		phoneBookService.insertPhoneBook("darui.wu", "15922225555", "classmate");
	}

	@DbFit(when = "multiDataSource_url.wiki")
	public void multiDataSource() {
		System.out.println("test");
	}

	@DbFit(when = "connectFromFile.wiki")
	public void connectFromFile() {
		System.out.println("test");
	}
}
