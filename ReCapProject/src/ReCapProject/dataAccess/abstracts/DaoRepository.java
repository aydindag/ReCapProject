package ReCapProject.dataAccess.abstracts;

import java.util.List;

import ReCapProject.entities.concretes.Brand;

public interface DaoRepository<T> {
	void insert(T entity);
	void delete(int id);
	void update(int index, T entity);
	List<T> getAll();
	T getById(int id);
	int getIndex(T entity);
}
