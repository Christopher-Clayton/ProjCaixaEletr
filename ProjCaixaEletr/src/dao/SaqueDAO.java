package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import to.SaqueTO;

public class SaqueDAO {

	private static final String SQL_UPDATE = "update SAQUE set VALOR = ? ";

	private static final String SQL_CARRY = "select VALOR from SAQUE where ID = ?";

	public void update(SaqueTO to) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(SQL_UPDATE);) {
			stm.setInt(1, to.getValor());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SaqueTO carry(int id) {
		SaqueTO to = new SaqueTO();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(SQL_CARRY);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setValor(rs.getInt("valor"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.getStackTrace();
		}
		return to;
	}

}
