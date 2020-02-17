package racingcar.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

/**
 * 클래스 이름 : NameTest.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * * @version 1.0
 * <p>
 * 날짜 : 2020/02/15
 */
public class NameTest {

	@Test
	@DisplayName("Name 생성자 정상 케이스 테스트")
	void Name_생성자_테스트() {
		//given
		String inputCarName = "toney";
		//when
		Name carName = new Name(inputCarName);
		//then
		assertThat(carName).isInstanceOf(Name.class);
	}

	@ParameterizedTest
	@DisplayName("Name 생성자 비정상 케이스 테스트 : null, 빈문자 입력")
	@NullAndEmptySource
	void Name_null_또는_빈문자열일시_예외처리(String inputCarName) {
		assertThatThrownBy(() -> {
			new Name(inputCarName);
		}).isInstanceOfAny(IllegalArgumentException.class, NullPointerException.class);
	}

	@Test
	@DisplayName("Name 생성자 비정상 케이스 테스트 : 공백 포함")
	void Name_공백이_포함될시_예외처리() {
		//given
		String inputCarName = "to m";
		//when then
		assertThatIllegalArgumentException().isThrownBy(() -> new Name(inputCarName));
	}

	@Test
	@DisplayName("Name 생성자 비정상 케이스 테스트 : 5자 이상")
	void Name_5자_이상_문자열_입력시_예외처리() {
		//given
		String inputCarName = "toneyparky";
		//when then
		assertThatIllegalArgumentException().isThrownBy(() -> new Name(inputCarName));
	}
}
