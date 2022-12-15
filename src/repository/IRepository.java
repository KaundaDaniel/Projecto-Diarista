package repository;

import java.util.List;

public interface IRepository <T, ID>{
    List <T> buscarTodos();
    T cadastrar(T models);
    T buscarPorId(ID id);
    boolean apagarPorId(ID id);
}
