package kr.co.broadwave.awss3uploadtest.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author InSeok
 * Date : 2019-12-04
 * Remark :
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Value("${aci.aws.s3.access.id}")
    private String AWSS3ACCESSID;

    @Value("${aci.aws.s3.access.key}")
    private String AWSS3ACCESSKEY;

    @Value("${aci.aws.region}")
    private String AWSREGION;

    @Bean
    public BasicAWSCredentials AwsCredentianls(){
        BasicAWSCredentials AwsCreds = new BasicAWSCredentials(AWSS3ACCESSID,AWSS3ACCESSKEY);
        return AwsCreds;
    }

    @Bean
    public AmazonS3 AwsS3Client(){
        AmazonS3 s3Builder = AmazonS3ClientBuilder.standard()
                .withRegion(AWSREGION)
                .withCredentials(new AWSStaticCredentialsProvider(this.AwsCredentianls()))
                .build();
        return s3Builder;
    }
}
