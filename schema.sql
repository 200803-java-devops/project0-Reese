create  table Account(
    username varchar(32) NOT NULL PRIMARY KEY,
    pwd varchar(254) NOT NULL
);

insert into Account (username, pwd) values('Me', '5f4dcc3b5aa765d61d8327deb882cf99');

create table Player(
    playerId SERIAL PRIMARY KEY, 
    Username varchar(32),
    CharacterName varChar(3),
    Face varChar(5),
    UNIQUE (Username,CharacterName)
);

insert into Player(Username, CharacterName, Face) values ('Me','ME', '(0.0)');

create table PlayerMonsters(
    playerId int,
    monsterName varChar(32),
    monsterType varchar(32),
    atk int,
    dodgeChance int,
    PRIMARY KEY (playerId, monsterName),
    Foreign KEY (playerId) references Player(playerId)
);

insert into PlayerMonsters(playerId, monsterName, monsterType, atk, dodgeChance) values (1, 'monsterName', 'Skizard', 5, 10);

Create view PlayerCharacters as
select player.username, charactername, face, monstername, monstertype, atk, dodgechance from Account 
join player on Account.username = player.username
join playermonsters on playermonsters.playerid = player.playerid;