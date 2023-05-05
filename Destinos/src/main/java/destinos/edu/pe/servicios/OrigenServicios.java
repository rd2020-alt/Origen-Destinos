package destinos.edu.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import destinos.edu.pe.modelo.Origen;
import destinos.edu.pe.repositorio.OrigenRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrigenServicios {
	
	@Autowired
	private OrigenRepositorio repositorio;
	
	public OrigenServicios() {
		
	}
	
	public List<Origen> buscarTodo(){
		return(List<Origen>) repositorio.findAll();
	}
	
	public Origen crear(Origen Origen) {
		return repositorio.save(Origen);
	}
	
	public Origen editar(Origen OrigenEditar) {
		Origen OrigenActual = repositorio.findById(OrigenEditar.getId_Origen()).get();
		
		OrigenActual.setId_Origen(OrigenEditar.getId_Origen());
		OrigenActual.setNro_Aeropuerto(OrigenEditar.getNro_Aeropuerto());
		OrigenActual.setCiudad(OrigenEditar.getCiudad());
		OrigenActual.setCod_Ciudad(OrigenEditar.getCod_Ciudad());
		OrigenActual.setEstado(OrigenEditar.getEstado());
		
		Origen OrigenEditar1 = repositorio.save(OrigenActual);
		return OrigenEditar1;
		
	}
	
	public Origen buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorId(Integer id) {
		
		repositorio.deleteById(id);
	}

}
