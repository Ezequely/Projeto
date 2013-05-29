SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS dbPosGraduacao;

CREATE SCHEMA dbPosGraduacao;

USE dbPosGraduacao;

-- -----------------------------------------------------
-- PESSOA
-- -----------------------------------------------------
DROP TABLE IF EXISTS PESSOA ;

CREATE  TABLE IF NOT EXISTS PESSOA (
  CPF VARCHAR(11) NOT NULL ,
  Nome VARCHAR(50) NULL DEFAULT NULL ,
  Endereco VARCHAR(50) NULL DEFAULT NULL ,
  Cidade VARCHAR(25) NULL DEFAULT NULL ,
  UF CHAR(2) NULL DEFAULT NULL ,
  Naturalidade VARCHAR(30) NULL DEFAULT NULL ,
  Nacionalidade VARCHAR(30) NULL DEFAULT NULL ,
  DTNasc DATE NULL DEFAULT NULL ,
  E_mail VARCHAR(30) NULL DEFAULT NULL ,
  Telefone VARCHAR(11) NULL DEFAULT NULL ,
  PRIMARY KEY (CPF) 
)
ENGINE = InnoDB, -- necessario para permitir foreign keys
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- LINHADEPESQUISA
-- -----------------------------------------------------
DROP TABLE IF EXISTS LINHADEPESQUISA ;

CREATE  TABLE IF NOT EXISTS LINHADEPESQUISA (
  CodigoLinhaDePesquisa VARCHAR(11) NOT NULL ,
  Tema VARCHAR(50) NULL DEFAULT NULL ,
  Descricao TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (CodigoLinhaDePesquisa) 
)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- VINCULO
-- -----------------------------------------------------
DROP TABLE IF EXISTS VINCULO ;

