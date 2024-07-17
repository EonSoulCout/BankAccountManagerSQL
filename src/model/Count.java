package model;

import libreriaVersion3.generic;

public class Count {
	private generic<String,Integer>dtC;
	private generic <Integer,?>dteC;

	public Count() {
		dtC=new generic<>();
		dteC=new generic<>();
	}
	public Count(int id, int num_cuenta, String tipo_cuenta, String cedula_pro, int saldo ) {
		dtC=new generic<>(tipo_cuenta,cedula_pro,id,num_cuenta);
		dteC=new generic<>(saldo);
	}
	public int getID() {
		return dtC.getAttribute3();
	}
	public int getNum_cuenta() {
		return dtC.getAttribute4();
	}
	public String getTipo() {
		return dtC.getAttribute1();
	}
	public String getCedula() {
		return dtC.getAttribute2();
	}
	public int getSaldo() {
		return dteC.getAttribute1();
	}

	public void setID(int id_) {
		this.dtC.setAttribute3(id_);
	}
	public void setNum_cuenta(int num_) {
		this.dtC.setAttribute4(num_);
	}
	public void setTipo(String tipo_) {
		this.dtC.setAttribute1(tipo_);
	}
	public void setCedula(String ced_) {
		this.dtC.setAttribute2(ced_);
	}
	public void setSaldo(int saldo_) {
		this.dteC.setAttribute1(saldo_);;
	}

}
