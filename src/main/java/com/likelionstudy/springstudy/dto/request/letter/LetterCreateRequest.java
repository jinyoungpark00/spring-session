package com.likelionstudy.springstudy.dto.request.letter;

import com.likelionstudy.springstudy.domain.entity.LetterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LetterCreateRequest {

    private String title;
    private String content;

    public static LetterEntity toLetter(String title, String content){
        return new LetterEntity(title, content);
    }
}
