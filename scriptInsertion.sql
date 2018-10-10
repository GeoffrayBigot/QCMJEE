insert into Promotion values (1,'Promotion Septembre 2018');
insert into Promotion values (2,'Promotion Avril 2018');
insert into Promotion values (3,'Promotion Juillet 2018');
insert into Promotion values (4,'Promotion Septembre 2017');
insert into Promotion values (5,'Promotion Avril 2017');
insert into Promotion values (6,'Promotion Juillet 2017');

insert into Profil values (1,'Admin');
insert into Profil values (2,'Formateur');
insert into Profil values (3,'Responsable');
insert into Profil values (4,'Etudiant');

insert into UTILISATEUR VALUES ('Godicheau-Tornier', 'Ronan', 'g@g.com', 'test01', 4, null)
insert into UTILISATEUR VALUES ('Bigot', 'Geoffray', 'b@b.com', 'test02', 3, 1)
insert into UTILISATEUR VALUES ('Aicheh', 'Alexandre', 'a@a.com', 'test03', 2, null)

insert into THEME VALUES (1, 'Symfony')
insert into THEME VALUES (2, 'JAVA')

insert into TEST VALUES ('Test Symfony CDI', 'Premier test de Symfony CDI', 90, 60, 30)
insert into TEST VALUES ('Test Java CDI', 'Premier test de Java CDI', 120, 70, 40)


insert into QUESTION VALUES ('Est ce que JAVA c''est bien ?', null, 1, 2)
insert into QUESTION VALUES ('Java est-il un langue compilé ?', null, 1, 2)
insert into QUESTION VALUES ('Symfony est-il un langue compilé ?', null, 1, 1)
insert into QUESTION VALUES ('Symfony peut-il conduire une voiture ?', null, 1, 1)

insert into PROPOSITION VALUES (1, 'Oui', 0, 1)
insert into PROPOSITION VALUES (2, 'Non', 1, 1)

insert into PROPOSITION VALUES (3, 'Oui', 1, 2)
insert into PROPOSITION VALUES (4, 'Non', 0, 2)

insert into PROPOSITION VALUES (5, 'Oui', 0, 3)
insert into PROPOSITION VALUES (6, 'Non', 1, 3)

insert into PROPOSITION VALUES (7, 'Oui', 0, 4)
insert into PROPOSITION VALUES (8, 'Non', 0, 4)
insert into PROPOSITION VALUES (9, 'Que si il n''a pas trop bu', 1, 4)

insert into EPREUVE VALUES ('2018-22-09 15:00', '2018-22-09 16:00', 60, 'ET', 74, 'A', 1, 2)

insert into QUESTION_TIRAGE VALUES (1, 3, 1, 1)
insert into QUESTION_TIRAGE VALUES (0, 4, 1, 1)

INSERT INTO REPONSE_TIRAGE VALUES (5,3,1)
INSERT INTO REPONSE_TIRAGE VALUES (6,3,1)
INSERT INTO REPONSE_TIRAGE VALUES (7,4,1)
INSERT INTO REPONSE_TIRAGE VALUES (8,4,1)
INSERT INTO REPONSE_TIRAGE VALUES (9,4,1)

INSERT INTO SECTION_TEST VALUES (2, 1, 1)
