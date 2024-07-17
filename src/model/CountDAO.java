package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountDAO implements Config {
	private Count cuenta;

	public CountDAO(model.Count cuenta) {
		super();
		this.cuenta = cuenta;
	}
	
	public CountDAO() {
		super();
	}
	
	public boolean insetCuenta() {
		boolean estate=conn.setQuery(String.format("INSERT INTO bank.counts VALUES(null,%d,'%s',%d,%d);", 
				cuenta.getNum_cuenta(),cuenta.getTipo(),Long.parseLong(cuenta.getCedula()),cuenta.getSaldo()));
		return estate;
	}
	public boolean actualizar(int saldo, int cedula) {
		boolean actualizar=conn.setQuery(String.format("UPDATE bank.counts SET currency = %s WHERE dni_propie= %d", saldo,cedula));
		return actualizar;
	}
	
	public List<Count> loadAllUser() throws SQLException{
		List<Count>cuentas=new ArrayList();
		ResultSet res=conn.getQuery("SELECT * FROM bank.counts;");
		while(res.next()) {
			cuentas.add(new Count(res.getInt(1),res.getInt(2),res.getString(3),String.valueOf(res.getInt(4)),res.getInt(5)));
		}
		conn.closeConn();
		return cuentas;
	}
}
