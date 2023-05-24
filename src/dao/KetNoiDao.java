package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoiDao {
	public Connection cn;

	public void KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection(
					"jdbc:sqlserver://LAPCN-GIANGTT\\SQLEXPRESS:1433;databaseName=WebTruyenTranh;user=sa; password=1");
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
	}
}
