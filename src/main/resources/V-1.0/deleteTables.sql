ALTER TABLE Countries
  DROP CONSTRAINT FK_CountriesCapital;
DROP TABLE Capital;

ALTER TABLE Countries
  DROP CONSTRAINT FK_CountriesContinent;
DROP TABLE Continent;

ALTER TABLE Countries
  DROP CONSTRAINT FK_CountriesCountriesEmplyer;
DROP TABLE CountriesEmployer;

ALTER TABLE Countries
  DROP CONSTRAINT FK_CountriesTimeZone;
DROP TABLE TimeZone;

DROP TABLE Countries;