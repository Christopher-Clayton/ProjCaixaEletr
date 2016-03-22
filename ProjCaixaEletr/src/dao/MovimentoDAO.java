package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import to.MovimentoTO;

public class MovimentoDAO {

	private static final String SQL_INSERT = "insert into MOVIMENTO (DATAMOV, VALOR) values (?, ?)";

	private static final String SQL_UPDATE = "update MOVIMENTO set DATAMOV = ?, VALOR = ? ";

	private static final String SQL_REMOVE = "delete from MOVIMENTO where ID = ?";

	private static final String SQL_CARRY = "select DATAMOV, VALOR from MOVIMENTO where ID = ?";

	private static final String SQL_FIND_ALL = "select * from MOVIMENTO";

	public void insert(MovimentoTO to) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);) {
			pstm.setDate(1, to.getDataMov());
			pstm.setDouble(2, to.getValor());
			pstm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(MovimentoTO to) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);) {
			pstm.setDate(1, to.getDataMov());
			pstm.setDouble(2, to.getValor());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remove(MovimentoTO to) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstm = conn.prepareStatement(SQL_REMOVE);) {
			pstm.setInt(1, to.getId());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MovimentoTO carry(int id) {
		MovimentoTO to = new MovimentoTO();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstm = conn.prepareStatement(SQL_CARRY);) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery();) {
				if (rs.next()) {
					to.setDataMov(rs.getDate("DATAMOV"));
					to.setValor(rs.getInt("VALOR"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return to;
	}

	public List<MovimentoTO> findAll() {
		List<MovimentoTO> movimentos = new ArrayList<MovimentoTO>();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstm = conn.prepareStatement(SQL_FIND_ALL);) {
			try (ResultSet rs = pstm.executeQuery();) {
				if (rs.next()) {
					MovimentoTO to = new MovimentoTO();
					to.setDataMov(rs.getDate("DATAMOV"));
					to.setValor(rs.getInt("VALOR"));
					movimentos.add(to);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return movimentos;
	}
}
