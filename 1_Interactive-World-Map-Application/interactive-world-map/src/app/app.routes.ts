// app.routes.ts
import { Routes } from '@angular/router';
import { WorldComponent } from './world/world';

export const routes: Routes = [
  { path: '', redirectTo: '/map', pathMatch: 'full' }, 
  { path: 'map', component: WorldComponent }           
];