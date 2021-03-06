package com.crud.tasks.domain.trello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrelloBadgesDto {
    private int votes;
    private TrelloAttachmentsByTypeDto attachmentsByType;
}
