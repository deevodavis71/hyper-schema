package com.sjd.hyper.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.module.jsonSchema.annotation.JsonHyperSchema;
import com.fasterxml.jackson.module.jsonSchema.annotation.Link;
import com.sjd.hyper.dto.support.WrappedCollection;
import lombok.Data;

@Data
@JsonHyperSchema(pathStart = "http://topology", links = {
        @Link(href="/logicalConnections", rel="logicalConnections", targetSchema = LogicalConnectionDTO.class),
        @Link(href="/links", rel="links", targetSchema = LinkDTO.class)
})
public class TopologyDTO {

    private Long topologyId;

    @JsonProperty("logicalConnections")
    private WrappedCollection<List<LogicalConnectionDTO>> logicalConnectionWrapper;

    @JsonProperty("links")
    private WrappedCollection<List<LinkDTO>> linkWrapper;

}
