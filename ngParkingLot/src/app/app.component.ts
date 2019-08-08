import { Component } from "@angular/core";
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder
} from "@angular/forms";
import { HttpClient } from "@angular/common/http";
import { ParkingLot } from "src/ParkingLot";
import { ParkingServiceService } from "./parking-service.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  vehicleForm: FormGroup;
  parkings = new Array<ParkingLot>();
  constructor(private fb: FormBuilder, pService: ParkingServiceService) {
    pService.getAllParking().subscribe(response => {
      this.parkings = response.map(item => {
        return new ParkingLot(
          item.id,
          item.lot,
          item.parking_amount,
          item.parking_duration,
          item.vehicle_number
        );
      });
    });
  }
  ngOnInit() {
    this.vehicleForm = new FormGroup({
      vehicleLot: new FormControl("vehicleLot"),
      vehicleNumber: new FormControl("vehicleNumber"),
      vehicleDuration: new FormControl("vehicleDuration"),
      vehicleAmount: new FormControl("vehicleAmount")
    });
  }
  onSubmit(form: FormGroup) {
    console.log("Valid?", form.valid); // true or false
    console.log("vehicleLot", form.value.vehicleLot);
    console.log("vehicleNumber", form.value.vehicleNumber);
    console.log("vehicleAmount", form.value.vehicleAmount);
    console.log("vehicleDuration", form.value.vehicleDuration);
  }
}
