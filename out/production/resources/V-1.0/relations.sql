ALTER TABLE Countries ADD CONSTRAINT FK_CountriesTimeZone FOREIGN KEY (TimeZone) REFERENCES TimeZone(TimeZone);
ALTER TABLE Countries ADD CONSTRAINT FK_CountriesCapital FOREIGN KEY (Capital) REFERENCES Capital(Capital) ;
ALTER TABLE Countries ADD CONSTRAINT FK_CountriesContinent FOREIGN KEY (Mainland) REFERENCES Continent(Continent)  ;
ALTER TABLE Countries ADD CONSTRAINT FK_CountriesCountriesEmplyer FOREIGN KEY (Country) REFERENCES CountriesEmployer(Countries)  ;