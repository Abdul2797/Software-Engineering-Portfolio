// world.ts
import { Component, AfterViewInit } from '@angular/core';
import { CountryService } from './country.service';

@Component({
  selector: 'app-world',
  templateUrl: './world.html',
  styleUrls: ['./world.css'],
  standalone: true
})
export class WorldComponent implements AfterViewInit {
  countryName = '';
  countryRegion = '';
  incomeLevel = '';
  capitalCity = '';
  latitude = '';
  longitude = '';

  constructor(private countryService: CountryService) {}

  ngAfterViewInit(): void {
    const paths = document.querySelectorAll<SVGPathElement>('svg path');
    paths.forEach(path => {
      path.addEventListener('click', () => this.loadCountry(path.id));
    });
  }

  loadCountry(code: string) {
    this.countryService.getCountryData(code).subscribe({
      next: (data) => {
        const country = data?.[1]?.[0];
        if (country) {
          this.countryName = country.name;
          this.capitalCity = country.capitalCity;
          this.countryRegion = country.region.value;
          this.incomeLevel = country.incomeLevel.value;
          this.latitude = country.latitude;
          this.longitude = country.longitude;
        } else {
          this.resetData();
        }
      },
      error: () => this.resetData()
    });
  }

  private resetData() {
    this.countryName = '';
    this.capitalCity = '';
    this.countryRegion = '';
    this.incomeLevel = '';
    this.latitude = '';
    this.longitude = '';
  }
}
