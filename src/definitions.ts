export interface WifiConnectionManagerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
