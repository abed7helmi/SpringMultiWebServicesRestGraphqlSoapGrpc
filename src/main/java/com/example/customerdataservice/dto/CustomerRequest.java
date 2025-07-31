package com.example.customerdataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record CustomerRequest(String name, String email) {

}
