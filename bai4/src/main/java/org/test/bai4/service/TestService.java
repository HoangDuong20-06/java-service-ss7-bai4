package org.test.bai4.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public void findData() {
        throw new org.test.bai4.exception.ResourceNotFoundException("Không tìm thấy dữ liệu có ID = 999");
    }
}
