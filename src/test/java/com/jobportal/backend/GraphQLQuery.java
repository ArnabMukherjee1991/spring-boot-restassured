package com.jobportal.backend;

import lombok.Data;

@Data
public class GraphQLQuery {

    String query;
    Object variables;
}
