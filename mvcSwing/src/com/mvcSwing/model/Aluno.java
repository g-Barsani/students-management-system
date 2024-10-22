package com.mvcSwing.model;

import java.sql.Date;

public class Aluno {
	 private int id; // Correspondente ao 'id' na tabela
	    private String rgm;
	    private String nome;
	    private String dataNascimento;
	    private String cpf;
	    private String email;
	    private String endereco;
	    private String municipio;
	    private String uf;
	    private String celular;
	    private String curso;
	    private String campus;
	    private String periodo;
	    private String disciplina;
	    private String semestre;
	    private double notas; // Nota
	    private int faltas;   // Faltas

	    public Aluno() {
	    }

		public Aluno(int id, String rgm, String nome, String dataNascimento, String cpf, String email, String endereco,
				String municipio, String uf, String celular, String curso, String campus, String periodo, String disciplina,
				String semestre, double notas, int faltas) {
			super();
			this.id = id;
			this.rgm = rgm;
			this.nome = nome;
			this.dataNascimento = dataNascimento;
			this.cpf = cpf;
			this.email = email;
			this.endereco = endereco;
			this.municipio = municipio;
			this.uf = uf;
			this.celular = celular;
			this.curso = curso;
			this.campus = campus;
			this.periodo = periodo;
			this.semestre = semestre;
			this.notas = notas;
			this.faltas = faltas;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getRgm() {
			return rgm;
		}

		public void setRgm(String rgm) {
			this.rgm = rgm;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getMunicipio() {
			return municipio;
		}

		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public String getCelular() {
			return celular;
		}

		public void setCelular(String celular) {
			this.celular = celular;
		}

		public String getCurso() {
			return curso;
		}

		public void setCurso(String curso) {
			this.curso = curso;
		}

		public String getCampus() {
			return campus;
		}

		public void setCampus(String campus) {
			this.campus = campus;
		}

		public String getPeriodo() {
			return periodo;
		}

		public void setPeriodo(String periodo) {
			this.periodo = periodo;
		}
		
		public String getDisciplina() {
			return disciplina;
		}

		public void setDisciplina(String disciplina) {
			this.disciplina = disciplina;
		}

		public String getSemestre() {
			return semestre;
		}

		public void setSemestre(String semestre) {
			this.semestre = semestre;
		}

		public double getNotas() {
			return notas;
		}

		public void setNotas(double notas) {
			this.notas = notas;
		}

		public int getFaltas() {
			return faltas;
		}

		public void setFaltas(int faltas) {
			this.faltas = faltas;
		}

		

	    
}
