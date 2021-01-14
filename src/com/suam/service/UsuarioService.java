package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.suam.BD;
import com.suam.insert.*;

public class UsuarioService {

	public static void inserir(Contato contato) throws SQLException {
		Connection conexao = BD.getConnection();

		String sql = "INSERT INTO resul_pesq (nome,end,resultado) VALUES (?,?,?)";

		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEndereco());
			ps.setInt(3,contato.getResultado());
			
			ps.execute();
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// fechar a conexão
			conexao.close();
		}
	}
	
	public static List<Contato> consultar(String nome, String endereco, int resultado) throws SQLException {
		Connection conexao = BD.getConnection();
		List<Contato> listaUsuario = new ArrayList<Contato>();
		
		String sql = "SELECT nome,endereco,resultado,email FROM resul_pesquisa where nome=? and endereco=? and resultado=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, endereco);
			ps.setInt(3, resultado);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setNome("Nome");
				contato.setEndereco("Endereco");
				contato.setResultado(resultado);		
				listaUsuario.add(contato);
			}
			
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
		} finally {
			// fechar a conexão
			conexao.close();
		}
		
		return listaUsuario;
	}
	
	public static boolean autenticar(String nome, String endereco, int resultado) throws SQLException {
		
		List<Contato> listaUsuario = consultar("Nome","Endereco",resultado);
		
		if(!listaUsuario.isEmpty()){
			return true;
		} 
		
		else{
			return false;
		}
		
	}

}
