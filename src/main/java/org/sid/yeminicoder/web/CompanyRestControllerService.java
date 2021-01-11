package org.sid.yeminicoder.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class CompanyRestControllerService {

    @Value("${xparam}")
    private int xParam ;
    @Value("${yparam}")
    private int yParam;
    @Value("${email}")
    private String email;

    @RequestMapping("/compConfig")
    public ResponseEntity<?> getConfig() {

        Map<String, Object> params = new HashMap<>();
        params.put("xParam", xParam);
        params.put("yParam", yParam);
        params.put("email", email);
        params.put("threadName", Thread.currentThread().getName());

        // some business logic here
        return ResponseEntity.ok().body(params);
    }

}
