package com.trantor.delugeadapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {
    private Integer id;
    private Boolean result;
    private String error;
}
