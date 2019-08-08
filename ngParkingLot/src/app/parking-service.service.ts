import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ParkingLot } from "src/ParkingLot";

@Injectable({
  providedIn: "root"
})
export class ParkingServiceService {
  constructor(private http: HttpClient) {}
  public getAllParking(): Observable<ParkingLot[]> {
    const url = "http://localhost:8080/api/parkings";

    return this.http.get<ParkingLot[]>(url);
  }
}
