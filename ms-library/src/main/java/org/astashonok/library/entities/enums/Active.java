package org.astashonok.library.entities.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Active {

  Y(true),
  N(false);

  private final boolean isActive;
}
