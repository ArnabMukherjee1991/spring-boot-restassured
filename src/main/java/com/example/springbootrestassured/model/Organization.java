package com.example.springbootrestassured.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder(toBuilder = true, setterPrefix = "set")
public class Organization {
    String organizationId;
    String organizationName;
    OrganizationType organizationType;
    String address;
    String city;

}
