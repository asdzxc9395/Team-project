package Team.project.dao;

import java.util.List;
import java.util.Map;
import Team.project.domain.Post;

public interface PostDao {

  public int insert(Post post) throws Exception;

  public List<Post> findAll() throws Exception;

  public Post findByNo(int no) throws Exception;

  public int update(Post post) throws Exception;

  public int delete(int no) throws Exception;

  public List<Post> findAll(int no) throws Exception;

  public List<Post> findByKeyword(Map<String, Object> params) throws Exception;
}
