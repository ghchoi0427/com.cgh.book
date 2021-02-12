package dto;

import org.junit.Test;
import web.dto.HelloResponseDto;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);  //assertj 검증 라이브러리 메서드.
        assertThat(dto.getAmount()).isEqualTo(amount);//검증하고픈 대상을 인자로 받음. 메소드 체이닝 지원

    }
}
