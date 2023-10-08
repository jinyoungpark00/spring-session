package com.likelionstudy.springstudy.dto.response.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.likelionstudy.springstudy.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // data 객체임을 알림
@AllArgsConstructor
public class MemberGetResponse {

    // JSON에서 이 값이 key가 되서, 실제 넣는 값이 value로 들어감

    @JsonProperty("name") // key 이름 지정해줄 수 있음.
    private String name;
    private String nickname;

    public static MemberGetResponse of(MemberEntity member){
        return new MemberGetResponse(member.getUsername(), member.getNickname());
    }
}
