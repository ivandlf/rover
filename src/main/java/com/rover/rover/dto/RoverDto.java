package com.rover.rover.dto;

import com.rover.rover.models.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoverDto {
    public Long id;
    public Integer x;
    public Integer y;
    public Direction direction;
}
