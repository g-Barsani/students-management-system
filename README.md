# students-management-system
Created using Java Swing; an MVC desktop project.

CREATE TABLE tb_aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rgm VARCHAR(20),
    nome VARCHAR(100),
    data_nascimento VARCHAR(20),
    cpf VARCHAR(14),
    email VARCHAR(100),
    endereco VARCHAR(255),
    municipio VARCHAR(100),
    uf VARCHAR(2),
    celular VARCHAR(15),
    curso VARCHAR(100),
    campus VARCHAR(100),
    periodo VARCHAR(20),  
    disciplina VARCHAR(100),
    semestre VARCHAR(100),
    notas DECIMAL(5, 2),  
    faltas INT            
);
