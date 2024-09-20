package com.etdpy.serviceImp;
import com.etdpy.dao.LoginRecordRepo;
import com.etdpy.entity.LoginRecord;
import com.etdpy.service.LoginRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginRecordServiceImpl implements LoginRecordService  {
    @Autowired
    private LoginRecordRepo loginRecordRepo;

    @Override
    public List<LoginRecord> getRecentLoginRecords(String username) {
        Pageable pageable = PageRequest.of(0, 10); // 撈取前11筆資料 可調整
        return loginRecordRepo.findByUsernameOrderByLoginTimeDesc(username,pageable);
    }
}


