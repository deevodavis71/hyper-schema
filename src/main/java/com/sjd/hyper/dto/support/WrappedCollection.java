package com.sjd.hyper.dto.support;

import lombok.Data;

@Data
public class WrappedCollection<T> {

    private T items;

}
