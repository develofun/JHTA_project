package net.stylesolo.www.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Util {
	private String accessKey = "";
    private String secretKey = "";
     
    private AmazonS3 conn;
     
    public S3Util() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTP);
        this.conn = new AmazonS3Client(credentials, clientConfig);
        conn.setEndpoint("s3-ap-northeast-2.amazonaws.com");
    }
     
    // Bucket List
    public List<Bucket> getBucketList() {
        return conn.listBuckets();
    }
     
    // Bucket 생성
    public Bucket createBucket(String bucketName) {
        return conn.createBucket(bucketName);
    }
     
    // 폴더 생성 (폴더는 파일명 뒤에 "/"를 붙여야한다.)
    public void createFolder(String bucketName, String folderName) {
        conn.putObject(bucketName, folderName + "/", new ByteArrayInputStream(new byte[0]), new ObjectMetadata());
    }
     
    // 파일 업로드
    public void fileUpload(String bucketName, File file) {
    	try{
    		conn.putObject(bucketName, file.getName(), new FileInputStream(file), new ObjectMetadata());
    	}catch(FileNotFoundException fe){
    		System.out.println(fe.getMessage());
    	}
    }
     
    // 파일 삭제
    public void fileDelete(String bucketName, String fileName) {
        conn.deleteObject(bucketName, fileName);
    }
     
    // 파일 URL
    public String getFileURL(String bucketName, String fileName) {
        return conn.generatePresignedUrl(new GeneratePresignedUrlRequest(bucketName, fileName)).toString();
    }
    
    // 특정 bucket의 파일 리스트
    public ObjectListing getFileList(String bucketName){
    	ListObjectsRequest listObject=new ListObjectsRequest();
    	listObject.setBucketName(bucketName);
    	/*listObject.setPrefix(folderName);*/
    	
    	ObjectListing objects=conn.listObjects(listObject);
    	do{
    		objects=conn.listObjects(listObject) ;
    		//1000개 단위로 읽음
    		for(S3ObjectSummary objectSummary:objects.getObjectSummaries()){
    			System.out.println(objectSummary);
    		}
    		//objects=conn.listNextBatchOfObjects(objects); <-- 1000개 단위로만 가져옴
    		listObject.setMarker(objects.getNextMarker());
    	}while(objects.isTruncated());
    	
    	return objects;
    }
}