CREATE  TABLE IF NOT EXISTS VINCULO (
  Matricula VARCHAR(11) NOT NULL ,
  CPF VARCHAR(11) NOT NULL ,
  Ativo TINYINT(1) NULL DEFAULT 1 ,
  DataDeMatricula DATE NULL DEFAULT NULL ,
  CodigoLinhaDePesquisa VARCHAR(11) NULL ,
  PRIMARY KEY (Matricula) ,
  CONSTRAINT vinculo_pessoa_fk
    FOREIGN KEY (CPF )
    REFERENCES PESSOA (CPF )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT vinculo_linhadepesquisa_fk
    FOREIGN KEY (CodigoLinhaDePesquisa )
    REFERENCES LINHADEPESQUISA (CodigoLinhaDePesquisa )
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- DOCENTE
-- -----------------------------------------------------
DROP TABLE IF EXISTS DOCENTE ;

CREATE  TABLE IF NOT EXISTS DOCENTE (
  Titulacao VARCHAR(18) NULL DEFAULT NULL ,
  Cargo VARCHAR(25) NULL DEFAULT NULL ,
  MatriculaDocente VARCHAR(11) NOT NULL ,
  PRIMARY KEY (MatriculaDocente) ,
  CONSTRAINT docente_vinculo_fk
    FOREIGN KEY (MatriculaDocente )
    REFERENCES VINCULO (Matricula )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- ALUNO
-- -----------------------------------------------------
DROP TABLE IF EXISTS ALUNO ;

CREATE  TABLE IF NOT EXISTS ALUNO (
  Grau VARCHAR(25) NULL DEFAULT NULL ,
  MatriculaAluno VARCHAR(11) NOT NULL ,
  MatriculaOrientador VARCHAR(11) NULL ,
  PRIMARY KEY (MatriculaAluno) ,
  INDEX R_55 (MatriculaOrientador ASC) ,
  CONSTRAINT aluno_docente_fk
    FOREIGN KEY (MatriculaOrientador )
    REFERENCES DOCENTE (MatriculaDocente )
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT aluno_vinculo_fk
    FOREIGN KEY (MatriculaAluno )
    REFERENCES VINCULO (Matricula )
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- DISCIPLINA
-- -----------------------------------------------------
DROP TABLE IF EXISTS DISCIPLINA ;

CREATE  TABLE IF NOT EXISTS DISCIPLINA (
  Nome VARCHAR(100) NULL DEFAULT NULL ,
  CodigoDisciplina VARCHAR(18) NOT NULL ,
  CargaHoraria VARCHAR(18) NULL DEFAULT NULL ,
  Ementa TEXT NULL DEFAULT NULL ,
  Status VARCHAR(18) NULL DEFAULT NULL ,
  CodigoLinhaDePesquisa VARCHAR(18) NULL DEFAULT NULL ,
  PRIMARY KEY (CodigoDisciplina) ,
  INDEX R_12 (CodigoLinhaDePesquisa ASC) ,
  CONSTRAINT disciplina_linhadepesquisa_fk
    FOREIGN KEY (CodigoLinhaDePesquisa )
    REFERENCES LINHADEPESQUISA (CodigoLinhaDePesquisa )
    ON DELETE SET NULL
    ON UPDATE CASCADE
)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- TURMA
-- -----------------------------------------------------
DROP TABLE IF EXISTS TURMA ;

CREATE  TABLE IF NOT EXISTS TURMA (
--  CodigoTurma VARCHAR(18) NOT NULL , -- modificado para inteiro
  CodigoTurma INT NOT NULL AUTO_INCREMENT, -- identificador unico da turma
  NumeroTurma INT NOT NULL, -- numero crescente para turmas de uma mesma disciplina em um periodo letivo
  PeriodoLetivo VARCHAR(25) NULL DEFAULT NULL ,
  CodigoDisciplina VARCHAR(18) NOT NULL ,
  Status VARCHAR(25) NULL DEFAULT NULL ,
  CodHorarioDeAula VARCHAR(25) NULL DEFAULT NULL ,
  LocalDeAula VARCHAR(25) NULL DEFAULT NULL ,
  PRIMARY KEY (CodigoTurma) ,
  INDEX R_7 (CodigoDisciplina ASC) ,
  CONSTRAINT turma_disciplina_fk
    FOREIGN KEY (CodigoDisciplina )
    REFERENCES DISCIPLINA (CodigoDisciplina )
)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- ALUNO_TURMA
-- -----------------------------------------------------
DROP TABLE IF EXISTS ALUNO_TURMA ;

CREATE  TABLE IF NOT EXISTS ALUNO_TURMA (
  CodigoTurma INT NOT NULL ,
  MatriculaAluno VARCHAR(11) NOT NULL ,
  Nota1 DOUBLE NULL, 
  Nota2 DOUBLE NULL, 
  Nota3 DOUBLE NULL, 
  Nota4 DOUBLE NULL,
  Situacao VARCHAR(30) NOT NULL, -- MATRICULADO, APROVADO, REPROVADO, TRANCADO
  PRIMARY KEY (CodigoTurma, MatriculaAluno) ,
  INDEX R_15 (MatriculaAluno ASC),
  CONSTRAINT alunoturma_aluno_fk
    FOREIGN KEY (MatriculaAluno)
    REFERENCES ALUNO (MatriculaAluno ),
  CONSTRAINT alunoturma_turma_fk
    FOREIGN KEY (CodigoTurma)
    REFERENCES TURMA (CodigoTurma )

)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- BANCAEXAMINADORA
-- -----------------------------------------------------
DROP TABLE IF EXISTS BANCAEXAMINADORA ;

CREATE  TABLE IF NOT EXISTS BANCAEXAMINADORA (
  CodigoBanca INT(11) NOT NULL ,
  DataDeDefesa DATE NULL DEFAULT NULL ,
  ISSN_Dissertacao INT(11) NOT NULL ,
  MatriculaAluno VARCHAR(11) NOT NULL ,
  PRIMARY KEY (CodigoBanca) ,
  INDEX R_27 (MatriculaAluno ASC) ,
  CONSTRAINT bancaexaminadora_aluno_fk
    FOREIGN KEY (MatriculaAluno )
    REFERENCES ALUNO (MatriculaAluno )
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- EXAMINADOR
-- -----------------------------------------------------
DROP TABLE IF EXISTS EXAMINADOR ;

CREATE  TABLE IF NOT EXISTS EXAMINADOR (
  Nota MEDIUMINT(9) NULL DEFAULT NULL ,
  CodigoBanca INT(11) NOT NULL ,
  MatriculaDocente VARCHAR(11) NOT NULL ,
  PRIMARY KEY (CodigoBanca, MatriculaDocente) ,
  INDEX R_24 (MatriculaDocente ASC) ,
  CONSTRAINT examinador_docente_fk
    FOREIGN KEY (MatriculaDocente )
    REFERENCES DOCENTE (MatriculaDocente )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT examinador_banca_fk
    FOREIGN KEY (CodigoBanca )
    REFERENCES BANCAEXAMINADORA (CodigoBanca )
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- PUBLICACAO
-- -----------------------------------------------------
DROP TABLE IF EXISTS PUBLICACAO ;

CREATE  TABLE IF NOT EXISTS PUBLICACAO (
  Titulo VARCHAR(100) NULL DEFAULT NULL ,
  Tema VARCHAR(100) NULL DEFAULT NULL ,
  Periodico VARCHAR(50) NULL DEFAULT NULL ,
  Data DATE NULL DEFAULT NULL ,
  Tipo VARCHAR(30) NULL DEFAULT NULL ,
  ISSN VARCHAR(11) NOT NULL ,
  Resumo TEXT NULL DEFAULT NULL ,
  URL VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (ISSN) 
)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- PESSOA_PUBLICACAO
-- -----------------------------------------------------
DROP TABLE IF EXISTS PESSOA_PUBLICACAO ;

CREATE  TABLE IF NOT EXISTS PESSOA_PUBLICACAO (
  CPF VARCHAR(11) NOT NULL ,
  ISSN VARCHAR(11) NOT NULL ,
  PRIMARY KEY (CPF, ISSN) ,
  INDEX R_53 (ISSN ASC) ,
  CONSTRAINT pessoapublicacao_publicacao_fk
    FOREIGN KEY (ISSN )
    REFERENCES PUBLICACAO (ISSN )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT pessoapublicacao_pessoa_fk
    FOREIGN KEY (CPF )
    REFERENCES PESSOA (CPF )
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- TURMA_DOCENTE
-- -----------------------------------------------------
DROP TABLE IF EXISTS TURMA_DOCENTE ;

CREATE  TABLE IF NOT EXISTS TURMA_DOCENTE (
  CodigoTurma INT NOT NULL ,
  MatriculaDocente VARCHAR(11) NOT NULL ,
  PRIMARY KEY (CodigoTurma, MatriculaDocente) ,
  INDEX R_15 (MatriculaDocente ASC),
  CONSTRAINT turmadocente_turma_fk
    FOREIGN KEY (CodigoTurma)
    REFERENCES TURMA (CodigoTurma)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT turmadocente_docente_fk
    FOREIGN KEY (MatriculaDocente)
    REFERENCES DOCENTE (MatriculaDocente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB,
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;