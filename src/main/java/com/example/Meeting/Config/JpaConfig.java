package com.example.Meeting.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * JpaConfig 통해서 데이터베이스 관련 빈 관리 가능
 * @EnableJpaAuditing으로 JPA Auditing 활성화해 엔티티의 수정,생성시간 자동 추적가능
 */
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
