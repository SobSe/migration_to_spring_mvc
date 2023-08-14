package ru.sobse.model;

public class PostDTO {
  private long id;
  private String content;

  public PostDTO() {
  }

  public PostDTO(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != getClass()) return false;
    PostDTO post = (PostDTO) obj;
    return this.id == post.getId();
  }
}
