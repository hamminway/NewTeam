package com.culfoshe.main.repository;

import com.culfoshe.main.dto.MainViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class MainRepositoryImpl implements MainRepository{

    @Override
    public Page<MainViewDTO> getMainViewPage(Pageable pageable) {
        return null;
    }
}
