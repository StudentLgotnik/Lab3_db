create table TimeZoneOne
(
  TimeZone char varying(30) NOT NULL PRIMARY KEY ,
  Goverment char varying(30) NOT NULL
);
INSERT INTO TimeZoneOne SELECT * FROM TimeZone;
ALTER TABLE Countries
  DROP CONSTRAINT FK_CountriesTimeZone;
DROP TABLE TimeZone;