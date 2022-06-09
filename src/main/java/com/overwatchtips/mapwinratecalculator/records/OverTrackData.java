package com.overwatchtips.mapwinratecalculator.records;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public record OverTrackData(Set<OverwatchMatch> games,
                            @JsonProperty("last_evaluated_key") String lastEvaluatedKey,
                            List<String> seasons) {

}
