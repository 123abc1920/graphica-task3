package cs.vsu.ru.k2.g42.myshkevich_a_n.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs.vsu.ru.k2.g42.myshkevich_a_n.task.FindNormals;
import cs.vsu.ru.k2.g42.myshkevich_a_n.task.Vector3f;

class AnotherTests {

	@Test
	void normalizeTest1() {
		assertEquals(Math.round(FindNormals.normalize(new Vector3f(0.33f, 0.33f, 0.33f)).getCoords()[0] * 100), 58);
	}

	@Test
	void normalizeTest2() {
		assertEquals(Math.round(FindNormals.normalize(new Vector3f(1, 1, 1)).getCoords()[0] * 100), 58);
	}

	@Test
	void normalizeTest3() {
		assertEquals(Math.round(FindNormals.normalize(new Vector3f(2, 2, 2)).getCoords()[0] * 100), 58);
	}

	@Test
	void normalizeTest4() {
		assertEquals(FindNormals.normalize(new Vector3f(0, 0, 0)).getCoords()[0], 0);
	}

	@Test
	void normalizeTest5() {
		assertEquals(FindNormals.normalize(null), null);
	}

	@Test
	void determinantTest1() {
		assertEquals(FindNormals.determinant(new Vector3f(1, 1, 1), new Vector3f(1, 1, 1), new Vector3f(1, 1, 1)), 1.0);
	}

	@Test
	void determinantTest2() {
		assertEquals(FindNormals.determinant(new Vector3f(1, 1, 1), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1)), 0.0);
	}

	@Test
	void determinantTest3() {
		assertEquals(FindNormals.determinant(new Vector3f(1, 1, 1), new Vector3f(1, 1, 1), new Vector3f(0, 0, 0)), 0.0);
	}

	@Test
	void determinantTest4() {
		Vector3f a = new Vector3f(1, 0, 0);
		Vector3f b = new Vector3f(0, -1, 0);
		assertEquals(FindNormals.determinant(a, b, FindNormals.vectorProduct(a, b)), 1.0);
		assertEquals(FindNormals.determinant(b, a, FindNormals.vectorProduct(a, b)), -1.0);
	}

	@Test
	void vectorProductTest1() {
		assertEquals(FindNormals.vectorProduct(new Vector3f(1, 1, 1), new Vector3f(0, 0, 0)).getCoords()[0], 0.0);
		assertEquals(FindNormals.vectorProduct(new Vector3f(1, 1, 1), new Vector3f(0, 0, 0)).getCoords()[1], 0.0);
		assertEquals(FindNormals.vectorProduct(new Vector3f(1, 1, 1), new Vector3f(0, 0, 0)).getCoords()[2], 0.0);
	}

	@Test
	void vectorProductTest2() {
		assertEquals(FindNormals.vectorProduct(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0)).getCoords()[0], 0.0);
		assertEquals(FindNormals.vectorProduct(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0)).getCoords()[1], 0.0);
		assertEquals(FindNormals.vectorProduct(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0)).getCoords()[2], 0.0);
	}

	@Test
	void vectorProductTest3() {
		assertEquals(FindNormals.vectorProduct(new Vector3f(1, 21, 17), new Vector3f(3, 0, -8)).getCoords()[0], -168.0);
		assertEquals(FindNormals.vectorProduct(new Vector3f(1, 21, 17), new Vector3f(3, 0, -8)).getCoords()[1], 59.0);
		assertEquals(FindNormals.vectorProduct(new Vector3f(1, 21, 17), new Vector3f(3, 0, -8)).getCoords()[2], -63.0);
	}

}
