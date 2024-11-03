package org.socialmediaintegrationservice.service;

import org.socialmediaintegrationservice.model.SocialAccount;

import java.util.List;

public interface SocialAccountService {
    SocialAccount connectAccount(SocialAccount account);
    List<SocialAccount> getAllAccounts();

}
