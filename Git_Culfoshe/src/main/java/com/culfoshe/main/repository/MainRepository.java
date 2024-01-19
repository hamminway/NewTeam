package com.culfoshe.main.repository;

import com.culfoshe.main.dto.MainViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MainRepository {

    Page<MainViewDTO> getMainViewPage(Pageable pageable);

}
