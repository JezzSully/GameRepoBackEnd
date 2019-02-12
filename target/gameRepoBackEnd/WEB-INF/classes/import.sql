INSERT INTO LOLPROFILE (ID, DIVISION, LEAGUE, FAVEPOSITION, FAVECHAMP, USERNAME, TAG, NOTES) VALUES ('1', '3', 'gold', 'support', 'Janna', 'JezzSully', 'Looking to learn', 'Only started this season');
INSERT INTO DOTAPROFILE (ID, DIVISION, LEAGUE, FAVEPOSITION, FAVEHERO, USERNAME, TAG, NOTES) VALUES ('1', '3', 'crusader', '4', 'Undying', 'JezzSully', 'Looking to expand hero pool', 'DotA sucks');
INSERT INTO USER (AGE, EMAIL, USERNAME, LEAGUEPROFILE_ID, DOTAPROFILE_ID) VALUES ('23', 'jez@gmail.com', 'jezz', '1', '1');

INSERT INTO LOLPROFILE (ID, DIVISION, LEAGUE, FAVEPOSITION, FAVECHAMP, USERNAME, TAG, NOTES) VALUES ('2', '2', 'silver', 'top', 'Malphite', 'Lukedicolo', 'Need a carry', 'NOTES');
INSERT INTO DOTAPROFILE (ID, DIVISION, LEAGUE, FAVEPOSITION, FAVEHERO, USERNAME, TAG, NOTES) VALUES ('2', '3', 'archon', '4', 'Techies', 'Lukedicolo', 'Need a coach', 'I hate this game.');
INSERT INTO USER (AGE, EMAIL, USERNAME, LEAGUEPROFILE_ID, DOTAPROFILE_ID) VALUES ('45', 'LukeyLuke@gmail.com', 'Lukey', '2', '2');

INSERT INTO TEAM (ID, GAME) VALUES ('1', 'LEAGUE');
INSERT INTO TEAM_USER (TEAM_ID, MEMBERS_ID) VALUES ('1','1');
INSERT INTO TEAM_USER (TEAM_ID, MEMBERS_ID) VALUES ('1','2');

CREATE TABLE LEAGUECHAMPENUM (name VARCHAR(50) NOT NULL);
INSERT INTO LEAGUECHAMPENUM (name) VALUES ('Janna'),('Azir'),('Trundle'),('Malphite'),('Braum'),('Zoe'),('Ahri'),('Poppy'),('Jinx'),('Twisted Fate'),('Zed');
CREATE TABLE DOTAHEROENUM (name VARCHAR(50) NOT NULL);
INSERT INTO DOTAHEROENUM (name) VALUES ('Techies'),('Undying'),('Enigma'),('Luna'),('Shadow Fiend'),('Earth Spirit'),('Ogre Magi'),('Jakiro'),('Puck');