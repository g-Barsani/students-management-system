package com.mvcSwing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mvcSwing.model.Aluno;
import com.mvcSwing.util.ConnectionFactory;

public class AlunoDAO {

    private Connection conn;
    private PreparedStatement ps;

    public AlunoDAO() throws Exception {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
    
    public void alterar(Aluno aluno) throws Exception {
        String sql = "UPDATE tb_aluno SET nome = ?, data_nascimento = ?, cpf = ?, email = ?, endereco = ?, municipio = ?, uf = ?, celular = ?, curso = ?, campus = ?, periodo = ?, disciplina = ?, semestre = ?, notas = ?, faltas = ? WHERE rgm = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getDataNascimento());
            ps.setString(3, aluno.getCpf());
            ps.setString(4, aluno.getEmail());
            ps.setString(5, aluno.getEndereco());
            ps.setString(6, aluno.getMunicipio());
            ps.setString(7, aluno.getUf());
            ps.setString(8, aluno.getCelular());
            ps.setString(9, aluno.getCurso());
            ps.setString(10, aluno.getCampus());
            ps.setString(11, aluno.getPeriodo());
            ps.setString(12, aluno.getDisciplina());
            ps.setString(13, aluno.getSemestre());
            ps.setDouble(14, aluno.getNotas());
            ps.setInt(15, aluno.getFaltas());
            ps.setString(16, aluno.getRgm()); // Set the RGM for the WHERE clause

            int rowsAffected = ps.executeUpdate(); // Get the number of affected rows
            
            if (rowsAffected == 0) {
                throw new Exception("RGM não encontrado, nenhuma alteração foi realizada."); // Throw an exception if no rows were updated
            }
        } catch (Exception e) {
            throw new Exception("Erro ao alterar: " + e.getMessage());
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    
    public void deletarPorRgm(String rgm) throws Exception {
        String sql = "DELETE FROM tb_aluno WHERE rgm = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rgm);
            
            int rowsAffected = stmt.executeUpdate(); // Execute the delete
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado com o RGM fornecido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            throw new Exception("Erro ao deletar aluno: " + e.getMessage());
        } finally {
            if (conn != null) conn.close(); // Close the connection
        }
    }

    
    public Aluno consultarPorRgm(String rgm) throws Exception {
        String sql = "SELECT * FROM tb_aluno WHERE rgm = ?";
        Aluno aluno = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rgm);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Preenchendo o objeto Aluno com os dados do banco
                    aluno = new Aluno();
                    aluno.setId(rs.getInt("id"));
                    aluno.setRgm(rs.getString("rgm"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setDataNascimento(rs.getString("data_nascimento"));
                    aluno.setCpf(rs.getString("cpf"));
                    aluno.setEmail(rs.getString("email"));
                    aluno.setEndereco(rs.getString("endereco"));
                    aluno.setMunicipio(rs.getString("municipio"));
                    aluno.setUf(rs.getString("uf"));
                    aluno.setCelular(rs.getString("celular"));
                    aluno.setCurso(rs.getString("curso"));
                    aluno.setCampus(rs.getString("campus"));
                    aluno.setPeriodo(rs.getString("periodo"));
                    aluno.setDisciplina(rs.getString("disciplina"));
                    aluno.setSemestre(rs.getString("semestre"));
                    aluno.setNotas(rs.getDouble("notas"));
                    aluno.setFaltas(rs.getInt("faltas"));
                } else {
                    // Se não encontrar, retorna null
                	JOptionPane.showMessageDialog(null, "Aluno não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao consultar: " + e.getMessage());
        }

        return aluno; // Retorna o aluno encontrado
    }

    
    public boolean verificarRgm(String rgm) {
        String sql = "SELECT COUNT(*) FROM tb_aluno WHERE rgm = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rgm);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Se maior que 0, RGM já cadastrado
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Lide com a exceção (ex: log)
        }
        return false; // Se houver erro ou não encontrado
    }

    public void salvar(Aluno aluno) throws Exception {
        String sql = "INSERT INTO tb_aluno (rgm, nome, data_nascimento, cpf, email, endereco, municipio, uf, celular, curso, campus, periodo, disciplina, semestre, notas, faltas) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getRgm());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getDataNascimento()); 
            ps.setString(4, aluno.getCpf());
            ps.setString(5, aluno.getEmail());
            ps.setString(6, aluno.getEndereco());
            ps.setString(7, aluno.getMunicipio());
            ps.setString(8, aluno.getUf());
            ps.setString(9, aluno.getCelular());
            ps.setString(10, aluno.getCurso());
            ps.setString(11, aluno.getCampus());
            ps.setString(12, aluno.getPeriodo());
            
            ps.setString(13, aluno.getDisciplina());
            
            ps.setString(14, aluno.getSemestre());
            ps.setDouble(15, aluno.getNotas());
            ps.setInt(16, aluno.getFaltas());

            ps.executeUpdate(); // Executa a inserção
        } catch (Exception e) {
            throw new Exception("Erro ao salvar: " + e.getMessage());
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }
    
    
    
}
