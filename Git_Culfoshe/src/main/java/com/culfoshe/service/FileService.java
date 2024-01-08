package com.culfoshe.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
@Log
public class FileService {

    public String uploadFile(String uploadPath, String originFileName, byte[] fileData) throws Exception {

        UUID uuid = UUID.randomUUID();

        String extension = originFileName.substring(originFileName.lastIndexOf("."));

        String savedFileName = uuid.toString() + extension;

        //파일 업로드할 전체 경로를 생성
        String fileUploadFullUrl = uploadPath + "/" + savedFileName;

        //예외처리 throws
        //FileOutputStream : byte단위로 파일을 기록하는 클래스
        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);

        fos.write(fileData);

        return savedFileName;   //저장파일명 반환
    }

    //파일 삭제하는 메서드
    public void deleteFile(String filePath) {
        File deleteFile = new File(filePath);

        if(deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일을 삭제하였습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }
}
