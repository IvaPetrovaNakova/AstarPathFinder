package com.reachUp.AStar.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PathDTO {
    private String from;
    private String to;
    private int cost;
}
