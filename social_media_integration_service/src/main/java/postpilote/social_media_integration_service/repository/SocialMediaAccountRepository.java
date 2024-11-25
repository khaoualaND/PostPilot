package postpilote.social_media_integration_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import postpilote.social_media_integration_service.model.SocialMediaAccount;

import java.util.Optional;

public interface SocialMediaAccountRepository extends JpaRepository<SocialMediaAccount, String> {
    Optional<SocialMediaAccount> findByUserIdAndPlatform(String userId, String platform);
}
