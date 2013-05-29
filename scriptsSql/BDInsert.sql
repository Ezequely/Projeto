use dbPosGraduacao;

-- DELETE ALL
/*
delete from PESSOA_PUBLICACAO;
delete from PUBLICACAO;
delete from ALUNO_TURMA;
delete from TURMA_DOCENTE;
delete from TURMA;
delete from DISCIPLINA;
delete from LINHADEPESQUISA;
delete from ALUNO;
delete from DOCENTE;
delete from VINCULO;
delete from PESSOA;
*/



-- PESSOA
insert into PESSOA (CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone) values
 ('123456789', 'John B. Smith','Fondren, 731','Houston', 'TX', NULL, NULL, '1965-09-01', 'john@smith.com', '333445555');
insert into PESSOA (CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone) values 
 ('3334455555', 'Franklin T. Wong', 'Voss, 638','Natal', 'RN', 'natalense', 'brasileiro', '1955-12-08', 'wong@company.com.br', '2233445566');
insert into PESSOA (CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone) values 
 ('6767884444', 'Ramesh K. Narayan', 'Fire Oark, 975','Macaíba', 'RN', NULL, 'indiano', '1962-09-15', NULL, NULL);
insert into PESSOA (CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone) values 
 ('453453453', 'Joyce A. English', 'Rice, 5631','Natal', 'RN', 'natalense', 'brasileira', '1972-07-31', 'joyceenglish@bol.com.br', '77889021');


insert into PESSOA (Nome, CPF, DTNasc, Endereco, Cidade, UF, Telefone, Nacionalidade, E_mail) values
("Andy C. Vile","222222202","1944-06-21","1967 Jordan", "Milwaukee", "WI", "2222-2200", "estadunidense", "andy@vile.com"),
("Brad C. Knight","111111103","1968-02-13","176 Main St.", "Atlanta", "GA","1111-1100", "argentina", "brad@knight.com"),
("Evan E. Wallis","222222200","1958-01-16","134 Pelham", "Milwaukee", "WI","null","brasileira", "evan@ufrn.com.br"),
("Josh U. Zell","222222201","1954-05-22","266 McGrady", "Milwaukee", "WI","2222-2220", "colombiana", "josh@ufrn.com.br"),
("Jared D. James","111111100","1966-10-10","123 Peachtree", "Atlanta", "GA","null","brasileira", "jared@ufrn.com.br"),
("Justin n.Mark","111111102","1966-01-12","2342 May", "Atlanta", "GA","1121-1100","cubana", "justin@ufrn.com.br"),
("Jon C. Jones","111111101","1967-11-14","111 Allgood", "Atlanta", "GA","1111-1100","brasileira", "jon@ufrn.com.br"),
("John C James","555555500","1975-06-30","7676 Bloomington", "Sacramento", "CA","null","brasileira", "john@ufrn.com.br"),
("Alex D Freed","444444400","1950-10-09","4333 Pillsbury", "Milwaukee", "WI","null","brasileira", "alex@ufrn.com.br"),
("Ahmad V Jabbar","987987987","1959-03-29","980 Dallas", "Houston", "TX","8765-4321","estadunidense", "ahmad@ufrn.com.br"),
("Alicia J Zelaya","999887777","1958-07-19","3321 Castle", "Spring", "TX","9876-4321","brasileira", "alcia@ufrn.com.br");


-- VINCULOS (DOCENTES)
insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('11114', '123456789', 1, '2013-05-14', NULL); -- alterar codigo linha de pesquisa
insert into DOCENTE (Titulacao, Cargo, MatriculaDocente)
    values ('Doutorado', NULL, '11114');
