package com.sliusar.projectzone.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public final class ProjectZoneException extends RuntimeException {
    private String message;
}
