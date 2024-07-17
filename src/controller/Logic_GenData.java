package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import model.*;
import view.view_cuenta;

public class Logic_GenData implements ActionListener ,Para {
	private view_cuenta vc;
	public boolean flag=false;

	public Logic_GenData(view_cuenta vc) {
		super();
		this.vc = vc;
		this.vc.btn_buscar.addActionListener(this);
		this.vc.btn_EJECUTAR.addActionListener(this);
		this.vc.rdbtn_retiro.addActionListener(this);
		this.vc.rdbtn_deposito.addActionListener(this);
		inicio();
	}
	private void inicio() {
		Logic_Counts cnueva= new Logic_Counts();
		cnueva.start();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vc.btn_buscar) {
			cuenta.setCedula(vc.txt_CEDULA.getText());
			try {
				List<Count>cuentas=cdao.loadAllUser();
				for(Count c:cuentas) {
					if(c.getCedula().equals(cuenta.getCedula())) {
						cuenta.setCedula(c.getCedula());
						cuenta.setNum_cuenta(c.getNum_cuenta());
						cuenta.setTipo(c.getTipo());
						cuenta.setID(c.getID());
						cuenta.setSaldo(c.getSaldo());;
						flag=true;
					}
				}
				Fields();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}else if(e.getSource()==vc.btn_EJECUTAR) {
			if(vc.rdbtn_deposito.isSelected()) {
				Operations(1);

			}else if (vc.rdbtn_retiro.isSelected()) {
				Withdraw();
				System.out.println("HOla");
			}


		}
	}


	public void Fields() {
		if(flag) {
			JOptionPane.showMessageDialog(vc, "Cuenta encontrada");
			vc.txt_Cuenta.setText(String.valueOf(cuenta.getNum_cuenta()));
			vc.txt_tipo.setText(cuenta.getTipo());
			vc.txt_saldo.setText(String.valueOf(cuenta.getSaldo()));

		}else {
			JOptionPane.showMessageDialog(vc, "Cuenta no encontrada");
		}

	}
	public void Operations(int opc) {
		int valor=Integer.parseInt(vc.txt_valo.getText());
		int total = 0;

		if(opc==1) {
			if(flag && valor!=0 && valor>0) {
				int salnuevo=cuenta.getSaldo();
				total=salnuevo+valor;
				cuenta.setSaldo(total);
				JOptionPane.showMessageDialog(vc, "Saldo actualizado"+total);
				cdao.actualizar(total, Integer.parseInt(vc.txt_CEDULA.getText()));

			}else {
				JOptionPane.showMessageDialog(vc, "Monto de opración invalido");
			}


		}


	}
	public void Withdraw() {
		int valor=Integer.parseInt(vc.txt_valo.getText());
		int total = 0;
		if(flag && valor !=0 && valor >0) {
			int salnuevo=cuenta.getSaldo();
			if(valor<=salnuevo) {
				total=salnuevo-valor;
				cuenta.setSaldo(total);
				JOptionPane.showMessageDialog(vc, "Saldo actualizado"+total);
				cdao.actualizar(total, Integer.parseInt(vc.txt_CEDULA.getText()));
			}else {
				JOptionPane.showMessageDialog(vc, "Saldo No actualizado"+salnuevo);
			}

		}else {
			JOptionPane.showMessageDialog(vc, "Monto de opración invalido");
		}
	}
}
