package io.trabe.blog.filtersandresolvers.model.service;

import org.springframework.stereotype.Component;

import io.trabe.blog.filtersandresolvers.model.pojo.UserInformation;
import io.trabe.blog.filtersandresolvers.model.pojo.UserProfile;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public UserInformation getUserInformation(Long userId) {
        return UserInformation.builder()
                .name(String.format("User with id %d", userId))
                .description("Some description")
                .profile(UserProfile.ADMIN)
                .id(userId)
                .build();
    }
}
