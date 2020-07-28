package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity { //실제 DB의 테이블과 매칭될 클래스 = Entity 클래스

    //롬복의 어노테이션들 : @NoArgsConstructor, @Getter, @Builder
    //JPA의 어노테이션들 : @Id, @GeneratedValue, @Column
    // @Column은 안달아도 기본 제공되지만 추가 옵션이 필요한 경우에 달아논다.
    // 스프링 2.0 버전에서는 GenerationType.IDENTITY를 작성해야 auto_increment가 적용된다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }


}

