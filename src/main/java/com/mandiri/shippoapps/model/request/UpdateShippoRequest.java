package com.mandiri.shippoapps.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateShippoRequest {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String permitNumber;
    private String taxNumber;
}
