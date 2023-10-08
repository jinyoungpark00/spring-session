package com.likelionstudy.springstudy.dto.response.letter;

import com.likelionstudy.springstudy.domain.entity.LetterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LetterGetResponse {

    private String title;
    private String content;

    public static LetterGetResponse of(LetterEntity letter){
        return new LetterGetResponse(letter.getTitle(), letter.getContent());
    }
}
