package destinos.edu.pe.modelo;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


@Entity
@Table(name="Origen")
@NamedQueries({
	@NamedQuery(name= "Origen.findAll", query= "SELECT p FROM Origen p"),
	@NamedQuery(name= "Origen.findById_Origen", query= "SELECT p FROM Origen p WHERE p.Id_Origen = :Id_Origen"),
	@NamedQuery(name= "Origen.findByNro_Aeropuerto", query= "SELECT p FROM Origen p WHERE p.Nro_Aeropuerto = :Nro_Aeropuerto"),
	@NamedQuery(name= "Origen.findByCiudad", query= "SELECT p FROM Origen p WHERE p.Ciudad = :Ciudad"),
	@NamedQuery(name= "Origen.findByCod_Ciudad", query= "SELECT p FROM Origen p WHERE p.Cod_Ciudad = :Cod_Ciudad"),
	@NamedQuery(name= "Origen.findByEstado", query= "SELECT p FROM Origen p WHERE p.Estado = :Estado"),
})
public class Origen implements Serializable{
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Basic(optional = true)
	private Integer Id_Origen;
	
	@Basic (optional = false)
	@Column(name= "Nro_Aeropuerto")
	private String  Nro_Aeropuerto;
	
	@Column (name= "Ciudad")
	private String Ciudad;
	
	@Column (name = "Cod_Ciudad")
	private String Cod_Ciudad;
	
	@Column (name = "Estado")
	private String Estado;
	
	
	public Origen() {
		
	}

	public Origen(String nro_Aeropuerto, String ciudad, String cod_Ciudad, String estado) {
		super();
		Nro_Aeropuerto = nro_Aeropuerto;
		Ciudad = ciudad;
		Cod_Ciudad = cod_Ciudad;
		Estado = estado;
	}

	public Integer getId_Origen() {
		return Id_Origen;
	}

	public void setId_Origen(Integer id_Origen) {
		Id_Origen = id_Origen;
	}

	public String getNro_Aeropuerto() {
		return Nro_Aeropuerto;
	}

	public void setNro_Aeropuerto(String nro_Aeropuerto) {
		Nro_Aeropuerto = nro_Aeropuerto;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getCod_Ciudad() {
		return Cod_Ciudad;
	}

	public void setCod_Ciudad(String cod_Ciudad) {
		Cod_Ciudad = cod_Ciudad;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Origen [Id_Origen=" + Id_Origen + "]";
	}
	
	//@OneToMany(cascade = CacadeType.All, mappedBy = "Origen", fetch=FetchType.Lazy)
	//@JsonBackReference(value="Origen_fun")
	//private List<Pasaje> pasajeList;
	
	
	
	
	

}
