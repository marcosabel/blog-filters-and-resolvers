package io.trabe.blog.filtersandresolvers.model.service;

import io.trabe.blog.filtersandresolvers.model.pojo.UserInformation;

public interface UserService {

    UserInformation getUserInformation(Long userId);

}
