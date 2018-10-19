use QCMJEE;

insert into Promotion values (1,'Promotion Septembre 2017');

insert into Profil values (1,'Formateur');
insert into Profil values (2,'Responsable');
insert into Profil values (3,'Etudiant');

insert into UTILISATEUR VALUES ('Godicheau-Tornier', 'Ronan', 'g@g.com', 'test01', 3, 1)
insert into UTILISATEUR VALUES ('Godicheau-Tornier', 'Ronan', 'ronan@gt.com', 'test01', 1, 1)
insert into UTILISATEUR VALUES ('Bigot', 'Geoffray', 'b@b.com', 'test02', 3, 1)
insert into UTILISATEUR VALUES ('Bigot', 'Geoffray', 'geoffray@b.com', 'test02', 2, 1)
insert into UTILISATEUR VALUES ('Aicheh', 'Alexandre', 'a@a.com', 'test03', 3, 1)
insert into UTILISATEUR VALUES ('Aicheh', 'Alexandre', 'aicheh@a.com', 'test03', 2, 1)

insert into THEME VALUES ('Java EE')
insert into THEME VALUES ('JAVA client lourd')

insert into TEST VALUES ('Test Java EE CDI', 'Premier test de java EE CDI', 90, 60, 30)
insert into TEST VALUES ('Test Java CDI', 'Premier test de Java CDI', 120, 70, 40)


insert into QUESTION VALUES ('Est ce que JAVA c''est bien ?', null, 1, 2)
insert into QUESTION VALUES ('Java est-il un langage compilé ?', null, 1, 2)
insert into QUESTION VALUES ('Apprécies-tu le java ee ?', null, 1, 1)
insert into QUESTION VALUES ('Qu''est ce qu''une Servlet ?', null, 1, 1)

insert into PROPOSITION VALUES ( 'Je passe svp', 0, 1)
insert into PROPOSITION VALUES ( 'mmmh, je vais y réfléchir', 1, 1)

insert into PROPOSITION VALUES ( 'Oui', 1, 2)
insert into PROPOSITION VALUES ('Non', 0, 2)

insert into PROPOSITION VALUES ( 'Oui', 0, 3)
insert into PROPOSITION VALUES ( 'Non', 1, 3)

insert into PROPOSITION VALUES ( 'Je sais pas', 1, 4)
insert into PROPOSITION VALUES ( 'Une chose qui se mange ?', 0, 4)


insert into EPREUVE VALUES ('2018-22-09 15:00', '2018-22-09 16:00', 60, 'EA', 0, 'NA', 1, 1)
insert into EPREUVE VALUES ('2018-22-09 15:00', '2018-22-09 16:00', 60, 'EA', 0, 'NA', 2, 1)

insert into EPREUVE VALUES ('2018-22-09 15:00', '2018-22-09 16:00', 60, 'EA', 0, 'NA', 1, 3)
insert into EPREUVE VALUES ('2018-22-09 15:00', '2018-22-09 16:00', 60, 'EA', 0, 'NA', 2, 3)

insert into EPREUVE VALUES ('2018-22-09 15:00', '2018-22-09 16:00', 60, 'EA', 0, 'NA', 1, 5)
insert into EPREUVE VALUES ('2018-22-09 15:00', '2018-22-09 16:00', 60, 'EA', 0, 'NA', 2, 5)

INSERT INTO SECTION_TEST VALUES (2, 1, 1)
INSERT INTO SECTION_TEST VALUES (2, 2, 2)
