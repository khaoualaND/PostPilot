package postpilote.social_media_integration_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SocialMediaAccount {

    @Id
    private String id;              // Combine userId and platform to create a unique ID.
    private String userId;          // The user ID linked to the social media account.
    private String platform;        // Platform name (e.g., "facebook", "twitter").
    private String accessToken;     // OAuth access token to perform actions on behalf of the user.
    private String refreshToken;    // (Optional) Refresh token to renew access token.
}
