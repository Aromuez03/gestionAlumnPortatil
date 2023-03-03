package ejemploWebObj.aplicacion.dtos;

public class PortatilAsigDto {

		//ATRIBUTOS
		private int idPortatil;
		
		private String marca;
		
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
		
		public PortatilAsigDto(int idPortatil, String marca, String modelo) {
			super();
			this.idPortatil = idPortatil;
			this.marca = marca;
			this.modelo = modelo;
		}
		

		public PortatilAsigDto() {
			super();
		}

		@Override
		public String toString() {
			return "PortatilAsigDto [idPortatil=" + idPortatil + ", marca=" + marca + ", modelo=" + modelo + "]";
		}
}
