package com.adidas.backend.adiclubservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
//@JsonDeserialize(builder = AdiClubMemberInfoDto.AdiClubMemberInfoDtoBuilder.class)
public class AdiClubMemberInfoDto {
  private String email;
  private Integer points;
  private Instant registrationDate;

  @JsonCreator
  public AdiClubMemberInfoDto(@JsonProperty("email") String email, @JsonProperty("points") int points, @JsonProperty("registrationDate") Instant registrationDate) {
    this.email = email;
    this.points = points;
    this.registrationDate = registrationDate;
  }


}
