//package com.boston.OutdoorsApi.AWS.StorageConfig;
//
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.amazonaws.services.s3.model.S3Object;
//import com.amazonaws.services.s3.model.S3ObjectInputStream;
//
//import com.amazonaws.util.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//
//
//@Service
//public class StorageService {
//
//
//    @Value("${application.bucket.name}")
//    private String bucket;
//
//    @Autowired
//    private AmazonS3 amazonS3;
//
//    public String uploadFile(MultipartFile file){
//        File fileobj = convertMultipartFileToFile(file);
//        String filename = System.currentTimeMillis()+"_"+file.getOriginalFilename();
//        amazonS3.putObject(new PutObjectRequest(bucket, filename, fileobj));
//        fileobj.delete();
//        return "File uploaded:" + filename;
//    }
//
//
//    public byte[] downloadFile(String fileName)
//    {
//        S3Object s3Object = amazonS3.getObject(bucket, fileName);
//        S3ObjectInputStream inputStream = s3Object.getObjectContent();
//
//        try {
//            byte[] content = IOUtils.toByteArray(inputStream);
//            return content;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//    private File convertMultipartFileToFile(MultipartFile file){
//        File convertedFile = new File(file.getOriginalFilename());
//        try(FileOutputStream fos = new FileOutputStream(convertedFile)){
//            fos.write(file.getBytes());
//        }catch (IOException e){
//            System.out.println("Error converting multipart file to File");
//        }
//        return convertedFile;
//    }
//
//    public String deleteFile(String fileName){
//        amazonS3.deleteObject(bucket, fileName);
//        return "File: "+fileName+" Deleted";
//    }
//}
