package cs.vsu.ru.k2.g42.myshkevich_a_n.model;

import java.util.ArrayList;

import cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Vector2f;
import cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Vector3f;

public class Model {
	public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
	public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
	public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
	public ArrayList<Polygon> polygons = new ArrayList<Polygon>();
}