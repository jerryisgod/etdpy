package com.etdpy.serviceImp;
import com.etdpy.dao.LoginRecordRepo;
import com.etdpy.entity.LoginRecord;
import com.etdpy.service.LoginRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginRecordServiceImpl implements LoginRecordService  {
    @Autowired
    private LoginRecordRepo loginRecordRepo;

    @Override
    public List<LoginRecord> getRecentLoginRecords(String username) {
        return loginRecordRepo.findByUsernameOrderByLoginTimeDesc(username);
    }
}


