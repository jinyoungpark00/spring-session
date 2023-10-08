package com.likelionstudy.springstudy.dto.response.box;

import com.likelionstudy.springstudy.domain.entity.BoxEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoxGetResponse {

    private String name;

    public static BoxGetResponse of(BoxEntity box){
        return new BoxGetResponse(box.getName());
    }
}
