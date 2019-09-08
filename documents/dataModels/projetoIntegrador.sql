/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------    Criando Usuário e suas Ligações     -----------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
CREATE TABLE PAIS (
    id int not null,
    nome varchar(80) not null
);

ALTER TABLE PAIS ADD CONSTRAINT PK_PAIS PRIMARY KEY (ID);

CREATE TABLE ESTADO (
    id int not null,
    fk_idPais int not null,
    nome varchar(80) not null
);

ALTER TABLE ESTADO ADD CONSTRAINT PK_ESTADO PRIMARY KEY (ID);
ALTER TABLE ESTADO ADD CONSTRAINT FK_PAIS_ESTADO FOREIGN KEY (fk_idPais) REFERENCES PAIS(id);

CREATE TABLE CIDADE (
    id int not null,
    nome varchar(80) not null,
    fk_idEstado int
);

ALTER TABLE CIDADE ADD CONSTRAINT PK_CIDADE PRIMARY KEY (ID);
ALTER TABLE CIDADE ADD CONSTRAINT FK_ESTADO_CIDADE FOREIGN KEY (fk_idEstado) REFERENCES ESTADO(id);

CREATE TABLE ENDERECO (
    id int not null,
    fk_idCidade int,
    rua varchar(150) not null,
    numero varchar(15),
    logradouro varchar(150),
    cep varchar(15),
    bairro varchar(150)
);

ALTER TABLE ENDERECO ADD CONSTRAINT PK_ENDERECO PRIMARY KEY (ID);
ALTER TABLE ENDERECO ADD CONSTRAINT FK_CIDADE_ENDERECO FOREIGN KEY (fk_idCidade) REFERENCES CIDADE(id);

CREATE TABLE USUARIO (
    id int not null,
    nome varchar(80) not null,
    data_nascimento date not null,
    data_criacao_conta date not null,
    cpf int,
    fk_idEndereco int not null
);

ALTER TABLE USUARIO ADD CONSTRAINT PK_USUARIO PRIMARY KEY (ID);
ALTER TABLE USUARIO ADD CONSTRAINT fk_idEndereco FOREIGN KEY (fk_idEndereco) REFERENCES ENDERECO(id);


/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------    Criando Campanha e personagens     ------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

CREATE TABLE CLASSE (
    id int not null,
    nome varchar(50) not null
);

ALTER TABLE CLASSE ADD CONSTRAINT PK_CLASSE PRIMARY KEY (ID);

CREATE TABLE BOSS (
    id int not null,
    nome varchar(50) not null,
    fk_idClasse int
);

ALTER TABLE BOSS ADD CONSTRAINT PK_BOSS PRIMARY KEY (ID);
ALTER TABLE BOSS ADD CONSTRAINT FK_CLASSE_BOSS FOREIGN KEY (fk_idClasse) REFERENCES CLASSE(id);

CREATE TABLE CAMPANHA ( 
    id int not null,
    historia_campanha varchar(3000) not null,
    tempo_estimado int not null,
    fk_idBoss int
);

ALTER TABLE CAMPANHA ADD CONSTRAINT PK_CAMPANHA PRIMARY KEY (ID);
ALTER TABLE CAMPANHA ADD CONSTRAINT FK_BOSS_CAMPANHA FOREIGN KEY (fk_idBoss) REFERENCES BOSS(id);

create table BOSS_CLASSE(
    id int not null,
    fk_idBoss int,
    fk_idClasse int
);

ALTER TABLE BOSS_CLASSE ADD CONSTRAINT PK_BOSS_CLASSE PRIMARY KEY (ID);
ALTER TABLE BOSS_CLASSE ADD CONSTRAINT FK_BOSS_BOSSCLASSE FOREIGN KEY (fk_idBoss) REFERENCES BOSS(id);
ALTER TABLE BOSS_CLASSE ADD CONSTRAINT FK_CLASSE_BOSSCLASSE FOREIGN KEY (fk_idClasse) REFERENCES CLASSE(id);


CREATE TABLE PERSONAGEM (
    id int not null,
    nome varchar(80) not null,
    historia varchar(3000),
    fk_idClasse int
);

ALTER TABLE PERSONAGEM ADD CONSTRAINT PK_PERSONAGEM PRIMARY KEY (ID);
ALTER TABLE PERSONAGEM ADD CONSTRAINT FK_CLASSE_PERSONAGEM FOREIGN KEY (fk_idClasse) REFERENCES CLASSE(id);

CREATE TABLE ATRIBUTO ( 
    id int not null,
    nome varchar(20) not null,
    valor int not null
);

ALTER TABLE ATRIBUTO ADD CONSTRAINT PK_ATRIBUTO PRIMARY KEY (ID);

create table Classe_Atributo(
    id int not null,
    fk_idClasse int not null,
    fk_idAtributo int not null
);

ALTER TABLE Classe_Atributo ADD CONSTRAINT PK_Classe_Atributo PRIMARY KEY (ID);
ALTER TABLE Classe_Atributo ADD CONSTRAINT FK_ATRIBUTO_Classe_Atributo FOREIGN KEY (fk_idAtributo) REFERENCES ATRIBUTO(id);
ALTER TABLE Classe_Atributo ADD CONSTRAINT FK_CLASSE_Classe_Atributo FOREIGN KEY (fk_idClasse) REFERENCES CLASSE(id);

CREATE TABLE CAMPANHA_PERSONAGEM (
    id int not null,
    fk_idCampanha int not null,
    fk_idPersonagem int not null
);

ALTER TABLE CAMPANHA_PERSONAGEM ADD CONSTRAINT PK_CAMPANHA_PERSONAGEM PRIMARY KEY (ID);
ALTER TABLE CAMPANHA_PERSONAGEM ADD CONSTRAINT FK_CAMPANHA_CAMPANHA_PERSONAGEM FOREIGN KEY (fk_idCampanha) REFERENCES CAMPANHA(id);
ALTER TABLE CAMPANHA_PERSONAGEM ADD CONSTRAINT FK_PERSONAGEM_CAMPANHA_PERSONAGEM FOREIGN KEY (fk_idPersonagem) REFERENCES PERSONAGEM(id);





