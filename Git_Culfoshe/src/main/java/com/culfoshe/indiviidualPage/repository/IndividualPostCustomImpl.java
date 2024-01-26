package com.culfoshe.indiviidualPage.repository;

import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.QIndividualPost;
import com.culfoshe.indiviidualPage.dto.IndividualPostPreviewDTO;
import com.culfoshe.indiviidualPage.dto.QIndividualPostPreviewDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


public class IndividualPostCustomImpl implements IndividualPostCustom{

    private JPAQueryFactory queryFactory;

    public IndividualPostCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression searchByLike(String domain){
        return QIndividualPost.individualPost.individualMem.individualDomain.like("%"+domain+"%");
    }

    public List<IndividualPostPreviewDTO> getIndividualPostPreview(Pageable pageable, String domain) {

        QIndividualPost individualPost = QIndividualPost.individualPost;

        List<IndividualPostPreviewDTO> content = queryFactory.select(
                new QIndividualPostPreviewDTO(
                        individualPost.postCode,
                        individualPost.postTitle,
                        individualPost.postCategory,
                        individualPost.postComment)
                )
                .from(individualPost)
                .where(searchByLike(domain))
                .orderBy(QIndividualPost.individualPost.postCode.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return content;
    }

    @Override
    public List<IndividualPost> getIndividualPostPreviewRe(Pageable pageable, String domain) {

        QIndividualPost individualPost = QIndividualPost.individualPost;

        List<IndividualPost> content = queryFactory
                .selectFrom(individualPost)
                .where(searchByLike(domain))
                .orderBy(QIndividualPost.individualPost.postCode.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();


        return content;
    }

}
