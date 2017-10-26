package com.sjd.hyper.dto;

import com.fasterxml.jackson.module.jsonSchema.annotation.JsonHyperSchema;
import com.fasterxml.jackson.module.jsonSchema.annotation.Link;
import lombok.Data;

@Data
@JsonHyperSchema(pathStart = "http://getschema?path=CustomerOrderDTO", links = {
        @Link(href="/TopologyDTO", rel="topology", targetSchema = TopologyDTO.class)
})
public class CustomerOrderDTO {

    private TopologyDTO topology;

}
