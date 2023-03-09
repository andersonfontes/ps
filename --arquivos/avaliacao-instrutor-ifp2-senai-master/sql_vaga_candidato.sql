create database dbcandidatos2;
show databases;
use dbcandidatos2;
create table vaga (
	idvaga bigint primary key auto_increment,
    data VARCHAR(255),
    descricao VARCHAR(255),
    nome VARCHAR(255),
    salario decimal (19.2)
    );
    create table vaga (
	idvaga bigint primary key auto_increment,
    data VARCHAR(255),
    descricao VARCHAR(255),
    nome VARCHAR(255),
    salario decimal (19.2)
    );
create table candidato (
	idcandidato bigint primary key auto_increment,
    email VARCHAR(255),
    nome_candidato VARCHAR(255),
    rg VARCHAR(255),
    codvaga bigint,
    foreign key (codvaga) references vaga(idvaga)
    );
    insert into vaga(data,descricao,nome,salario)
    values('8/3/23','possuir conhecimentos em banco de dados','instrutor de tecnologia','2500.00');
    insert into candidato (email,nome_candidato,rg)
    values ('jose@couves.com','jose das couves','12.345.678-90');
    select * from candidato;
update candidato SET codvaga=1 where idcandidato=1;
select *from candidato;
alter table candidato 
drop column candidatocol;
