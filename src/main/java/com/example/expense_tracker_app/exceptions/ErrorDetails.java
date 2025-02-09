package com.example.expense_tracker_app.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(
        description = "ErrorDetails DTO(Data Transfer Object) to transfer data between client and server"
)
public record ErrorDetails(
        @Schema(
                description = "Error occurred date time"
        )
        LocalDateTime timestamp,
        @Schema(
                description = "Error Message"
        )
        String message,
        @Schema(
                description = "Error Details"
        )
        String details,
        @Schema(
                description = "Error Code"
        )
        String errorCode) {
}
