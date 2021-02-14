package com.cgh.book.springboot.domain.posts;

import com.cgh.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter             //lombok annotation. Getter 메서드 자동생성
@NoArgsConstructor  //lombok annotation. 필수는 아님. 기본 생성자 자동 추가
@Entity             //JPA annotation
public class Posts extends BaseTimeEntity {    //실제 DB테이블과 매칭될 클래스. Entity 클래스. 이 클래스를 수정해 DB작업.
    @Id     //해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성규칙.
    private long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼.굳이 안해도 됨.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    //해당 클래스의 빌더 패턴 클래스를 생성.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
