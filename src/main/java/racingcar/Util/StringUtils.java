package racingcar.Util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 클래스 이름 : StringUtils.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/13
 */

public class StringUtils {
	private static final String DELIMITER = ",";
	private static final String CAR_NAME_NULL_EXCEPTION_MESSAGE = "차 이름으로는 null이 입력될 수 없습니다.";
	private static final String CAR_NAMES_NULL_EXCEPTION_MESSAGE = "차 이름들로는 null이 입력될 수 없습니다.";

	private StringUtils() {
	}

	public static List<String> splitCarNames(final String carNameInput) {
		Objects.requireNonNull(carNameInput, CAR_NAME_NULL_EXCEPTION_MESSAGE);
		return Arrays.asList(carNameInput.split(DELIMITER));
	}

	public static List<String> trimCarNames(final List<String> carNamesInput) {
		Objects.requireNonNull(carNamesInput, CAR_NAMES_NULL_EXCEPTION_MESSAGE);
		return carNamesInput.stream()
				.map(String::trim)
				.collect(Collectors.toList());
	}

}
