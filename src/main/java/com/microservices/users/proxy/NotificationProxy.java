package com.microservices.users.proxy;

import com.microservices.shared_utils.statusResponces.StatusResponse;
import com.microservices.users.exceptions.ErrorHandlingRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notifications")
public interface NotificationProxy {

    @PostMapping("/notifications/error-reporting/report")
    StatusResponse reportError(@RequestBody ErrorHandlingRequest errorHandlingRequest);

}
