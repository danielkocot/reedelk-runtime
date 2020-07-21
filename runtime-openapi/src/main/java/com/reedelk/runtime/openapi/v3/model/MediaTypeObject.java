package com.reedelk.runtime.openapi.v3.model;

import com.reedelk.runtime.openapi.v3.AbstractOpenApiSerializable;
import com.reedelk.runtime.openapi.v3.OpenApiSerializableContext;

import java.util.LinkedHashMap;
import java.util.Map;

public class MediaTypeObject extends AbstractOpenApiSerializable {

    private ExampleReference example;
    private SchemaReference schema;

    public ExampleReference getExample() {
        return example;
    }

    public void setExample(ExampleReference example) {
        this.example = example;
    }

    public SchemaReference getSchema() {
        return schema;
    }

    public void setSchema(SchemaReference schema) {
        this.schema = schema;
    }

    @Override
    public Map<String,Object> serialize(OpenApiSerializableContext context) {
        Map<String, Object> map = new LinkedHashMap<>();

        // TODO:
        //JsonSchemaUtils.setSchema(context, serialized, PredefinedSchema.NONE, schema);
        // TODO:
        //set(map, "example", example);
        return map;
    }
}
