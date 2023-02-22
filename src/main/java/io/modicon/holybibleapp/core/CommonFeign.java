package io.modicon.holybibleapp.core;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "holy-bible-client", url = "https://bible-go-api.rkeplin.com/v1/")
public interface CommonFeign {
}
