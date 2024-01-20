package jpa1;

import java.time.ZonedDateTime;
import java.util.Date;

public class App {
    public static void main(String[] args) {

        CurrencyDAO currencyDAO = new CurrencyDAO();

        Date today = new Date();
        Date past = Date.from(ZonedDateTime.now().minusMonths(2).toInstant());

        String usdRequest = CurrencyAPI.buildRequestPeriod(past, today, "USD");
        String usdJson = CurrencyAPI.getJsonFromAPI(usdRequest);
        Currency[] arrayEuro = CurrencyAPI.getCurrenciesFromJSON(usdJson);
        currencyDAO.saveCurrencyArray(arrayEuro);

        System.out.println("Average value USD = " + currencyDAO.getAverageValueCurrency("USD"));
    }
}


