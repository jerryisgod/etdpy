package com.etdpy.serviceImp;

import com.etdpy.dao.BrandRepo;
import com.etdpy.entity.Brand;
import com.etdpy.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepo brandRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(Long id) {
        Optional<Brand> result = brandRepository.findById(id);
        return result.orElse(null); // 如果找不到返回 null，也可以抛出异常
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
