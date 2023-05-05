package destinos.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import destinos.edu.pe.modelo.Origen;

public interface OrigenRepositorio extends CrudRepository<Origen, Integer> {
	
	@Query(value = "SELECT a FROM Origen a WHERE a.Ciudad= ?1")
	public List<Origen> buscarOrigenPorCiudad(String Ciudad);
	
	@Query(value = "SELECT a FROM Origen a WHERE a.Ciudad like CONCAT (?1,'%')")
	public List<Origen> buscarOrigenLikeCiudad(String Ciudad);

}
