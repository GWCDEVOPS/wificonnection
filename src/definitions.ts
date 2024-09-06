export interface WifiConnectionManagerPlugin {
    connectToWifi(options: { ssid: string; password: string }): Promise<{ result: string }>;
}