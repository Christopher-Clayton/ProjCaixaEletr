package model;

import java.sql.Date;

import dao.MovimentoDAO;
import to.MovimentoTO;

public class Movimento {
	private int    id;
	private Date dataMov;
	private int    valor;

	public Movimento() {
		super();
	}

	public Movimento(Date dataMov, int valor) {
		super();
		this.dataMov = dataMov;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataMov() {
		return dataMov;
	}

	public void setDataMov(Date dataMov) {
		this.dataMov = dataMov;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void consultaSaldo() {
		MovimentoDAO dao = new MovimentoDAO();
		MovimentoTO to = dao.carry(id);
		dataMov = to.getDataMov();
		valor = to.getValor();
	}

	@Override
	public String toString() {
		return "Movimento [id=" + id + ", dataMov=" + dataMov + ", valor="
				+ valor + "]";
	}
	
}
