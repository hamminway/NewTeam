package com.culfoshe.repository;

import com.culfoshe.dto.MainLocationDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface LocationRepositoryCustom {

    Page<MainLocationDTO> getMainLocationPage(Pageable pageable);
}
