package cs.vsu.ru.k2.g42.myshkevich_a_n.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cs.vsu.ru.k2.g42.myshkevich_a_n.task.FindNormals;
import cs.vsu.ru.k2.g42.myshkevich_a_n.task.Model;
import cs.vsu.ru.k2.g42.myshkevich_a_n.task.Polygon;
import cs.vsu.ru.k2.g42.myshkevich_a_n.task.Vector3f;

class PolygonNormalsTest {
	private static ArrayList<Vector3f> temporaryNormals = new ArrayList<>();

	@BeforeAll
	static void init() {
		Model m = new Model();

		m.vertices.add(new Vector3f(-1, -1, 1));
		m.vertices.add(new Vector3f(-1, 1, 1));
		m.vertices.add(new Vector3f(-1, -1, -1));
		m.vertices.add(new Vector3f(-1, 1, -1));

		m.vertices.add(new Vector3f(1, -1, 1));
		m.vertices.add(new Vector3f(1, 1, 1));
		m.vertices.add(new Vector3f(1, -1, -1));
		m.vertices.add(new Vector3f(1, 1, -1));

		m.polygons.add(new Polygon(Arrays.asList(1, 2, 4, 3)));
		m.polygons.add(new Polygon(Arrays.asList(3, 4, 8, 7)));
		m.polygons.add(new Polygon(Arrays.asList(7, 8, 6, 5)));
		m.polygons.add(new Polygon(Arrays.asList(5, 6, 2, 1)));
		m.polygons.add(new Polygon(Arrays.asList(3, 7, 5, 1)));
		m.polygons.add(new Polygon(Arrays.asList(8, 4, 2, 6)));

		for (Polygon p : m.polygons) {
			temporaryNormals.add(FindNormals.findPolygonsNormals(m.vertices.get(p.getVertexIndices().get(0) - 1),
					m.vertices.get(p.getVertexIndices().get(1) - 1), m.vertices.get(p.getVertexIndices().get(2) - 1)));
		}

		for (int i = 0; i < m.vertices.size(); i++) {
			List<Vector3f> polygonNormalsList = new ArrayList<>();
			for (int j = 0; j < m.polygons.size(); j++) {
				if (m.polygons.get(j).getVertexIndices().contains(i)) {
					polygonNormalsList.add(temporaryNormals.get(j));
				}
			}
			m.normals.add(FindNormals.findVertexNormals(polygonNormalsList));
		}
	}

	@Test
	void polygonNormalsCubeTest1() {
		assertEquals(temporaryNormals.get(0).getCoords()[0], -1.0);
		assertEquals(temporaryNormals.get(0).getCoords()[1], 0.0);
		assertEquals(temporaryNormals.get(0).getCoords()[2], 0.0);
	}
	
	@Test
	void polygonNormalsCubeTest2() {
		assertEquals(temporaryNormals.get(2).getCoords()[0], 1.0);
		assertEquals(temporaryNormals.get(2).getCoords()[1], 0.0);
		assertEquals(temporaryNormals.get(2).getCoords()[2], 0.0);
	}
	
	@Test
	void polygonNormalsCubeTest3() {
		assertEquals(temporaryNormals.get(3).getCoords()[0], 0.0);
		assertEquals(temporaryNormals.get(3).getCoords()[1], 0.0);
		assertEquals(temporaryNormals.get(3).getCoords()[2], 1.0);
	}
	
	@Test
	void polygonNormalsCubeTest4() {
		assertEquals(temporaryNormals.get(4).getCoords()[0], -0.0);
		assertEquals(temporaryNormals.get(4).getCoords()[1], -1.0);
		assertEquals(temporaryNormals.get(4).getCoords()[2], 0.0);
	}
	
	@Test
	void polygonNormalsCubeTest5() {
		assertEquals(temporaryNormals.get(5).getCoords()[0], -0.0);
		assertEquals(temporaryNormals.get(5).getCoords()[1], 1.0);
		assertEquals(temporaryNormals.get(5).getCoords()[2], 0.0);
	}

}
