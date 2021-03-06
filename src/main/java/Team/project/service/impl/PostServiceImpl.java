package Team.project.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;
import Team.project.dao.PostDao;
import Team.project.domain.Post;
import Team.project.service.PostService;

@Component
public class PostServiceImpl implements PostService {

  PostDao postDao;

  public PostServiceImpl(PostDao postDao) {
    this.postDao = postDao;
  }

  @Override
  public void add(Post post) throws Exception {
    postDao.insert(post);
  }

  @Override
  public List<Post> list() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int delete(int no) throws Exception {
    return postDao.delete(no);
  }

  @Override
  public Post get(int no) throws Exception {
    return postDao.findByNo(no);
  }

  @Override
  public int update(Post post) throws Exception {
    return postDao.update(post);
  }

  @Override
  public List<Post> list(int no) throws Exception {
    return postDao.findAll(no);
  }

  @Override
  public List<Post> search(HashMap<String, Object> params) throws Exception {
    return postDao.findByKeyword(params);
  }


}
