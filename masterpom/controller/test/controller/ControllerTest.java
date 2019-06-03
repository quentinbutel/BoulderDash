package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Controller;
import entity.ControllerOrder;

public class ControllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOrder() {
		Controller test = new Controller(null, null);
		test.setOrder(ControllerOrder.Right);
		if (test.getOrder() != ControllerOrder.Right) {
			fail("Wrong type");
		}
	}

	@Test
	public void testGetView() {
		Controller test = new Controller(null, null);
		assertNull(test.getView());
	}

	@Test
	public void testGetModel() {
		Controller test = new Controller(null, null);
		assertNull(test.getModel());
	}

}
