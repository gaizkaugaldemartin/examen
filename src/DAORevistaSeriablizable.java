import java.util.ArrayList;
import java.util.List;

public class DAORevistaSeriablizable {

	public class DAOAlumnoArrayList implements IPersistible<Revista> {

		private DAOAlumnoArrayList INSTANCE;
		private ArrayList<Revista> lista;

		/**
		 * Encargado de devolver solo 1 objeto, patron Singleton
		 * 
		 * @return
		 */
		public synchronized DAOAlumnoArrayList getInstance() {

			if (INSTANCE == null) {
				INSTANCE = new DAOAlumnoArrayList();
			}

			return INSTANCE;

		}

		/**
		 * Privado para que nadie pueda crear objetos
		 */
		private DAOAlumnoArrayList() {
			super();
			lista = new ArrayList<Revista>();
		}

		public List<Revista> getAll() {
			return lista;
		}

		public Revista getById(int id) {
			Revista resul = null;
			for (Revista a : lista) {

				if (a.getId() == id) {
					resul = a;
					break;
				}
			}
			return resul;
		}

		public boolean insert(Revista pojo) {
			boolean resul = false;
			if (pojo != null) {
				resul = lista.add(pojo);
			}
			return resul;
		}

		public boolean delete(int id) {

			Revista a = getById(id);

			return lista.remove(a);
		}

		@Override
		public boolean update(Revista pojo) {
			// TODO Auto-generated method stub
			return false;
		}

	}

	public static DAORevistaSeriablizable getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(Revista nuevoRevista) {
		// TODO Auto-generated method stub
		return false;
	}

}
