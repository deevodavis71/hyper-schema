package com.sjd.hyper.dto;

import com.fasterxml.jackson.module.jsonSchema.annotation.JsonHyperSchema;
import com.fasterxml.jackson.module.jsonSchema.annotation.Link;
import lombok.Data;

@Data
@JsonHyperSchema(pathStart = "http://customer", links = {
        @Link(href="/topology", rel="topology", targetSchema = TopologyDTO.class)
})
public class CustomerOrderDTO {

    private TopologyDTO topology;

}
