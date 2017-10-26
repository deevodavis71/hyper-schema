package com.sjd.hyper.dto.support;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.module.jsonSchema.annotation.JsonHyperSchema;
import com.fasterxml.jackson.module.jsonSchema.annotation.Link;
import com.sjd.hyper.dto.OtherDTO;
import lombok.Data;

@Data
@JsonHyperSchema(pathStart = "http://wrapped", links = {
        @Link(href="/items", rel="items", targetSchema = OtherDTO.class)
})
public class WrappedCollection<T> {

    public T items;

}
