package com.culfoshe.indiviidualPage.repository;

import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.QIndividualPhoto;
import com.culfoshe.entity.QIndividualPost;
import com.culfoshe.indiviidualPage.dto.IndividualPostPreviewDTO;
import com.culfoshe.indiviidualPage.dto.QIndividualPostPreviewDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class IndividualPostCustomImpl implements IndividualPostCustom{

    private JPAQueryFactory queryFactory;

    public IndividualPostCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression searchByLike(String domain){
        return QIndividualPost.individualPost.individualMem.individualDomain.like("%"+domain+"%");
    }

    private BooleanExpression searchByLikeForPartnerMem(String domain){
        return QIndividualPost.individualPost.partnerMem.partnerDomain.like("%"+domain+"%");
    }



    public List<IndividualPostPreviewDTO> getIndividualPostPreview(Pageable pageable, String userName) {

        QIndividualPost individualPost = QIndividualPost.individualPost;
        QIndividualPhoto individualPhoto = QIndividualPhoto.individualPhoto;

        List<IndividualPostPreviewDTO> content = queryFactory.select(
                new QIndividualPostPreviewDTO(
                        individualPost.postCode,
                        individualPost.postTitle,
                        individualPost.postCategory,
                        individualPost.postComment,
                        individualPhoto.imgUrl)
                )
                .from(individualPost)
                .where(searchByLike(userName))
                .where(individualPhoto.repImgYn.eq("Y")) //대표이미지만 불러옴
                .orderBy(QIndividualPost.individualPost.postCode.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return content;
    }

    public List<IndividualPostPreviewDTO> getIndividualPostPreviewForPartnerMem(Pageable pageable, String partnerDomain) {

        QIndividualPost individualPost = QIndividualPost.individualPost;
        QIndividualPhoto individualPhoto = QIndividualPhoto.individualPhoto;

        List<IndividualPostPreviewDTO> content = queryFactory.select(
                new QIndividualPostPreviewDTO(
                        individualPost.postCode,
                        individualPost.postTitle,
                        individualPost.postCategory,
                        individualPost.postComment,
                        individualPhoto.imgUrl)
                )
                .from(individualPhoto)
                .join(individualPhoto.individualPost, individualPost)
                .where(searchByLikeForPartnerMem(partnerDomain))
                .where(individualPhoto.repImgYn.eq("Y")) //대표이미지만 불러옴
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
