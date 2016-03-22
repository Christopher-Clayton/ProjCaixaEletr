package model;

import java.sql.Date;

import dao.SaqueDAO;
import to.SaqueTO;

public class Saque {

	private int id;
	private int valor;
	private Date data;

	public Saque(int id, int valor, Date data) {
		this.id = id;
		this.valor = valor;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public void efetuarSaque() {
		SaqueDAO dao = new SaqueDAO(); 
		SaqueTO to = new SaqueTO();
		to.setValor(valor);
		dao.update(to);
	}

	@Override
	public String toString() {
		return "Saque [id=" + id + ", valor=" + valor + ", data=" + data + "]";
	}
		
}
