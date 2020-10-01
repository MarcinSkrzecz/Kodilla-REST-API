package com.crud.tasks.domain.trello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrelloDto {
    private int board;
    private int card;
}
