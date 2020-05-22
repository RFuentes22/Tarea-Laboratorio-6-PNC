package com.uca.capas.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public",name="contribuyente")
public class Contribuyente{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_contribuyente")
	private Integer	ccontribuyente;
	
	@NotNull(message = "Debes de seleccionar una importancia")
	@Column(name="c_importancia")
	private Integer cimportancia;

	@Size(min = 1,max = 30, message = "El Nombre debe tener de 1 a 30 caracteres")
	@Column(name="s_nombre")
	private String snombre;
	
	@Size(min = 1,max = 30, message = "El Apellido debe tener de 1 a 30 caracteres")
	@Column(name="s_apellido")
	private String sapellido;
	
	@Size(min = 1,max = 14, message = "El Nit debe tener de 1 a 14 caracteres")
	@Column(name="s_nit")
	private String snit;
	
	@Column(name="f_fecha_ingreso")
	private Date ffecha_ingreso;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia",unique=true,insertable = false, updatable = false)
	private Importancia importancia;
	
	
	public Contribuyente() {
		
	}


	public Integer getCcontribuyente() {
		return ccontribuyente;
	}


	public void setCcontribuyente(Integer ccontribuyente) {
		this.ccontribuyente = ccontribuyente;
	}




	public Integer getCimportancia() {
		return cimportancia;
	}


	public void setCimportancia(Integer cimportancia) {
		this.cimportancia = cimportancia;
	}


	public String getSnombre() {
		return snombre;
	}

	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}

	public String getSapellido() {
		return sapellido;
	}

	public void setSapellido(String sapellido) {
		this.sapellido = sapellido;
	}

	public String getSnit() {
		return snit;
	}

	public void setSnit(String snit) {
		this.snit = snit;
	}

	public Date getFfecha_ingreso() {
		return ffecha_ingreso;
	}

	public void setFfecha_ingreso(Date ffecha_ingreso) {
		this.ffecha_ingreso = ffecha_ingreso;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}


	public String getFechaDelegate(){
		if(this.ffecha_ingreso == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String shortdate = sdf.format(this.ffecha_ingreso.getTime());
			return shortdate;
		}
	}


	
	


}
