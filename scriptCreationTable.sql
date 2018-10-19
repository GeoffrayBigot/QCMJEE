USE QCMJEE;
GO

-- Généré par Oracle SQL Developer Data Modeler 4.0.2.840
--   à :        2017-12-07 11:44:43 CET
--   site :      SQL Server 2008
--   type :      SQL Server 2008

CREATE
  TABLE EPREUVE
  (
    idEpreuve         INTEGER NOT NULL IDENTITY,
    dateDedutValidite DATETIME NOT NULL ,
    dateFinValidite   DATETIME NOT NULL ,
    tempsEcoule       INTEGER ,
    etat              CHAR (2) NOT NULL ,
    note_obtenue FLOAT ,
    niveau_obtenu CHAR (3) ,
    idTest        INTEGER NOT NULL ,
    idUtilisateur INTEGER NOT NULL ,
    CONSTRAINT EPREUVE_PK PRIMARY KEY CLUSTERED (idEpreuve)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO
ALTER TABLE EPREUVE
ADD
CHECK ( niveau_obtenu IN ('A', 'ECA', 'NA') )
GO

CREATE
  TABLE PROFIL
  (
    codeProfil INTEGER NOT NULL,
    libelle    VARCHAR (100) NOT NULL ,
    CONSTRAINT PROFIL_PK PRIMARY KEY CLUSTERED (codeProfil)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE PROMOTION
  (
    codePromo CHAR (8) NOT NULL ,
    Libelle   VARCHAR (200) NOT NULL ,
    CONSTRAINT PROMOTION_PK PRIMARY KEY CLUSTERED (codePromo)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE PROPOSITION
  (
    idProposition INTEGER NOT NULL IDENTITY,
    enonce        VARCHAR (500) NOT NULL ,
    estBonne BIT NOT NULL ,
    idQuestion INTEGER NOT NULL ,
    CONSTRAINT PROPOSITION_PK PRIMARY KEY CLUSTERED (idProposition, idQuestion)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE QUESTION
  (
    idQuestion INTEGER NOT NULL IDENTITY,
    enonce     VARCHAR (500) NOT NULL ,
    media VARBINARY ,
    points  INTEGER NOT NULL ,
    idTheme INTEGER NOT NULL ,
    CONSTRAINT QUESTION_PK PRIMARY KEY CLUSTERED (idQuestion)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE QUESTION_TIRAGE
  (
    estMarquee BIT NOT NULL ,
    idQuestion INTEGER NOT NULL ,
    numordre   INTEGER NOT NULL ,
    idEpreuve  INTEGER NOT NULL ,
    CONSTRAINT QUESTION_TIRAGE_PK PRIMARY KEY CLUSTERED (idQuestion, idEpreuve)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE REPONSE_TIRAGE
  (
    idProposition INTEGER NOT NULL ,
    idQuestion    INTEGER NOT NULL ,
    idEpreuve     INTEGER NOT NULL ,
    CONSTRAINT REPONSE_TIRAGE_PK PRIMARY KEY CLUSTERED (idQuestion, idEpreuve,
    idProposition)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE SECTION_TEST
  (
    nbQuestionsATirer INTEGER NOT NULL ,
    idTest            INTEGER NOT NULL ,
    idTheme           INTEGER NOT NULL ,
    CONSTRAINT SECTION_TEST_PK PRIMARY KEY CLUSTERED (idTest, idTheme)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE TEST
  (
    idTest      INTEGER NOT NULL IDENTITY,
    libelle     VARCHAR (100) NOT NULL ,
    description VARCHAR (200) NOT NULL ,
    duree       INTEGER NOT NULL ,
    seuil_haut  INTEGER NOT NULL ,
    seuil_bas   INTEGER NOT NULL ,
    CONSTRAINT TEST_PK PRIMARY KEY CLUSTERED (idTest)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE THEME
  (
    idTheme INTEGER NOT NULL IDENTITY,
    libelle VARCHAR (200) NOT NULL ,
    CONSTRAINT THEME_PK PRIMARY KEY CLUSTERED (idTheme)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE UTILISATEUR
  (
    idUtilisateur INTEGER NOT NULL IDENTITY,
    nom           VARCHAR (250) NOT NULL ,
    prenom        VARCHAR (250) NOT NULL ,
    email         VARCHAR (250) NOT NULL ,
    password      VARCHAR (100) NOT NULL ,
    codeProfil    INTEGER NOT NULL ,
    codePromo     CHAR (8) ,
    CONSTRAINT UTILISATEUR_PK PRIMARY KEY CLUSTERED (idUtilisateur)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default" ,
  CONSTRAINT UTILISATEUR_EMAIL_UQ UNIQUE NONCLUSTERED (email) ON "default"
  )
  ON "default"
GO

ALTER TABLE UTILISATEUR
ADD CONSTRAINT Candidat_Promotion_FK FOREIGN KEY
(
codePromo
)
REFERENCES PROMOTION
(
codePromo
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE EPREUVE
ADD CONSTRAINT Epreuve_Candidat_FK FOREIGN KEY
(
idUtilisateur
)
REFERENCES UTILISATEUR
(
idUtilisateur
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE EPREUVE
ADD CONSTRAINT Epreuve_Test_FK FOREIGN KEY
(
idTest
)
REFERENCES TEST
(
idTest
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE PROPOSITION
ADD CONSTRAINT Proposition_Question_FK FOREIGN KEY
(
idQuestion
)
REFERENCES QUESTION
(
idQuestion
)
ON
DELETE CASCADE ON
UPDATE NO ACTION
GO

ALTER TABLE QUESTION
ADD CONSTRAINT Question_Theme_FK FOREIGN KEY
(
idTheme
)
REFERENCES THEME
(
idTheme
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE REPONSE_TIRAGE
ADD CONSTRAINT Reponse_Proposition_FK FOREIGN KEY
(
idProposition,
idQuestion
)
REFERENCES PROPOSITION
(
idProposition ,
idQuestion
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE REPONSE_TIRAGE
ADD CONSTRAINT Reponse_Tirage_FK FOREIGN KEY
(
idQuestion,
idEpreuve
)
REFERENCES QUESTION_TIRAGE
(
idQuestion ,
idEpreuve
)
ON
DELETE CASCADE ON
UPDATE NO ACTION
GO

ALTER TABLE SECTION_TEST
ADD CONSTRAINT Section_Test_FK FOREIGN KEY
(
idTest
)
REFERENCES TEST
(
idTest
)
ON
DELETE CASCADE ON
UPDATE NO ACTION
GO

ALTER TABLE SECTION_TEST
ADD CONSTRAINT Section_Theme_FK FOREIGN KEY
(
idTheme
)
REFERENCES THEME
(
idTheme
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE QUESTION_TIRAGE
ADD CONSTRAINT Tirage_Epreuve_FK FOREIGN KEY
(
idEpreuve
)
REFERENCES EPREUVE
(
idEpreuve
)
ON
DELETE CASCADE ON
UPDATE NO ACTION
GO

ALTER TABLE QUESTION_TIRAGE
ADD CONSTRAINT Tirage_Question_FK FOREIGN KEY
(
idQuestion
)
REFERENCES QUESTION
(
idQuestion
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE UTILISATEUR
ADD CONSTRAINT Utilisateur_Profil_FK FOREIGN KEY
(
codeProfil
)
REFERENCES PROFIL
(
codeProfil
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

-- Rapport récapitulatif d'Oracle SQL Developer Data Modeler : 
-- 
-- CREATE TABLE                            11
-- CREATE INDEX                             0
-- ALTER TABLE                             13
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE DATABASE                          0
-- CREATE DEFAULT                           0
-- CREATE INDEX ON VIEW                     0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE ROLE                              0
-- CREATE RULE                              0
-- CREATE PARTITION FUNCTION                0
-- CREATE PARTITION SCHEME                  0
-- 
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
