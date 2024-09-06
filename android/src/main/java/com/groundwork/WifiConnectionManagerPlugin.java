package com.groundwork;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "WifiConnectionManager")
public class WifiConnectionManagerPlugin extends Plugin {

    private WifiConnectionManager implementation;

    @Override
    public void load() {
        // Initialize the implementation with the application context
        implementation = new WifiConnectionManager(getContext());
    }

    @PluginMethod
    public void connectToWifi(PluginCall call) {
        String ssid = call.getString("ssid");
        String password = call.getString("password");

        if (ssid == null || password == null) {
            call.reject("SSID or password is missing");
            return;
        }

        String result = implementation.connectToWifi(ssid, password);

        JSObject ret = new JSObject();
        ret.put("result", result);
        call.resolve(ret);
    }
}
