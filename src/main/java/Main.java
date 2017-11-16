public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Capital.getCapitalData();
        Continent.getContinentData();
        Countries.getCountriesData();
        Countriesemployer.getContriesEmployerData();
        TimeZone.getTimeZoneData();
        for (Capital cp : Capital.Capitals){
            System.out.println(cp);
        }
        for (Continent cp : Continent.Continents){
            System.out.println(cp);
        }
        for (Countries cp : Countries.Countries){
            System.out.println(cp);
        }
        for (Countriesemployer cp : Countriesemployer.countriesemployers){
            System.out.println(cp);
        }
        for (TimeZone cp : TimeZone.TimeZones){
            System.out.println(cp);
        }
    }
}
