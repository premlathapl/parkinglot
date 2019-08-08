package com.skillenza.parkinglotjava;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String created_at;
    private int lot;
    private int parking_amount;
    private int parking_duration;
    private String updated_at;
    private int vehicle_number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getLot() {
		return lot;
	}
	public void setLot(int lot) {
		this.lot = lot;
	}
	public int getParking_amount() {
		return parking_amount;
	}
	public void setParking_amount(int parking_amount) {
		this.parking_amount = parking_amount;
	}
	public int getParking_duration() {
		return parking_duration;
	}
	public void setParking_duration(int parking_duration) {
		this.parking_duration = parking_duration;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public int getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(int vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
    
}
