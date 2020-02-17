package racingcar.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 클래스 이름 : CarTest.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class CarTest {
	@Test
	@DisplayName("Car 생성자 테스트")
	void Car_생성자_정상_케이스_테스트() {
		//given
		String inputCarName = "toney";
		//when
		Car car = new Car(inputCarName);
		//then
		assertThat(car).isInstanceOf(Car.class);
	}

	@Test
	@DisplayName("3이하일 경우 움직이지 않는다.")
	void goOrNot_랜덤숫자가_3이하라서_position_moveForward_실행안함() {
		final int randomNumber = 3;
		final Car car = new Car("toney");
		final Position expectedPosition = new Position();
		car.goOrNot(randomNumber);
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}

	@Test
	@DisplayName("4이상일 경우 움직인다.")
	void goOrNot_랜덤숫자가_4이상일때만_position_moveForward() {
		final int randomNumber = 4;
		final Car car = new Car("toney");
		final Position expectedPosition = new Position(1);
		car.goOrNot(randomNumber);
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}

	@Test
	@DisplayName("포지션이 더 크면 true 반환")
	void comparePosition_파라미터로_들어온_객체보다_포지션이_크면_true로_반환() {
		Car one = new Car("작은곰", 5);
		Car two = new Car("보스독", 1);
		assertThat(one.comparePosition(two)).isTrue();
	}
}
