package cs.vsu.ru.k2.g42.myshkevich_a_n.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
	public static ArrayList<Vector3f> temporaryNormals = new ArrayList<>();

	public static void main(String[] args) {
		Model m = new Model();

		/*
		 * f 1/1/1 2/2/1 4/3/1 3/4/1 f 3/5/2 4/6/2 8/7/2 7/8/2 f 7/9/3 8/10/3 6/11/3
		 * 5/12/3 f 5/13/4 6/14/4 2/15/4 1/16/4 f 3/17/5 7/18/5 5/19/5 1/20/5 f 8/21/6
		 * 4/22/6 2/23/6 6/24/6
		 */

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

		for (Vector3f v : temporaryNormals) {
			v.printVec();
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
}

/*-1.0000 -0.0000 -0.0000
vn -0.0000 -0.0000 -1.0000
vn 1.0000 -0.0000 -0.0000
vn -0.0000 -0.0000 1.0000
vn -0.0000 -1.0000 -0.0000
vn -0.0000 1.0000 -0.0000*/
