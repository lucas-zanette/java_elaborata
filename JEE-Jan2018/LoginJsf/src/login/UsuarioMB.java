package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import control.BD_Gerenciado;

@ManagedBean
@SessionScoped
public class UsuarioMB {
	private int codigo;
	private String login;
	private String senha;	
	private List<Usuario> usuarios;
	private int paramCodigo;
	private String paramOperacao;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getParamCodigo() {
		return paramCodigo;
	}
	public void setParamCodigo(int paramCodigo) {
		this.paramCodigo = paramCodigo;
	}
	public String getParamOperacao() {
		return paramOperacao;
	}
	public void setParamOperacao(String paramOperacao) {
		this.paramOperacao = paramOperacao;
	}
	public List<Usuario> getUsuarios() {
		buscaUsuarios();
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String inserir(){

		Connection con = BD_Gerenciado.getConnection();

		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into usuario(login, senha) values(?, md5(?))");
			ps.setString(1, login);
			ps.setString(2, senha);					

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//buscaUsuarios();		
		return null;		
	}
	
	public void buscaUsuarios(){
		usuarios = new ArrayList<>();
		
		Connection con = BD_Gerenciado.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select codigo, login, senha from usuario");
			ResultSet rs = ps.executeQuery();

			while ( rs.next() ){
				Usuario u = new Usuario();
				u.setCodigo(rs.getInt(1));
				u.setLogin(rs.getString(2));
				u.setSenha(rs.getString(3));
				
				usuarios.add(u);
			}						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	public String alterar() {
		System.out.println("Alterar");

		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		
		paramCodigo = Integer.parseInt(params.get("paramCodigo"));
		paramOperacao = "alterar";
		
		return "pages/paginaTeste";		
	}

	public void excluir() {
		
	}
}