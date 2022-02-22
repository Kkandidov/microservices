package org.astashonok.msgallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsGalleryApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsGalleryApplication.class, args);
  }

}
