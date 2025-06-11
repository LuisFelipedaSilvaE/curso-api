package org.example.api.resources.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;
}
