/*use Master;
Create DATABASE QCMJEE;*/

use QCMJEE;

if exists (select * from sysobjects where name='Question' and xtype='U')
DROP TABLE Question;
if exists (select * from sysobjects where name='Section' and xtype='U')
DROP TABLE Section;
if exists (select * from sysobjects where name='Theme' and xtype='U')
DROP TABLE Theme;

if exists (select * from sysobjects where name='Utilisateur' and xtype='U')
DROP TABLE Utilisateur;
if exists (select * from sysobjects where name='Profil' and xtype='U')
DROP TABLE Profil;
if exists (select * from sysobjects where name='Promotion' and xtype='U')
DROP TABLE Promotion;


if not exists (select * from sysobjects where name='Theme' and xtype='U')
create table Theme (
idTheme int primary key,
libelle varchar(MAX)
) 

if not exists (select * from sysobjects where name='Question' and xtype='U')
create table Question (
idQuestion int primary key,
idTheme int not null,
enonce varchar(MAX),
img image,
points int,
FOREIGN KEY (idTheme) REFERENCES Theme(idTheme)
)

if not exists (select * from sysobjects where name='Section' and xtype='U')
create table Section (
idSection int primary key,
nbQuestionAttendues int,
idTheme int not null,
FOREIGN KEY (idTheme) REFERENCES Theme(idTheme)
)

if not exists (select * from sysobjects where name='Profil' and xtype='U')
create table Profil (
idProfil int primary key,
codeProfil varchar(MAX),
libelle varchar(MAX)
)

if not exists (select * from sysobjects where name='Promotion' and xtype='U')
create table Promotion (
idPromotion int primary key,
codePromotion varchar(MAX),
libelle varchar(MAX)
)

if not exists (select * from sysobjects where name='Utilisateur' and xtype='U')
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