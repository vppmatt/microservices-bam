package uk.multicode.bam.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserServiceDownController {

    @RequestMapping("/userServiceDown")
    public Map<String, Integer> userServiceDown() {
        Map<String, Integer> result = new HashMap<>();
        result.put("id",-99);
        return result;
    }
}
