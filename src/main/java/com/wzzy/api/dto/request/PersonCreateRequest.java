package com.wzzy.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonCreateRequest (
        @NotBlank
        String name,
        @NotNull
        String old,
        @NotBlank
        String city,
        @NotBlank
        String job){
}
