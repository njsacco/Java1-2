import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TestSupermarket {

    public static void main(String[] args) {

        var cities = new String[] {
                "Miami",
                "Sunrise",
                "Hollywood",
                "Tallahassee",
                "Jacksonville",
                "Orlando",
                "Gainesville",
                "Pensacola",
                "Ocala",
                "Sebring"
        };

        var profits = new double[] {
                10200000,
                14600000,
                17000000,
                6000000,
                21600000,
                9100000,
                8000000,
                12500000,
                2000000,
                4500000
        };

        var supermarkets = new Supermarkets(cities, profits);
        
        System.out.println("\n");
        supermarkets.displayOriginalDataset();
        supermarkets.displayAverageProfit();
        supermarkets.displayCityWithTheHighestProfit();
        supermarkets.displayCitiesWithProfitsAtOrAboveAverage();
        supermarkets.displayStandardDeviationsOfTheProfits();
        supermarkets.displayCitiesAndTheirProfitsInDescendingOrderOfProfits();

        supermarkets.displayProfitOfGivenCity("Miami");
        supermarkets.displayProfitOfGivenCity("Sebring");
        supermarkets.displayProfitOfGivenCity("Ocala");
        supermarkets.displayProfitOfGivenCity("Chicago");

    }

}

class Supermarkets {

    private final NumberFormat formatter;

    private final String[] cities;
    private final double[] profits;
    private final HashMap<String, Double> citiesAndProfits;

    private final String[] citiesInDescendingOrderOfProfits;
    private final double[] profitsInDescendingOrderOfProfits;

    private double averageProfit;
    private String cityWithTheHighestProfit;
    private ArrayList<String> citiesWithProfitsAtOrAboveAverage;
    private double standardDeviationsOfTheProfits;

    public Supermarkets(String[] cities, double[] profits) {
        if (cities.length != profits.length) {
            System.out.println("Length of cities and profits are not the same!");
            System.out.println("Cities Length: " + cities.length + ". ");
            System.out.println("Profits Length: " + profits.length + ". ");
            System.exit(1);
        }

        this.formatter = NumberFormat.getCurrencyInstance();

        this.cities = cities;
        this.profits = profits;
        this.citiesAndProfits = new HashMap<>();

        this.citiesInDescendingOrderOfProfits = new String[cities.length];
        this.profitsInDescendingOrderOfProfits = new double[profits.length];

        this.calculateHashmapFromCitiesAndProfits();

        this.calculateAverageProfit();
        this.calculateCityWithTheHighestProfit();
        this.calculateCitiesWithProfitsAtOrAboveAverage();
        this.calculateStandardDeviationsOfTheProfits();
        this.calculateCitiesAndTheirProfitsInDescendingOrderOfProfits();
    }


    public void displayOriginalDataset() {
        displayDataHeaders();
        displayDataContent(cities, profits);
        System.out.println();
    }

    public void displayAverageProfit() {
        var averageFormatted = formatPrice(this.averageProfit);
        System.out.println("Average profits: " + averageFormatted);
        System.out.println();
    }

    public void displayCityWithTheHighestProfit() {
        System.out.println("City with the highest profit: " + cityWithTheHighestProfit);
        System.out.println();
    }

    public void displayCitiesWithProfitsAtOrAboveAverage() {
        System.out.println("Cities with profits at or above average:");

        for (var city : citiesWithProfitsAtOrAboveAverage) {
            System.out.println(city);
        }

        System.out.println();
    }

    public void displayStandardDeviationsOfTheProfits() {
        var standardDeviationFormatted = formatter.format(standardDeviationsOfTheProfits);
        System.out.println("The standard deviations of the profits are: " + standardDeviationFormatted);
        System.out.println();
    }

    public void displayCitiesAndTheirProfitsInDescendingOrderOfProfits() {
        displayDataHeaders();
        displayDataContent(citiesInDescendingOrderOfProfits, profitsInDescendingOrderOfProfits);
        System.out.println();
    }

    public void displayProfitOfGivenCity(String city) {
        var profit = citiesAndProfits.get(city);
        String profitFormatted;
        profitFormatted = profit == null ? "0! We have no supermarkets located in " + city : formatPrice(profit);

        System.out.println("The profits of city: " + city + " are " + profitFormatted);
        System.out.println();
    }



    private void calculateAverageProfit() {
        var citiesLength = cities.length;
        var totalProfits = 0D;

        for (var profit : profits) {
            totalProfits += profit;
        }

        this.averageProfit = totalProfits / citiesLength;
    }

    private void calculateCityWithTheHighestProfit() {
        this.cityWithTheHighestProfit = "No cities recorded";
        double highestProfit = 0D;

        for (int i = 0; i < cities.length; i++) {
            var city = cities[i];
            var profit = profits[i];

            if (profit > highestProfit) {
                this.cityWithTheHighestProfit = city;
                highestProfit = profit;
            }
        }
    }

    private void calculateCitiesWithProfitsAtOrAboveAverage() {
        this.citiesWithProfitsAtOrAboveAverage = new ArrayList<>();

        for (int i = 0; i < this.cities.length; i++) {
            var city = this.cities[i];
            var profit = this.profits[i];

            if (profit >= this.averageProfit) {
                this.citiesWithProfitsAtOrAboveAverage.add(city);
            }
        }
    }

    private void calculateStandardDeviationsOfTheProfits() {
        double sumDifference = 0;

        for (var profit : profits) {
            sumDifference += Math.pow(profit - this.averageProfit, 2);
        }

        this.standardDeviationsOfTheProfits = Math.sqrt(sumDifference / profits.length - 1);
    }

    private void calculateCitiesAndTheirProfitsInDescendingOrderOfProfits() {
        var sorted = citiesAndProfits
                .entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));

        var sortedEntries = sorted
                .entrySet()
                .stream()
                .toList();

        for (int i = 0; i < sorted.size(); i++) {
            var entry = sortedEntries.get(i);
            var city = entry.getKey();
            var profit = entry.getValue();

            this.citiesInDescendingOrderOfProfits[i] = city;
            this.profitsInDescendingOrderOfProfits[i] = profit;
        }
    }

    private void calculateHashmapFromCitiesAndProfits() {
        for (int i = 0; i < cities.length; i++) {
            var city = cities[i];
            var profit = profits[i];

            this.citiesAndProfits.put(city, profit);
        }
    }


    private void displayDataHeaders() {
        var cityHeader = padString("City");
        var profitHeader = padString("Profits");

        System.out.println(cityHeader + profitHeader);
    }

    private void displayDataContent(String[] cities, double[] profits) {
        for (int i = 0; i < cities.length; i ++) {
            var city = cities[i];
            var profit = profits[i];
            var profitFormatted = formatPrice(profit);

            var cityPadded = padString(city);
            var profitPadded = padString(profitFormatted);

            System.out.println(cityPadded + profitPadded);
        }
    }


    private String padString(String s) {
        return s + " ".repeat(20 - s.length());
    }

    private String formatPrice(double price) {
        return formatter.format(price);
    }

}
