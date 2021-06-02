
package datasouces.hsqldb.repository;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ivanoliveira
 */
public interface InterfaceDAO<T> {
    
    /// salvar entidades 
    public void salvar(T entidade) throws SQLException;
    
    // deletar entidades 
    public void deletar(T entidade) throws SQLException;
    
    // pesquisar por Id
    public T buscarPorId(int id)throws SQLException;
    
    // modificar um objeto 
    public void atualizar(T entidade)throws SQLException;
    
    // listar todos
   public List<T> listarTodos()throws SQLException;
    
    
            
    
    
    
    
    
  //  Object é mãe de todas as objetos 
    
}