insert into VINCULO (Matricula, CPF, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('22222', '3334455555', '1987-01-28', NULL); -- alterar codigo linha de pesquisa
insert into DOCENTE (Titulacao, Cargo, MatriculaDocente)
    values ('Doutorado', NULL, '22222');

insert into VINCULO (Matricula, CPF, DataDeMatricula, Ativo, CodigoLinhaDePesquisa) values
("197508","555555500","1975-06-30","1", "LP5"),
("201345","444444400","1950-10-09","1", "LP1"),
("161789","987987987","1959-03-29","0", "LP4"),
("2233445","999887777","1958-07-19","1", "LP2");


insert into DOCENTE (MatriculaDocente, Titulacao ) values
("197508","Doutorado"),
("201345","Doutorado"),
("161789","Mestrado"),
("2233445","Pos-doutorado");


-- -- -- -- -- -- -- -- -- VINCULO (ALUNOS) -- -- -- -- -- -- -- -- -- -- -- -- 
insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('2000123456', '123456789', 1, '2000-02-10', 'LP1'); -- alterar codigo linha de pesquisa
insert into ALUNO (Grau, MatriculaAluno, MatriculaOrientador)
    values ('Mestrado', '2000123456', '123456789');

insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('2011100908', '6767884444', 1, '2011-07-01', 'LP2'); -- alterar codigo linha de pesquisa
insert into ALUNO (Grau, MatriculaAluno, MatriculaOrientador)
    values ('Doutorado', '2011100908', '3334455555');

insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('2012090909', '453453453', 1, '2012-01-01', 'LP4'); -- alterar codigo linha de pesquisa
insert into ALUNO (Grau, MatriculaAluno, MatriculaOrientador)
    values ('Mestrado', '2012090909', '3334455555');

insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('1975123456', '3334455555',0, '1975-07-03', 'LP5'); -- alterar codigo linha de pesquisa
insert into ALUNO (Grau, MatriculaAluno, MatriculaOrientador)
    values ('Doutorado', '1975123456', '123456789');

insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa) values
("201012334","222222202","1","2010-20-02", 'LP7'),
("20097892","111111103","1","2009-11-11", 'LP1'),
("200912345","222222200","0","2009-16-04",'LP3'),
("20117766","222222201","1","2011-02-02", 'LP2'),
("20108877","111111100","0","2010-01-08",'LP1'),
("20129901","111111102","1","2012-01-11",'LP5'),
("201212345","111111101","1","2012-11-01",'LP3');


insert into ALUNO (MatriculaAluno, MatriculaOrientador, Grau) values
('201012334','201345','Mestrado'),
('20097892','11114','Mestrado'),
('200912345','197508','Mestrado'),
('20117766','22222','Doutorado'),
('20108877','161789','Doutorado'),
('20129901','22222','Mestrado'),
('201212345','2233445','Doutorado');

-- -- -- -- -- -- -- -- -- LINHAS DE PESQUISA -- -- -- -- -- -- -- -- -- -- -- -- 

insert into LINHADEPESQUISA values ('LP1','ALGORITMOS EXPERIMENTAIS','Texto');
insert into LINHADEPESQUISA values ('LP2','ENGENHARIA DE SOFTWARE','Texto');
insert into LINHADEPESQUISA values ('LP3','TEORIA DA COMPUTAÇÃO','Texto');
insert into LINHADEPESQUISA values ('LP4','SISTEMAS INTEGRADOS E DISTRIBUÍDOS','Texto');
insert into LINHADEPESQUISA values ('LP5','PROCESSAMENTO GRÁFICO E INTELIGÊNCIA COMPUTACIONAL','Texto');
insert into LINHADEPESQUISA values ('LP6','LINGUAGENS DE PROGRAMAÇÃO E MÉTODOS FORMAIS','Texto');

-- -- -- -- -- -- -- -- -- DISCIPLINAS -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

insert into DISCIPLINA values ('ALG E EST DE DADOS EM GRAFOS','DIM0860', '60', 'ementa', 'Ativa', 'LP1');
insert into DISCIPLINA values ('PROGRAMAÇÃO LINEAR','DIM0816', '60', 'ementa', 'Ativa', 'LP1');
insert into DISCIPLINA values ('SEMANTICA LING DE PROGRAMAÇÃO','DIM0889', '60', 'ementa', 'Ativa', 'LP6');
insert into DISCIPLINA values ('ESPECIFICAÇÕES FORMAIS','DIM0805', '60', 'ementa', 'Ativa', 'LP6');
insert into DISCIPLINA values ('INTELIGENCIA ARTIFICIAL','DIM0871', '60', 'ementa', 'Ativa', 'LP5');
insert into DISCIPLINA values ('SISTEMA MULTI-AGENTES','DIM0873', '60', 'ementa', 'Ativa', 'LP5');
insert into DISCIPLINA values ('TEORIA DA COMPUTAÇÃO','DIM0851', '60', 'ementa', 'Ativa', 'LP3');
insert into DISCIPLINA values ('SEMINÁRIOS EM TIC','DIM0875', '60', 'ementa', 'Ativa', 'LP3');
insert into DISCIPLINA values ('PROG CONCORRENTE E DISTRIBUÍDA','DIM0815', '60', 'ementa', 'Ativa', 'LP4');
insert into DISCIPLINA values ('TOP.GERENC REDES QUAL SERVICOS','DIM0868', '60', 'ementa', 'Ativa', 'LP4');
insert into DISCIPLINA values ('TESTE DE SOFTWARE','DIM0887', '60', 'ementa', 'Ativa', 'LP2');
insert into DISCIPLINA values ('ENGENHARIA DE SOFTWARE','DIM0804', '60', 'ementa', 'Ativa', 'LP2');

-- -- -- -- -- -- -- -- -- TURMAS -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

