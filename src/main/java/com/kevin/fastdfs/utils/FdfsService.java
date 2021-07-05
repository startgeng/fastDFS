package com.kevin.fastdfs.utils;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-07-05 22:04
 */
public class FdfsService {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 文件上传
     * @param multipartFile
     * @param fileExtName 后缀名
     * @return
     */
    public String upload(MultipartFile multipartFile,String fileExtName) throws IOException {
        StorePath storePath = fastFileStorageClient.uploadFile(multipartFile.getInputStream(),
                multipartFile.getSize(),
                fileExtName,
                null);
        String fullPath = storePath.getFullPath();
        return fullPath;
    }
}
