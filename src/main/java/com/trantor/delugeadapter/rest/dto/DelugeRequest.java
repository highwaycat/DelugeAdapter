package com.trantor.delugeadapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DelugeRequest {
    private Integer id;
    private String method;
    private List<String> params;
}
