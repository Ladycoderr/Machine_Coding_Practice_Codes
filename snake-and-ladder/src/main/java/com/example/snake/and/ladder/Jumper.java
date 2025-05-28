package com.example.snake.and.ladder;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
//if ladder startpoint<endpoint if snake startpoint>endpoint;
public class Jumper {
    int startPoint;
    int endPoint;
}
