import { Component } from '@angular/core';
import {RouterLink} from '@angular/router'
import { CarruselComponent } from '../carrusel/carrusel.component';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, CarruselComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
