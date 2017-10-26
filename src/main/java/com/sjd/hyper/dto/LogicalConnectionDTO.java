package com.sjd.hyper.dto;

import com.fasterxml.jackson.module.jsonSchema.annotation.JsonHyperSchema;
import lombok.Data;

@Data
@JsonHyperSchema(pathStart = "http://logicalConn")
public class LogicalConnectionDTO {
}
