package com.etdpy.service;

import com.etdpy.entity.LoginRecord;

import java.util.List;

public interface LoginRecordService {
    List<LoginRecord> getRecentLoginRecords(String username);
}
