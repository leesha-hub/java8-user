package dev.lsh.java8user.member.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
public class MemberCreateDTO {
	@NonNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[0-9])[a-z0-9]{4,16}$", message = "아이디는 필수 입력 값입니다(영문소문자/숫자 혼합, 4~16자).")
	private String memId;

	@NonNull
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d|.*[\\W_])[A-Za-z\\d\\W_]{8,16}$", message = "비밀번호는 필수 입력 값입니다(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자)")
	private String memPw;

	private String nickname;

	@NotBlank(message = "이름은 필수 입력 값입니다")
	private String memName;

	@NonNull
	@Pattern(regexp = "^(010|011|016|017|018|019)-\\d{3,4}-\\d{4}$", message = "휴대전화는 필수 입력 값입니다")
	private String phone;

	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "이메일은 필수 입력 값입니다")
	private String email;

	private LocalDateTime insertDateTime;
}