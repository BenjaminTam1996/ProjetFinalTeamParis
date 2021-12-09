import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ConnexionComponent } from './formulaires/connexion/connexion.component';
import { SigninComponent } from './formulaires/signin/signin.component';
import { ParametresComponent } from './formulaires/parametres/parametres.component';
import { AlbumComponent } from './formulaires/album/album.component';
import { ConcertComponent } from './formulaires/concert/concert.component';
import { PublicationComponent } from './formulaires/publication/publication.component';
import { PhotosComponent } from './formulaires/photos/photos.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    SigninComponent,
    ParametresComponent,
    AlbumComponent,
    ConcertComponent,
    PublicationComponent,
    PhotosComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
