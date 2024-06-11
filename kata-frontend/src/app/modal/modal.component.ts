import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ApiWebserviceService } from '../service/api-webservice.service';
import { Observable } from 'rxjs';
declare var bootstrap: any;

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit, AfterViewInit {
  @ViewChild('numberModal') numberModal: ElementRef;
  numberForm: FormGroup;
  modalInstance: any;
  result$: Observable<string>;

  constructor(private fb: FormBuilder,
    private apiClient: ApiWebserviceService) {
    this.numberForm = this.fb.group({
      number: ['', [Validators.required, Validators.min(0), Validators.max(100)]]
    });
  }

  ngOnInit(): void { }

  ngAfterViewInit(): void {
    if (this.numberModal) {
      this.modalInstance = new bootstrap.Modal(this.numberModal.nativeElement);
    }
  }

  get numberControl() {
    return this.numberForm.get('number');
  }

  openModal(): void {
    if (this.modalInstance) {
      this.modalInstance.show();
    }
  }

  onClose() {
    this.numberForm.reset();
    this.result$ = null;
  }

  onSubmit(): void {
    if (this.numberForm.valid) {
      this.result$ = this.apiClient.getTransformedNumber(this.numberForm.value.number);
    }
  }

}
