package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.trello.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        TrelloList a = new TrelloList("111","AAA",true);
        TrelloList b = new TrelloList("222","BBB",true);

        trelloList.add(a);
        trelloList.add(b);

        List<TrelloBoard> trelloBoard = new ArrayList<>();
        TrelloBoard aaa = new TrelloBoard("0","AAAAA",trelloList);

        trelloBoard.add(aaa);

        //When
        List<TrelloBoardDto> trelloBoardDto = trelloMapper.mapToBoardsDto(trelloBoard);

        //Then
        assertEquals(1, trelloBoardDto.size());
        assertEquals(1, trelloBoard.size());
        assertEquals(2, trelloList.size());
        assertEquals(trelloBoard.get(0).getId(), trelloBoardDto.get(0).getId());
        assertEquals(trelloBoard.get(0).getName(), trelloBoardDto.get(0).getName());
        assertEquals(trelloBoard.get(0).getLists().get(0).getId(), trelloBoardDto.get(0).getLists().get(0).getId());
        assertEquals(trelloBoard.get(0).getLists().get(0).getName(), trelloBoardDto.get(0).getLists().get(0).getName());
        assertEquals(trelloBoard.get(0).getLists().get(0).isClosed(), trelloBoardDto.get(0).getLists().get(0).isClosed());
        assertEquals(trelloBoard.get(0).getLists().get(1).getId(), trelloBoardDto.get(0).getLists().get(1).getId());
        assertEquals(trelloBoard.get(0).getLists().get(1).getName(), trelloBoardDto.get(0).getLists().get(1).getName());
        assertEquals(trelloBoard.get(0).getLists().get(1).isClosed(), trelloBoardDto.get(0).getLists().get(1).isClosed());
    }

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        TrelloListDto a = new TrelloListDto("111","AAA",true);
        TrelloListDto b = new TrelloListDto("222","BBB",true);

        trelloListDto.add(a);
        trelloListDto.add(b);

        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        TrelloBoardDto aaa = new TrelloBoardDto("0","AAAAA",trelloListDto);

        trelloBoardDto.add(aaa);

        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardDto);

        //Then
        assertEquals(1, trelloBoardDto.size());
        assertEquals(1, trelloBoard.size());
        assertEquals(2, trelloListDto.size());
        assertEquals(trelloBoard.get(0).getId(), trelloBoardDto.get(0).getId());
        assertEquals(trelloBoard.get(0).getName(), trelloBoardDto.get(0).getName());
        assertEquals(trelloBoard.get(0).getLists().get(0).getId(), trelloBoardDto.get(0).getLists().get(0).getId());
        assertEquals(trelloBoard.get(0).getLists().get(0).getName(), trelloBoardDto.get(0).getLists().get(0).getName());
        assertEquals(trelloBoard.get(0).getLists().get(0).isClosed(), trelloBoardDto.get(0).getLists().get(0).isClosed());
        assertEquals(trelloBoard.get(0).getLists().get(1).getId(), trelloBoardDto.get(0).getLists().get(1).getId());
        assertEquals(trelloBoard.get(0).getLists().get(1).getName(), trelloBoardDto.get(0).getLists().get(1).getName());
        assertEquals(trelloBoard.get(0).getLists().get(1).isClosed(), trelloBoardDto.get(0).getLists().get(1).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("AAA", "BBB","CCC","0");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("AAA", "BBB","CCC","0");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        TrelloList a = new TrelloList("111","AAA",true);
        TrelloList b = new TrelloList("222","BBB",true);

        trelloList.add(a);
        trelloList.add(b);

        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);

        //Then
        assertEquals(2, trelloList.size());
        assertEquals(2, trelloListDto.size());
        assertEquals(trelloList.get(0).getId(), trelloListDto.get(0).getId());
        assertEquals(trelloList.get(0).getName(), trelloListDto.get(0).getName());
        assertEquals(trelloList.get(0).isClosed(), trelloListDto.get(0).isClosed());
        assertEquals(trelloList.get(1).getId(), trelloListDto.get(1).getId());
        assertEquals(trelloList.get(1).getName(), trelloListDto.get(1).getName());
        assertEquals(trelloList.get(1).isClosed(), trelloListDto.get(1).isClosed());
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        TrelloListDto a = new TrelloListDto("111","AAA",true);
        TrelloListDto b = new TrelloListDto("222","BBB",true);

        trelloListDto.add(a);
        trelloListDto.add(b);

        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDto);

        //Then
        assertEquals(2, trelloList.size());
        assertEquals(2, trelloListDto.size());
        assertEquals(trelloList.get(0).getId(), trelloListDto.get(0).getId());
        assertEquals(trelloList.get(0).getName(), trelloListDto.get(0).getName());
        assertEquals(trelloList.get(0).isClosed(), trelloListDto.get(0).isClosed());
        assertEquals(trelloList.get(1).getId(), trelloListDto.get(1).getId());
        assertEquals(trelloList.get(1).getName(), trelloListDto.get(1).getName());
        assertEquals(trelloList.get(1).isClosed(), trelloListDto.get(1).isClosed());
    }
}
