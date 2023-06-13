package com.example.ads.model.utility;

import com.example.ads.model.dto.TimeCardDTO;
import com.example.ads.model.entity.TimeCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeCardConvertToTimeCardDTO {

    private final List<TimeCard> timeCardList;

    public TimeCardConvertToTimeCardDTO(List<TimeCard> timeCardList){
        this.timeCardList = timeCardList;
    }

    public List<TimeCardDTO> createTimeCardDTOList(){
        List<TimeCardDTO> timeCardDTOList = new ArrayList<>();
        this.timeCardList.stream().forEach(timeCard -> {
            try {
                TimeCardDTO timeCardDTO = new TimeCardDTO(timeCard);
                timeCardDTOList.add(timeCardDTO);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        return Collections.unmodifiableList(timeCardDTOList);
    }

}