insert into TURMA (CodigoTurma, NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
        (1, 1, '2011.1', 'DIM0804', 'Consolidada', '24T1234',NULL);
insert into TURMA (CodigoTurma, NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(2, 1, '2013.1', 'DIM0851', 'Aberta', '246M12','3E4');
insert into TURMA (CodigoTurma, NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(3, 1, '2013.1', 'DIM0889', 'Aberta', '12M34 45T56','3H7');
insert into TURMA (CodigoTurma, NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(4, 1, '2013.1', 'DIM0860', 'Aberta', '246M12','3E2');
insert into TURMA (CodigoTurma, NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(5, 2, '2013.1', 'DIM0860', 'Aberta', '246T56','3E4');
insert into TURMA (CodigoTurma, NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(6, 1, '2012.2', 'DIM0871', 'Consolidada', '6T123456','3B2');
insert into TURMA (CodigoTurma, NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(7, 1, '2012.1', 'DIM0889', 'Consolidada', '12M34 45T56','3E3');
insert into TURMA (CodigoTurma, NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(8, 2, '2012.1', 'DIM0889', 'Consolidada', '246M12 6T56','3E4');
insert into TURMA (CodigoTurma, NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(9, 1, '2010.2', 'DIM0805', 'Consolidada', '35T34','3E2');

-- -- -- -- -- -- -- -- -- TURMA_DOCENTE -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

-- Insere John Smith como professor de todas as turmas de "SEMANTICA LING DE PROGRAMAÇÃO"
insert into TURMA_DOCENTE (CodigoTurma, MatriculaDocente) 
select T.CodigoTurma, D.MatriculaDocente from
		-- Relaciona cada turma de "SEMANTICA LING DE PROGRAMAÇÃO" c/ a matricula de John Smith
		(select CodigoTurma from 
			TURMA t join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina
			where Nome = "SEMANTICA LING DE PROGRAMAÇÃO"
		) as T
		join
		(select MatriculaDocente from 
			DOCENTE join VINCULO on MatriculaDocente = Matricula natural join PESSOA
			where Nome like 'John%Smith'
		) as D
;



-- -- -- -- -- -- -- -- -- ALUNO_TURMA -- -- -- -- -- -- -- -- -- -- -- -- 
insert into ALUNO_TURMA (CodigoTurma, MatriculaAluno, Nota1, Nota2, Nota3, Nota4, Situacao) values 
    (1, '2000123456',  8.5 ,7.7,8.9, NULL, 'APROVADO'),
    (2, '2000123456', 10.0 , 5.8, NULL,NULL, 'MATRICULADO'),
    (6, '2000123456', 5.5 ,8.8,7.5, NULL, 'APROVADO'),
    (8, '2000123456', 6.7 ,1.0,8.9, 9.1, 'APROVADO'),
    (3, '2000123456', 7.9 ,4.2,6.4, NULL, 'MATRICULADO'),

    (4, '2011100908',  8.3 ,6.7,NULL, NULL, 'MATRICULADO'),
    (6, '2011100908', 7.6 ,9.0,7.5, NULL, 'APROVADO'),
    (5, '2011100908', 9.0 ,NULL,NULL, NULL, 'MATRICULADO'),
    (8, '2011100908', 8.2 , 6.0, 5.9, 7.0, 'APROVADO'),
    (3, '2011100908',7.3 ,NULL,NULL, NULL, 'MATRICULADO'),
    (9, '2011100908', 8.8 , 5.7, 4.3, 6.8, 'APROVADO'),

    (1, '2012090909', 9.0 ,8.8,7.5, NULL, 'APROVADO'),
    (2, '2012090909', 3.0 ,5.0,NULL,NULL, 'TRANCADO'),
    (3, '2012090909', 7.1 ,7.2, 7.4, NULL, 'MATRICULADO'),
    (4, '2012090909',  4.3 ,6.5,NULL, NULL, 'TRANCADO'),
    (7, '2012090909', 7.1, 6.5 ,9.9, NULL, 'APROVADO'),
    (9, '2012090909', 9.0 ,3.6,10.0, NULL, 'APROVADO'),

    (1, '1975123456',8.9, 9.1, 10.0,NULL, 'APROVADO'),
    (6, '1975123456', 7.0 , 8.8, 7.1,NULL, 'APROVADO'),
    (7, '1975123456', 4.3 ,5.6,4.3, 3.0, 'REPROVADO'),
    (9, '1975123456', 9.0 ,7.8,8.5, NULL, 'APROVADO'),

    (3, '201012334', 6.6 , 7.0,NULL, NULL, 'MATRICULADO'),
    (5, '201012334', 6.0 , NULL,NULL, NULL, 'MATRICULADO'),
    (6, '201012334', 3.2 , 6.0, 4.5, 3.0, 'REPROVADO'),
    (8, '201012334', 9.0 , 8.0, 7.9, NULL, 'APROVADO'),
    (9, '201012334', 6.8 , 7.7, 9.3, NULL, 'APROVADO'),

    (1, '20097892', 1.0, 7.8, 7.5, 8.0, 'APROVADO'),
    (2, '20097892', 3.5, 5.5, NULL,NULL, 'TRANCADO'),
    (3, '20097892', 8.2, 6.2, 7.4, NULL, 'MATRICULADO'),
    (4, '20097892', 4.3, 7.7, NULL, NULL, 'MATRICULADO'),
    (7, '20097892', 8.1, 6.5, 7.2, NULL, 'APROVADO'),

    (8, '200912345', 7.2 , 6.0, 5.9, 7.0, 'APROVADO'),
    (9, '200912345', 7.8 , 5.7, 4.3, 6.8, 'APROVADO'),

    (3, '20117766', 3.0 ,5.0,NULL,NULL, 'MATRICULADO'),
    (4, '20117766', 7.1 ,7.2, 7.4, NULL, 'MATRICULADO'),
    (5, '20117766',  4.3 ,6.5,NULL, NULL, 'MATRICULADO'),
    (9, '20117766', 9.0 ,8.8,7.5, NULL, 'APROVADO'),

    (3, '20108877', 8.2, 9.2, 7.9, NULL, 'APROVADO'),
    (8, '20108877', 4.0, 6.8, 6.7, 7.0, 'APROVADO'),

    (2, '20129901', 7.6, 8.6, NULL,NULL, 'MATRICULADO'),
    (5, '20129901', 7.4 ,NULL,NULL, NULL, 'MATRICULADO'),
    (7, '20129901', 7.4, 7.5, 8.6, NULL, 'APROVADO'),

    (1, '201212345', 1.0, 7.8, 7.5, 8.0, 'APROVADO'),
    (2, '201212345', 3.5, 5.5, NULL,NULL, 'TRANCADO'),
    (3, '201212345', 8.2, 6.2, 7.4, NULL, 'MATRICULADO'),
    (5, '201212345', 6.4 ,NULL,NULL, NULL, 'MATRICULADO'),
    (6, '201212345', 3.2 , 6.0, 4.5, 3.0, 'REPROVADO'),
    (7, '201212345', 8.1, 6.5, 7.2, NULL, 'APROVADO'),
    (9, '201212345', 6.8 , 7.7, 9.3, NULL, 'APROVADO');



-- -- -- -- -- -- -- -- -- PUBLICACAO -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
insert into PUBLICACAO (Titulo, Tema, Periodico, Data, Tipo, ISSN, Resumo, URL)
	values("Aplicando Bancos de dados na vida real", "Bancos de Dados", 
			"Revista de Bancos", '2001-01-01', "Artigo", "0077-5533", NULL, NULL);
insert into PUBLICACAO (Titulo, Tema, Periodico, Data, Tipo, ISSN, Resumo, URL)
	values("Banco de dados hardcore", "Bancos de Dados", 
			NULL, '2006-06-06', "Livro", "0006-6006", "Resumo", "http://www.editora.com/livros/0006_6006");
insert into PUBLICACAO (Titulo, Tema, Periodico, Data, Tipo, ISSN, Resumo, URL)
	values("Introdução a compiladores", "Compiladores", 
			NULL, '2013-12-12', "Livro", "1234-5678", "Esse é um resumo muito longo...", 
			"http://www.editora.com/livros/Intro_a_compiladores");
insert into PUBLICACAO (Titulo, Tema, Periodico, Data, Tipo, ISSN, Resumo, URL)
	values("Investigando a semantica das linguagens de montagem", "Linguagens de programação", 
			"ACM unknown journal", '2013-09-28', "Artigo", "9993-8883", "Este não tem resumo", "http://www.john.smith.com/sem_ling_mont.pdf");

-- -- -- -- -- -- -- -- -- PESSOA_PUBLICACAO -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
INSERT INTO PESSOA_PUBLICACAO (CPF, ISSN) VALUES ('123456789', '9993-8883');
INSERT INTO PESSOA_PUBLICACAO (CPF, ISSN) VALUES ('123456789', '1234-5678');
INSERT INTO PESSOA_PUBLICACAO (CPF, ISSN) VALUES ('3334455555', '0077-5533');
INSERT INTO PESSOA_PUBLICACAO (CPF, ISSN) VALUES ('3334455555', '0006-6006');
INSERT INTO PESSOA_PUBLICACAO (CPF, ISSN) VALUES ('6767884444', '0006-6006');
INSERT INTO PESSOA_PUBLICACAO (CPF, ISSN) VALUES ('453453453', '0006-6006');

