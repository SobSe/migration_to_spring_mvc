package ru.sobse.repository;

import org.springframework.stereotype.Repository;
import ru.sobse.exception.NotFoundException;
import ru.sobse.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

// Stub
@Repository
public class PostRepository {
  private final Map<Long, Post> posts;
  private final AtomicLong counter;


  public PostRepository() {
    counter = new AtomicLong(0);
    posts = new ConcurrentHashMap<>();
  }

  public List<Post> all() {
    return new ArrayList<>(posts.values());
  }

  public Optional<Post> getById(long id) {
    return Optional.of(posts.get(id));
  }

  public Post save(Post post) {
    if (post.getId() == 0) {
      post.setId(counter.incrementAndGet());
      posts.put(post.getId(), post);
      return post;
    } else {
      return update(post).orElseThrow(NotFoundException::new);
    }
  }

  private Optional<Post> update(Post post) {
      Optional<Post> foundPost = Optional.of(posts.get(post.getId()));
      foundPost.ifPresent(value -> value.setContent(post.getContent()));
      return  foundPost;
  }

  public Optional<Post>  removeById(long id) {
    return Optional.of(posts.remove(id));
  }
}
