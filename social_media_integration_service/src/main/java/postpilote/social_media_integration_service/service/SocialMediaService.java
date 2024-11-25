package postpilote.social_media_integration_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import postpilote.social_media_integration_service.model.SocialMediaAccount;
import postpilote.social_media_integration_service.repository.SocialMediaAccountRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SocialMediaService {

    private final RestTemplate restTemplate;
    private final SocialMediaAccountRepository accountRepository;  // A repository to fetch account details.

    /**
     * Connect a social media account (OAuth flow)
     */
    public String connectToSocialMedia(String userId, String platform) {
        // This should redirect the user to the social media platform's OAuth login page.
        // After successful authentication, this will return an access token.
        String redirectUrl = getOAuthRedirectUrl(userId, platform);
        return redirectUrl;
    }

    /**
     * Fetches account details from the external service (Account Management Microservice)
     */
    private SocialMediaAccount fetchAccountFromExternalService(String userId, String platform) {
        // Replace with the actual URL of your account management microservice
        String url = "http://account-management-service/api/accounts?userId=" + userId + "&platform=" + platform;
        ResponseEntity<SocialMediaAccount> response = restTemplate.getForEntity(url, SocialMediaAccount.class);
        return response.getBody();
    }

    /**
     * Post content to Facebook
     */
    public String postToFacebook(String userId, String message) {
        SocialMediaAccount account = fetchAccountFromExternalService(userId, "facebook");
        String url = "https://graph.facebook.com/v12.0/me/feed?message=" + message
                + "&access_token=" + account.getAccessToken();
        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);
        return response.getBody();
    }

    /**
     * Post content to Twitter
     */
    public String postToTwitter(String userId, String message) {
        SocialMediaAccount account = fetchAccountFromExternalService(userId, "twitter");
        String url = "https://api.twitter.com/2/tweets";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(account.getAccessToken());
        Map<String, String> body = Map.of("text", message);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response.getBody();
    }

    /**
     * Fetch user profile from Facebook
     */
    public String fetchFacebookProfile(String userId) {
        SocialMediaAccount account = fetchAccountFromExternalService(userId, "facebook");
        String url = "https://graph.facebook.com/v12.0/me?access_token=" + account.getAccessToken();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    /**
     * Fetch user profile from Twitter
     */
    public String fetchTwitterProfile(String userId) {
        SocialMediaAccount account = fetchAccountFromExternalService(userId, "twitter");
        String url = "https://api.twitter.com/2/users/me";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(account.getAccessToken());
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }

    /**
     * Fetch user profile from Instagram (currently not supported for posting)
     */
    public String fetchInstagramProfile(String userId) {
        SocialMediaAccount account = fetchAccountFromExternalService(userId, "instagram");
        String url = "https://graph.instagram.com/me?access_token=" + account.getAccessToken();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    /**
     * Helper method to get OAuth URL for social media platforms (Facebook, Twitter)
     */
    private String getOAuthRedirectUrl(String userId, String platform) {
        // This should return the URL where the user will be redirected for authentication
        switch (platform) {
            case "facebook":
                return "https://www.facebook.com/v12.0/dialog/oauth?client_id=" + "YOUR_FACEBOOK_CLIENT_ID" +
                        "&redirect_uri=http://localhost:8080/facebook/oauth/callback&scope=public_profile,email";
            case "twitter":
                // Similar URL for Twitter OAuth
                return "https://twitter.com/oauth/authorize?client_id=" + "YOUR_TWITTER_CLIENT_ID";
            case "instagram":
                // Similar URL for Instagram OAuth
                return "https://api.instagram.com/oauth/authorize?client_id=" + "YOUR_INSTAGRAM_CLIENT_ID";
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }
}
