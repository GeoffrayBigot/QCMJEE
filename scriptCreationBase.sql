/*use Master;
Create DATABASE QCMJEE;*/

use QCMJEE;

if exists (select * from sysobjects where name='QuestionEpreuve' and xtype='U')
DROP TABLE QuestionEpreuve;
if exists (select * from sysobjects where name='Proposition' and xtype='U')
DROP TABLE Proposition;
if exists (select * from sysobjects where name='Question' and xtype='U')
DROP TABLE Question;
if exists (select * from sysobjects where name='Section' and xtype='U')
DROP TABLE Section;
if exists (select * from sysobjects where name='Theme' and xtype='U')
DROP TABLE Theme;
if exists (select * from sysobjects where name='Epreuve' and xtype='U')
DROP TABLE Epreuve;
if exists (select * from sysobjects where name='Test' and xtype='U')
DROP TABLE Test;
if exists (select * from sysobjects where name='Utilisateur' and xtype='U')
DROP TABLE Utilisateur;
if exists (select * from sysobjects where name='Profil' and xtype='U')
DROP TABLE Profil;
if exists (select * from sysobjects where name='Promotion' and xtype='U')
DROP TABLE Promotion;


/*
creation des Questions, des reponses, du thème et de la section
*/

create table Theme (
idTheme int primary key,
libelle varchar(MAX)
) 

create table Question (
idQuestion int primary key,
idTheme int not null,
enonce varchar(MAX),
img image,
points int,
FOREIGN KEY (idTheme) REFERENCES Theme(idTheme)
)

create table Proposition (
idProposition int primary key,
libelle varchar(max),
estCorrecte binary,
idQuestion int not null,
FOREIGN KEY (idQuestion) REFERENCES Question(idQuestion)
)

create table QuestionEpreuve(
idQuestionEpreuve int primary key,
marquee binary default 0,
idQuestion int not null,
FOREIGN KEY (idQuestion) REFERENCES Question(idQuestion)
)

/*
creation du Profil, de la promotion ainsi que de l'utilisateur.
*/

create table Profil (
idProfil int primary key,
codeProfil varchar(MAX),
libelle varchar(MAX)
)

create table Promotion (
idPromotion int primary key,
codePromotion varchar(MAX),
libelle varchar(MAX)
)

create table Utilisateur (
idUser int primary key,
nom varchar(MAX) not null,
prenom varchar(MAX) not null,
email varchar(MAX) not null,
password varchar(MAX) not null,
idProfil int not null,
idPromotion int not null,
FOREIGN KEY (idProfil) REFERENCES Profil(idProfil),
FOREIGN KEY (idPromotion) REFERENCES Promotion(idPromotion)
)

/* Création d'un test */
create table Test (
idTest int primary key,
nom varchar(MAX),
description varchar(MAX),
durée int,
seuilHaut int check (seuilHaut >= 0 ),
seuilBas int check (seuilBas >= 0) ,
)

create table Section (
idSection int primary key,
nbQuestionAttendues int,
idTheme int not null,
idTest int not null,
FOREIGN KEY (idTheme) REFERENCES Theme(idTheme),
FOREIGN KEY (idTest) REFERENCES Test(idTest)
)

create table Epreuve (
idEpreuve int primary key ,
debutValidite DateTime,
finValidite DateTime,
tempsEcoule integer,
etatEpreuve integer,
note int check (note >= 0 and note <= 20 ) ,
niveauAquisition varchar(MAX),
idUser int not null,
idTest int not null,
FOREIGN KEY (idUser) REFERENCES Utilisateur(idUser),
FOREIGN KEY (idTest) REFERENCES Test(idTest)
)