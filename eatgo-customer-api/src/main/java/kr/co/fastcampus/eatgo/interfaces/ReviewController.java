package kr.co.fastcampus.eatgo.interfaces;

import io.jsonwebtoken.Claims;
import kr.co.fastcampus.eatgo.application.ReviewService;
import kr.co.fastcampus.eatgo.domain.Review;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/restaurants/{restaurantsId}/reviews")
    public ResponseEntity<?> create(
            @PathVariable Long restaurantsId,
            @Valid @RequestBody Review resource
    ) throws URISyntaxException {
        Review review = reviewService.addReview(restaurantsId, resource);
        String str = "/restaurants/" + restaurantsId + "/reviews/" + review.getId();
        return ResponseEntity.created(new URI(str)).body("{}");
    }
}
