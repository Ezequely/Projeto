use dbPosGraduacao;

-- PESSOA
insert into PESSOA (CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone) values
 ('123456789', 'John B. Smith','Fondren, 731','Houston', 'TX', NULL, NULL, '1965-09-01', 'john@smith.com', '333445555');
insert into PESSOA (CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone) values 
 ('3334455555', 'Franklin T. Wong', 'Voss, 638','Natal', 'RN', 'natalense', 'brasileiro', '1955-12-08', 'wong@company.com.br', '2233445566');
insert into PESSOA (CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone) values 
 ('6767884444', 'Ramesh K. Narayan', 'Fire Oark, 975','Macaíba', 'RN', NULL, 'indiano', '1962-09-15', NULL, NULL);
insert into PESSOA (CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone) values 
 ('453453453', 'Joyce A. English', 'Rice, 5631','Natal', 'RN', 'natalense', 'brasileira', '1972-07-31', 'joyceenglish@bol.com.br', '77889021');

-- VINCULOS (DOCENTES)
insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('11114', '123456789', 1, '2013-05-14', NULL); -- alterar codigo linha de pesquisa
insert into DOCENTE (Titulacao, Cargo, MatriculaDocente)
    values ('Doutorado', NULL, '11114');
insert into VINCULO (Matricula, CPF, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('22222', '3334455555', '1987-01-28', NULL); -- alterar codigo linha de pesquisa
insert into DOCENTE (Titulacao, Cargo, MatriculaDocente)
    values ('Doutorado', NULL, '22222');


-- -- -- -- -- -- -- -- -- VINCULO (ALUNOS) -- -- -- -- -- -- -- -- -- -- -- -- 
insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('2000123456', '123456789', 1, '2000-02-10', NULL); -- alterar codigo linha de pesquisa
insert into ALUNO (Grau, MatriculaAluno, MatriculaOrientador)
    values ('Mestrado', '2000123456', '123456789');

insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('2011100908', '6767884444', 1, '2011-07-01', NULL); -- alterar codigo linha de pesquisa
insert into ALUNO (Grau, MatriculaAluno, MatriculaOrientador)
    values ('Doutorado', '2011100908', '3334455555');

insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('2012090909', '453453453', 1, '2012-01-01', NULL); -- alterar codigo linha de pesquisa
insert into ALUNO (Grau, MatriculaAluno, MatriculaOrientador)
    values ('Mestrado', '2012090909', '3334455555');

insert into VINCULO (Matricula, CPF, Ativo, DataDeMatricula, CodigoLinhaDePesquisa)
    values ('1975123456', '3334455555',0, '1975-07-03', NULL); -- alterar codigo linha de pesquisa
insert into ALUNO (Grau, MatriculaAluno, MatriculaOrientador)
    values ('Doutorado', '1975123456', '123456789');

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

insert into TURMA (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
    (1, '2011.1', 'DIM0804', 'Consolidada', '24T1234',NULL);
insert into TURMA (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(1, '2013.1', 'DIM0851', 'Aberta', '246M12','3E4');
insert into TURMA (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(1, '2013.1', 'DIM0889', 'Aberta', '12M34 45T56','3H7');
insert into TURMA (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(1, '2013.1', 'DIM0860', 'Aberta', '246M12','3E2');
insert into TURMA (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(2, '2013.1', 'DIM0860', 'Aberta', '246T56','3E4');
insert into TURMA (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(1, '2012.2', 'DIM0871', 'Consolidada', '6T123456','3B2');
insert into TURMA (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(1, '2012.1', 'DIM0889', 'Consolidada', '12M34 45T56','3E3');
insert into TURMA (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(2, '2012.1', 'DIM0889', 'Consolidada', '246M12 6T56','3E4');
insert into TURMA (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) values 
	(1, '2010.2', 'DIM0805', 'Consolidada', '35T34','3E2');


