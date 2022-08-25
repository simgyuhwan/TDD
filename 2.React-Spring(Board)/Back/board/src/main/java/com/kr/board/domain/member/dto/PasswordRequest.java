package com.kr.board.domain.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordRequest {
    private String oldPassword;
    private String newPassword;
}
