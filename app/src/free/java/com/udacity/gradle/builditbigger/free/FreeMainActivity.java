package com.udacity.gradle.builditbigger.free;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.R;

public class FreeMainActivity extends com.udacity.gradle.builditbigger.MainActivity {

    InterstitialAd interstitialAd;
    String joke = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInterstitialAd();
    }

    @Override
    protected void startJoke(String joke) {
        this.joke = joke;
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            // If the add is still not loaded, we don't want to waste the user's time
            super.startJoke(joke);
        }
    }

    private void setupInterstitialAd() {
        interstitialAd  = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.test_ad_unit_id));
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                interstitialAd.loadAd(new AdRequest.Builder().build());
                FreeMainActivity.super.startJoke(joke);
            }
        });
    }
}
