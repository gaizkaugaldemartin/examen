import java.util.List;

public interface IPersistible<T> {

	List<Revista> getAll();

	Revista getById(int id);

	boolean insert(Revista pojo);

	boolean delete(int id);

	boolean update(Revista pojo);

}
