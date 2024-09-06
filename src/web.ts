import { WebPlugin } from '@capacitor/core';

import type { WifiConnectionManagerPlugin } from './definitions';

export class WifiConnectionManagerWeb extends WebPlugin implements WifiConnectionManagerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
