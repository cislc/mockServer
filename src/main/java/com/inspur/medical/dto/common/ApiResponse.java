package com.inspur.medical.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private ResHead head;
    private T body;
    
    public static <T> ApiResponse<T> success(T bodyParams) {
        return new ApiResponse<>(new ResHead("3035e47fb4c35f9d2e15d42fcfc8a0dd"), bodyParams);
    }
}
