package cs.vsu.ru.k2.g42.myshkevich_a_n.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Vector3f;
import cs.vsu.ru.k2.g42.myshkevich_a_n.model.Model;
import cs.vsu.ru.k2.g42.myshkevich_a_n.model.Polygon;
import cs.vsu.ru.k2.g42.myshkevich_a_n.normal.FindNormals;

class VertexNormalsTest {
	private static ArrayList<Vector3f> temporaryNormals = new ArrayList<>();
	private static Model m = new Model();

	@BeforeAll
	static void init() {
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
				if (m.polygons.get(j).getVertexIndices().contains(i + 1)) {
					polygonNormalsList.add(temporaryNormals.get(j));
				}
			}
			m.normals.add(FindNormals.findVertexNormals(polygonNormalsList));
		}

		for (Vector3f v : m.normals) {
			v.printVec();
		}
	}

	@Test
	void polynomCountTest() {
		List<Vector3f> polygonNormalsList = new ArrayList<>();
		for (int j = 0; j < m.polygons.size(); j++) {
			if (m.polygons.get(j).getVertexIndices().contains(1)) {
				polygonNormalsList.add(temporaryNormals.get(j));
			}
		}

		assertEquals(polygonNormalsList.size(), 3);
	}

	@Test
	void findVertexTest() {
		List<Vector3f> v = Arrays.asList(new Vector3f(-1, 0, 0), new Vector3f(0, 0, 1), new Vector3f(0, -1, 0));
		assertEquals(Math.round(FindNormals.findVertexNormals(v).getCoords()[0] * 100), -58);
	}

}
