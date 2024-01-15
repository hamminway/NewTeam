package com.culfoshe.repository;

import com.culfoshe.dto.MainViewDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface LocationRepositoryCustom {

    Page<MainViewDTO> getMainLocationPage(Pageable pageable);
}
