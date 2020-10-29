create table band
(
  id serial,
  name character varying(50) not null,
  players_count integer not null,
  created date not null,
  constraint band_pk primary key (id)
);

insert into band (name, players_count, created) values ('Queen', 4, '1973-07-13');
insert into band (name, players_count, created) values ('Rolling Stones', 4, '1962-08-01');
insert into band (name, players_count, created) values ('Scorpions', 5, '1965-01-01');