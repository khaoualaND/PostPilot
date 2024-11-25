package postpilote.social_media_integration_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import postpilote.social_media_integration_service.service.SocialMediaService;

@RestController
@RequestMapping("/api/social")
@RequiredArgsConstructor
public class SocialMediaController {

    private final SocialMediaService socialMediaService;

    @PostMapping("/post")
    public ResponseEntity<String> postToSocialMedia(
            @RequestParam String platform,
            @RequestParam String userId,
            @RequestParam String message) {
        String response;
        switch (platform.toLowerCase()) {
            case "facebook":
                response = socialMediaService.postToFacebook(userId, message);
                break;
            case "twitter":
                response = socialMediaService.postToTwitter(userId, message);
                break;
            case "instagram":
                response = socialMediaService.postToInstagram(userId, message);
                break;
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
        return ResponseEntity.ok(response);
    }
}

