package com.sjd.hyper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.customProperties.HyperSchemaFactoryWrapper;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import com.fasterxml.jackson.module.jsonSchema.factories.VisitorContext;
import com.sjd.hyper.dto.CustomerOrderDTO;
import com.sjd.hyper.dto.LogicalConnectionDTO;
import com.sjd.hyper.dto.TopologyDTO;
import com.sjd.hyper.dto.support.WrappedCollection;

public class Main {

    public static class VisitorContextWithoutSchemaInlining extends VisitorContext {
        @Override
        public String addSeenSchemaUri(JavaType aSeenSchema) {
            return getSeenSchemaUri(aSeenSchema);
        }

        @Override
        public String getSeenSchemaUri(JavaType aSeenSchema) {
            return isModel(aSeenSchema) ? javaTypeToUrn(aSeenSchema) : null;
        }

        protected boolean isModel(JavaType type) {
            boolean ret = type.getRawClass() != String.class
                    && !isBoxedPrimitive(type)
                    && !type.isPrimitive()
                    && !type.isMapLikeType()
                    && !type.isCollectionLikeType()
                    && !type.isArrayType();

            return ret;
        }

        protected static boolean isBoxedPrimitive(JavaType type) {
            boolean ret = type.getRawClass() == Boolean.class
                    || type.getRawClass() == Byte.class
                    || type.getRawClass() == Long.class
                    || type.getRawClass() == Integer.class
                    || type.getRawClass() == Short.class
                    || type.getRawClass() == Float.class
                    || type.getRawClass() == Double.class;

            return ret;
        }
    }

    public static JsonSchema getHyperSchema (Class<?> c) throws Exception {

        HyperSchemaFactoryWrapper visitor = new HyperSchemaFactoryWrapper();
        ObjectMapper m = new ObjectMapper();

        visitor.setVisitorContext(new VisitorContextWithoutSchemaInlining());

        m.acceptJsonFormatVisitor(c, visitor);
        JsonSchema jsonSchema = visitor.finalSchema();

        System.out.println(m.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));

        return jsonSchema;
    }

    public static void main(String[] args) throws Exception {

        // Setup the domain

        /*
        CustomerOrderDTO order = new CustomerOrderDTO();

        TopologyDTO top = new TopologyDTO();
        order.setTopology(top);

        LogicalConnectionDTO conn1 = new LogicalConnectionDTO();
        LogicalConnectionDTO conn2 = new LogicalConnectionDTO();

        top.setLogicalConnectionWrapper(new WrappedCollection<>());
        top.getLogicalConnectionWrapper().setItems(new ArrayList<>());
        top.getLogicalConnectionWrapper().getItems().add(conn1);
        top.getLogicalConnectionWrapper().getItems().add(conn2);
        */


        // Get the schemas

        JsonSchema o = getHyperSchema(CustomerOrderDTO.class);
        JsonSchema t = getHyperSchema(TopologyDTO.class);




    }
}
