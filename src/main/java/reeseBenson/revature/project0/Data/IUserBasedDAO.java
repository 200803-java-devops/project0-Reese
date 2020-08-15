package reeseBenson.revature.project0.Data;

import java.util.List;

public interface IUserBasedDAO<T, E> {

    T get(String user ,E PKEY);

    List<T> getAll(String user);
    
    void update(String user, T obj);
    
    void delete(String user, T obj);

    void create(String user, T obj);

}