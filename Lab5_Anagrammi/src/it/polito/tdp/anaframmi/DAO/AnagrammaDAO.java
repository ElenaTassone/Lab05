package it.polito.tdp.anaframmi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.model.*;

public class AnagrammaDAO {

	
	public boolean isCorrect (String anagramma){
		
		final String sql = "SELECT nome FROM parola WHERE nome=?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
			
				String a = rs.getString("nome");
				if(a.equals(anagramma))
					return true;
			}
			
			conn.close() ;
			return false ;

			}
		
			catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
			}
		
		}
}
