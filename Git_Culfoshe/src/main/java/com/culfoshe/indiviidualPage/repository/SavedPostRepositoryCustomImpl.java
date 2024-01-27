package com.culfoshe.indiviidualPage.repository;

import com.culfoshe.entity.QIndividualPost;
import com.culfoshe.entity.QSavedPost;
import com.culfoshe.indiviidualPage.dto.QSavedPostDTO;
import com.culfoshe.indiviidualPage.dto.SavedPostDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j @Repository
public class SavedPostRepositoryCustomImpl implements SavedPostRepositoryCustom {
    private JPAQueryFactory queryFactory;

    public SavedPostRepositoryCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression searchByLike(String domain){
        return QIndividualPost.individualPost.individualMem.individualDomain.like("%"+domain+"%");
    }

    @Override
    public Page<SavedPostDTO> getSavedPost(Pageable pageable, Long id) {
        log.info("SavedPostCustom.getSavedPost");
        QSavedPost savedPost = QSavedPost.savedPost;
        QIndividualPost individualPost = QIndividualPost.individualPost;

        List<SavedPostDTO> content = queryFactory.select(
                new QSavedPostDTO(
                        individualPost.postCode,
                        individualPost.postTitle,
                        individualPost.postViewCount,
                        individualPost.postSaveCount,
                        individualPost.regTime,
                        individualPost.createdBy,
                        individualPost.location )
                )
                .from(savedPost)
                .join(savedPost.individualPost)
                .where(savedPost.individualMem.id.eq(id))
                .orderBy(individualPost.regTime.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long totalCount = queryFactory.select(Wildcard.count)
                .from(savedPost)
                .join(savedPost.individualPost)
                .where(savedPost.individualMem.id.eq(id))
                .fetchOne();

        return new PageImpl<>(content, pageable, totalCount);
    }
}
