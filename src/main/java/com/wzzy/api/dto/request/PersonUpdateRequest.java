package com.wzzy.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonUpdateRequest(
        @NotBlank
        String personId,
        @NotBlank
        String name,
        @NotNull
        String old,
        @NotBlank
        String city,
        @NotBlank
        String job
) {
}
