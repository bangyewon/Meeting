package com.example.Meeting.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

// 공통 Api응답
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) // json 직렬화 시 null 값 안 나오도록
public class ApiResponse<T> {
    private final ResultType resultType;
    private final T data;
    @JsonProperty("message")
    private final String errorMessage;

    // 모든 필드를 초기화하는 생성자
    public ApiResponse(ResultType resultType, T data, String errorMessage) {
        this.resultType = resultType;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    // 성공 응답을 생성하는 정적 메서드
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResultType.SUCCESS, data, null);
    }

    // 실패 응답을 생성하는 정적 메서드
    public static ApiResponse<?> fail(String errorMessage) {
        return new ApiResponse<>(ResultType.FAIL, null, errorMessage);
    }
}
