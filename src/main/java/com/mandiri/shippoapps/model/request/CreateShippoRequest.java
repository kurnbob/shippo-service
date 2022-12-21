package com.mandiri.shippoapps.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateShippoRequest {
    private String name;
    private String address;
    private String phone;
    private String permitNumber;
    private String taxNumber;
}
