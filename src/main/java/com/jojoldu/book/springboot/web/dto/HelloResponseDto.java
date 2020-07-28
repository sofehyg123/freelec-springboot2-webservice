package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //getter setter, 기본생성자 toString 등.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
