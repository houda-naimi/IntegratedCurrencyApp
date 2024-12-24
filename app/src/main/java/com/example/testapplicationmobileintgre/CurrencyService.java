package com.example.testapplicationmobileintgre;

import android.content.Context;

import java.util.Map;

public class CurrencyService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/%s/latest/TND";

    public static void fetchExchangeRates(Context context, CurrencyServiceCallback callback) {
        String apiKey = context.getString(R.string.exchange_rate_api_key);
        String url = String.format(API_URL, apiKey);
        new FetchRatesTask(context, callback).execute(url);
    }

    // retour des résultats
    public interface CurrencyServiceCallback {
        void onSuccess(Map<String, Double> rates);
        void onFailure(Exception e);
    }

}
