package ru.sobse.service;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import ru.sobse.exception.NotFoundException;
import ru.sobse.model.Post;
import ru.sobse.model.PostDTO;
import ru.sobse.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
  private final PostRepository repository;
  private final PostMapper mapper;

  public PostService(PostRepository repository, PostMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<PostDTO> all() {
    return mapper.postToPostDTO(repository.all());
  }

  public PostDTO getById(long id) {
    return mapper.postToPostDTO(repository.getById(id).orElseThrow(NotFoundException::new));
  }

  public PostDTO save(PostDTO post) {
    return mapper.postToPostDTO(repository.save(mapper.postDTOToPost(post)));
  }

  public PostDTO removeById(long id) {
    return mapper.postToPostDTO(repository.removeById(id).orElseThrow(NotFoundException::new));
  }
}

