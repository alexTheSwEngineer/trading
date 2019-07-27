package com.traderepublic.atrposki.core.instruments.models;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
public class InstrumentEventDto {
    private int id;
    private String isin;
    private String description;

    @JsonProperty("type")
    private String action;

    @JsonProperty("data")
    private void unpackIsinAndDescriptionFromData(Map<String, String> data) {
        isin = data.getOrDefault("isin","");
        description = data.getOrDefault("description","");
    }

    //public static InstrumentEventDto fromRecord(Record4<>)
}
