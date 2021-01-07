package io.trabe.blog.filtersandresolvers.model.pojo;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserInformation {
    private Long id;
    private String name;
    private UserProfile profile;
    private String description;
}
