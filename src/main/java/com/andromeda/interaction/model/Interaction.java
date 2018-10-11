package com.andromeda.interaction.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Interaction {
  private LocalDateTime createdAt;
  private InteractioType type;

}
