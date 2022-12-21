package com.mandiri.shippoapps.model.response;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T>{
    private String message;
    private T data;
}
