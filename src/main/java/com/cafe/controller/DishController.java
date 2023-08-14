package com.cafe.controller;

import com.cafe.pojo.Dish;
import com.cafe.pojo.Result;
import com.cafe.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3ClientBuilder;
import software.amazon.awssdk.services.s3.model.*;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Slf4j
@RestController
@RequestMapping("/dishes")
@CrossOrigin(origins = "${FRONTEND_ENDPOINT}")
public class DishController {

    @Autowired
    private DishService dishService;

    @Value("${IMAGE_BUCKET_ENDPOINT}")
    private String imageBucketEndpoint;

    @Value("${IMAGE_BUCKET_ACCESS_KEY}")
    private String imageBucketAccessKey;

    @Value("${IMAGE_BUCKET_SECRET_ACCESS_KEY}")
    private String imageBucketSecretAccessKey;

    @Value("${IMAGE_BUCKET_NAME}")
    private String imageBucketName;

    /*----------------------GetMapping-----------------*/
    @GetMapping
    public Result list(){
        log.info("Search all dish data");
        List<Dish> dishList = dishService.list();
        return Result.success(dishList);
    }

    @GetMapping("/filter")
    public Result selectByFilter(@RequestParam(required = false) Integer dishId,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Integer categoryId){
        log.info("Select filtered dishes");
        List<Dish> dishList = dishService.selectByFilter(dishId, name, categoryId);
        return Result.success(dishList);
    }

    @GetMapping("/{dishId}")
    public Result selectByOneId(@PathVariable Integer dishId){
        log.info("Get one list by its ID");
        Dish dish = dishService.selectByOneId(dishId);
        return Result.success(dish);
    }

    @GetMapping("/category/{categoryId}")
    public Result selectByCategoryId(@PathVariable Integer categoryId){
        log.info("Get one list by its ID");
        List<Dish> dishList = dishService.selectByCategoryId(categoryId);
        return Result.success(dishList);
    }


    /*----------------------DeleteMapping-----------------*/
    @DeleteMapping("/{dishId}")
    public Result deleteByOneId(@PathVariable Integer dishId){
        log.info("Delete one dish by its ID: {}", dishId);
        dishService.deleteByOneId(dishId);
        return Result.success();
    }

    @DeleteMapping
    public Result deleteByIds(List<Integer> dishIds){
        log.info("Delete by Multiple Ids");
        dishService.deleteByIds(dishIds);
        return Result.success();
    }

    /*----------------------------update---------------------*/

    @PutMapping
    public Result updateDish(@RequestBody Dish dish){
        log.info("update list");
        dishService.updateDish(dish);
        return Result.success();
    }


    /*----------------------------insert---------------------*/
    @PostMapping
    public Result addDish(@RequestBody Dish dish) throws URISyntaxException {
        log.info("add another dish: {}", dish);
        dishService.insert(dish);
        return Result.success(dish);
    }

    @PostMapping(value="/image")
    public ResponseEntity<Result> uploadImage(MultipartFile image) throws URISyntaxException, IOException {
        log.info("Upload image to S3 with key as {}", image.getName());
        InputStream inputStream = image.getInputStream();
        String url = uploadFileToS3(inputStream.readAllBytes());
        return ResponseEntity.ok(Result.success(url));
    }

    private String uploadFileToS3(byte[] data) throws URISyntaxException {
        URI endpoint = new URI(imageBucketEndpoint);
        AwsCredentials creds = AwsBasicCredentials.create(imageBucketAccessKey, imageBucketSecretAccessKey);
        AwsCredentialsProvider provider = StaticCredentialsProvider.create(creds);
        String key = UUID.randomUUID().toString();
        final S3Client s3Client =
                S3Client.builder()
                        .region(Region.US_EAST_1)
                        .forcePathStyle(false)
                        .credentialsProvider(provider)
                        .endpointOverride(endpoint).build();
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(imageBucketName)
                .key(key)
                .acl(ObjectCannedACL.PUBLIC_READ)
                .build();
        software.amazon.awssdk.core.sync.RequestBody body = software.amazon.awssdk.core.sync.RequestBody.fromBytes(data);
        PutObjectResponse response = s3Client.putObject(request, body);
        GetUrlRequest urlRequest = GetUrlRequest.builder().bucket(imageBucketName).key(key).build();
        String imageUrl = s3Client.utilities().getUrl(urlRequest).toExternalForm();

        if (!response.sdkHttpResponse().isSuccessful()) {
            throw new RuntimeException("Failed to upload image to s3.");
        }

        return imageUrl;
        /*
        if (!response.sdkHttpResponse().isSuccessful()) {
            throw new RuntimeException("Failed to upload image to s3.");
        }
        return s3Client.utilities().getUrl(urlRequest).toExternalForm();*/
    }
}
