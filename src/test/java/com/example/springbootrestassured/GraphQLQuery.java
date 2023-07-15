package com.example.springbootrestassured;

import lombok.Data;

@Data
public class GraphQLQuery {

    String query;
    Object variables;
}
