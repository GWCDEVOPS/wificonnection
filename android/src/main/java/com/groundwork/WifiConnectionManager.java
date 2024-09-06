package com.groundwork;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.util.Log;

public class WifiConnectionManager {

    private Context context;

    public WifiConnectionManager(Context context) {
        this.context = context;
    }

    public String connectToWifi(String ssid, String password) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

            WifiConfiguration wifiConfig = new WifiConfiguration();
            wifiConfig.SSID = String.format("\"%s\"", ssid);
            wifiConfig.preSharedKey = String.format("\"%s\"", password);

            int netId = wifiManager.addNetwork(wifiConfig);
            wifiManager.disconnect();
            wifiManager.enableNetwork(netId, true);
            wifiManager.reconnect();

            Log.i("WifiConnectionManager", "Connected to " + ssid);
            return "Connected to " + ssid;
        } catch (Exception e) {
            Log.e("WifiConnectionManager", "Failed to connect to WiFi", e);
            return "Failed to connect to WiFi: " + e.getMessage();
        }
    }
}
