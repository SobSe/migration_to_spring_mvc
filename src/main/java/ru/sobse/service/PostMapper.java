package ru.sobse.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sobse.model.Post;
import ru.sobse.model.PostDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "content", source = "content")
    PostDTO postToPostDTO(Post source);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "content", source = "content")
    Post postDTOToPost(PostDTO destination);

    List<PostDTO> postToPostDTO(List<Post> posts);
}
