package restaurant.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderRequest {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("special_requests")
    private String specialRequests;
}
