package com.optimagrowth.licensingservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter @Setter @ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class License {

    int id;
    String licenseId;
    String description;
    String organizationId;
    String productName;
    String licenseType;

}
