package com.cgh.book.springboot.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   //JPA Entity클래스들이 BaseTmeEntity를 상속할 경우 필드들도 칼럼으로 인식하도록 합니다.
@EntityListeners(AuditingEntityListener.class)  //BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
public class BaseTimeEntity {   //모든 엔티티의 상위클래스가 되어 createdDate, modifiedDate를 자동으로 관리

    @CreatedDate    //엔티티가 생성되어 저장될 때 시간이 자동저장됨됨
   private LocalDateTime createdDate;

    @LastModifiedDate   //조회된 엔티티값의 변경 시간이 자동저장됨.
    private LocalDateTime modifiedDate;
}
