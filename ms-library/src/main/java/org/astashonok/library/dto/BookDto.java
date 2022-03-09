package org.astashonok.library.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {

  private String name;
  private int year;
  private int quantity;
}
