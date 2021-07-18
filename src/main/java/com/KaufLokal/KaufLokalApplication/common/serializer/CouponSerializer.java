package com.KaufLokal.KaufLokalApplication.common.serializer;

import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CouponSerializer extends JsonSerializer<Coupon> {
    @Override
    public void serialize(Coupon value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("id", value.getId().toString());
        jgen.writeStringField("name", value.getName());
        jgen.writeStringField("description", value.getDescription());
        jgen.writeStringField("couponCode", value.getCouponCode().toString());

        if (value.getExpiryDate() == null) {
            jgen.writeStringField("expiryDate", "");
        }else{
            jgen.writeStringField("expiryDate", value.getExpiryDate().toString());
        }

        if (value.getValue() == null) {
            jgen.writeStringField("value", "");
        }else{
            jgen.writeStringField("value", value.getValue().toString());
        }

        if (value.getCreated() == null) {
            jgen.writeStringField("created", "");
        }else{
            jgen.writeStringField("created", value.getCreated().toString());
        }
        jgen.writeEndObject();
    }
}
