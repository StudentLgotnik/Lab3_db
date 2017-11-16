create table Countries
(
  Country char varying(30) ,
  Mainland char varying(30) ,
  Population int ,
  Capital char varying(30) ,
  TimeZone char varying(30)
);

create table Continent
(
  Continent char varying(30) NOT NULL PRIMARY KEY,
  Climate char varying(30)
);

create table TimeZone
(
  TimeZone char varying(30) NOT NULL PRIMARY KEY ,
  Goverment char varying(30) NOT NULL
);

create table Capital
(
  Capital char varying(30) NOT NULL PRIMARY KEY ,
  Governor char varying(30),
  Population int
);

create table CountriesEmployer
(
  Countries char varying(30) NOT NULL PRIMARY KEY ,
  Unemployed char varying(30)
);