package io.trabe.blog.filtersandresolvers.model.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ContextInformation {
    private Long parentId;
    private Long userId;
    private UserProfile profile;
}
