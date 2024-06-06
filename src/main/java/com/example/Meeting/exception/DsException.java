package com.example.Meeting.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class DsException extends RuntimeException {
    /**
     * Seriallizable 구현 이유
     * : 자바의 직렬화(객체를 byte스트림으로 변환해 파일 저장 or 네트워크통해 전송) 위해
     * 1. 객체의 저장,전송
     * 2. 클래스 버전관리
     * 3. 분산환경에서의 사용
     */
    // intellj에서 시리얼 serialVersionUID 자동생성가능
    @Serial
    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public DsException(String message,HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
