package ejemploWebObj.aplicacion.dao;

import javax.persistence.*;

@Entity
@Table(name="dlk_gap_tch_portatiles",schema="dlk_gestionAlumnoPortatil")
public class PortatilAsignado {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_portatil")
	private int idPortatil;
	
	@Column(name="marca_portatil")
	private String marca;
	
	@Column(name="modelo_portatil")
	private String modelo;

	//GETTERS & SETTERS
	public int getIdPortatil() {
		return idPortatil;
	}

	public void setIdPortatil(int idPortatil) {
		this.idPortatil = idPortatil;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	//CONSTRUCTORES
	
	public PortatilAsignado(int idPortatil, String marca, String modelo) {
		super();
		this.idPortatil = idPortatil;
		this.marca = marca;
		this.modelo = modelo;
	}
	

	public PortatilAsignado() {
		super();
	}

	@Override
	public String toString() {
		return "PortatilAsignado [idPortatil=" + idPortatil + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}
