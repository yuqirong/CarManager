package com.carmanager.shiro.credentials;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.carmanager.entities.User;
import com.carmanager.services.UserService;

public class RetryLimitHashedCredentialsMatcher extends
		HashedCredentialsMatcher {

	private Cache<String, AtomicInteger> passwordRetryCache;
	@Autowired
	private UserService userService;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		User user = userService.findByUsername(username);
		// retry count + 1
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > 5) {
			// if retry count > 5 throw 账户会被锁定
			if (user != null) {
				user.setLoginFailureCount(retryCount.incrementAndGet());
				user.setEnabled(false);
				user.setLockedTime(new Date());
				userService.updateEntity(user);
			}
			throw new ExcessiveAttemptsException();
		}

		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			if (user != null) {
				if (user.isEnabled()) {
					passwordRetryCache.remove(username);
					user.setLoginFailureCount(0);
					user.setLoginTime(new Date());
					userService.updateEntity(user);
				} else {
					throw new DisabledAccountException();
				}
			}
		}

		return matches;
	}
}
