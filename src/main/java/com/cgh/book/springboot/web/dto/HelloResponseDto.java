package com.cgh.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter     //선언된 필드의 get 메소드 생성
@RequiredArgsConstructor    //final 필드가 포함된 생성자를 생성(final 없는 필드 제외)
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
