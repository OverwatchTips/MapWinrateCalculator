package com.overwatchtips.mapwinratecalculator.records;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.overwatchtips.mapwinratecalculator.enums.GameResult;

import java.util.Set;

public record OverwatchMatch(@JsonProperty("custom_game") boolean customGame,
                             long duration,
                             @JsonProperty("end_sr") int endSr,
                             @JsonProperty("game_type") String gameType,
                             @JsonProperty("game_version") String gameVersion,
                             @JsonProperty("heroes_played") Set<Set<String>> heroesPlayed,
                             String key,
                             String map,
                             @JsonProperty("player_name") String playerName,
                             String rank,
                             GameResult result,
                             String role,
                             Set<Integer> score,
                             String season, @JsonProperty("season_index") int seasonIndex,
                             @JsonProperty("start_sr") int startSr,
                             long time,
                             String url,
                             @JsonProperty("user_id") long userId,
                             boolean viewable) {

}
