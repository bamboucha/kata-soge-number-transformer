import { Component, ViewChild } from '@angular/core';
import { ModalComponent } from './modal/modal.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('modalForm') modalForm: ModalComponent;

  constructor() {}

  openModal(): void {
    this.modalForm.openModal();
  }

}
