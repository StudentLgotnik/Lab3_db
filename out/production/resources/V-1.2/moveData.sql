create table ContinentPop
(
  Population int
);
INSERT INTO ContinentPop(Population) SELECT Population FROM Capital;
ALTER TABLE Capital DROP COLUMN Population;