package reeseBenson.revature.project0.Data;

import java.util.List;

public interface IDAO<T, E> {

    T get(E PKEY);

    List<T> getAll();
    
    void update(T obj);
    
    void delete(T obj);

    void create(T obj);

}