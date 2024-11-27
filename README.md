**Нахождение нормалей**

__*Все необходимое для поиска находится в cs.vsu.ru.k2.g42.myshkevich_a_n.normal.FindNormals*__

***

1. __ArrayList<Vector3f> findNormals(Model m) -- m -- модель. Таким образом, в массиве m.normals все нормали идут в том же порядке, что и их вершины. Пример:__
	``` 
	model.normals = FindNormals.findNormals(model);
	```

1. Vector3f findPolygonsNormals(Vector3f... vs) -- получает 3 вершины полигона, возвращает нормаль полигона.

1. Vector3f findVertexNormals(List<Vector3f> vs) -- получает нормали тех векторов, к которым принадлежит вершина и возвращает вершину нормали.

1. determinant(Vector3f a, Vector3f b, Vector3f c) -- получает два вектора полигона и нормаль и возвращает детерминант. Нужно чтобы все были правыми тройками.

1. Vector3f normalize(Vector3f v) -- нормализует вектор.

1. Vector3f vectorProduct(Vector3f a, Vector3f b) -- возвращает векторное произведение.

***

**Тесты** находятся в cs.vsu.ru.k2.g42.myshkevich_a_n.tests.PolygonNormalsTest и cs.vsu.ru.k2.g42.myshkevich_a_n.tests.VertexNormalsTest. Остальные тесты проверяют не этот модуль.