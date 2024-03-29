package Control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Musica;

public class CtlMusica {

	
	public void incluir(Musica m) throws Exception {
		String sql = "insert into musica (nome, autor, estilo, ano) values (?, ?, ?, ?)";
		PreparedStatement ps = Db.GetInstance().getConnection().prepareStatement(sql);
		
		ps.setString(1, m.getNome());
		ps.setString(2, m.getAutor());
		ps.setString(3, m.getEstilo());
		ps.setInt(4, m.getAno());
		
		ps.execute();
		
		sql = "select last_insert_id()";
		ps = Db.GetInstance().getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		m.setCodigo(rs.getInt(0));		
	}

	public void alterar(Musica m) throws SQLException {
		String sql = "update musica set nome = ?, autor = ?, estilo = ?, ano = ? where codigo = ?)";
		PreparedStatement ps = Db.GetInstance().getConnection().prepareStatement(sql);
		
		ps.setString(1, m.getNome());
		ps.setString(2, m.getAutor());
		ps.setString(3, m.getEstilo());
		ps.setInt(4, m.getAno());		
		ps.setInt(5, m.getCodigo());
		
		
	}
	
	public void excluir(int codigo) throws SQLException {
		String sql = "delete from musica where codigo = ?";
		PreparedStatement ps = Db.GetInstance().getConnection().prepareStatement(sql);
		
		ps.setInt(1, codigo);
		ps.execute();
	}

	public Musica getAnt(){
		return null;
	}
	
	public Musica getProx(){
		return null;
	}
	
	public Musica getAtual(){
		return null;
	}
	
	public boolean temAnt(){
		return null;
	}
	
	public boolean temProx(){
		return null;
	}
	
	public boolean temAtual(){
		return false;
	}
}
