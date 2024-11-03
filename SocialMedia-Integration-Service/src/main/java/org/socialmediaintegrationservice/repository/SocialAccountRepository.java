package org.socialmediaintegrationservice.repository;

import org.socialmediaintegrationservice.model.SocialAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialAccountRepository extends JpaRepository<SocialAccount, Long> {
}
