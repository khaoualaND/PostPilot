package org.socialmediaintegrationservice.service;

import org.socialmediaintegrationservice.model.SocialAccount;
import org.socialmediaintegrationservice.repository.SocialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialAccountServiceImpl implements SocialAccountService {
    @Autowired
    private SocialAccountRepository socialAccountRepository;

    @Override
    public SocialAccount connectAccount(SocialAccount account) {
        // Business logic for connecting a social account
        return socialAccountRepository.save(account);
    }

    @Override
    public List<SocialAccount> getAllAccounts() {
        // Logic for retrieving all social accounts
        return socialAccountRepository.findAll();
    }
}