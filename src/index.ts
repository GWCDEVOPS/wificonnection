import { registerPlugin } from '@capacitor/core';

import type { WifiConnectionManagerPlugin } from './definitions';

const WifiConnectionManager = registerPlugin<WifiConnectionManagerPlugin>('WifiConnectionManager', {
  web: () => import('./web').then(m => new m.WifiConnectionManagerWeb()),
});

export * from './definitions';
export { WifiConnectionManager };
