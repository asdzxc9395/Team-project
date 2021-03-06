package Team.project.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import Team.project.domain.Clazz;
import Team.project.service.AnswerService;
import Team.project.service.AssignmentService;
import Team.project.service.AssignmentSubmitService;
import Team.project.service.ClazzMemberService;
import Team.project.service.ClazzService;
import Team.project.service.MultipleService;
import Team.project.service.QuestionService;
import Team.project.service.TagService;

@Controller
@RequestMapping("/room")
public class LessonController {
  @Autowired
  AssignmentService assignmentService;
  @Autowired
  AssignmentSubmitService assignmentSubmitService;
  @Autowired
  QuestionService questionService;
  @Autowired
  AnswerService answerService;
  @Autowired
  TagService tagService;
  @Autowired
  MultipleService multipleService;
  @Autowired
  ClazzMemberService clazzMemberService;
  @Autowired
  ClazzService clazzService;

  @RequestMapping("lesson/list")
  public String list(int room_no, Model model, HttpSession session) throws Exception {
    // 현재 접속한 클래스룸의 정보를 세션에 "clazzNow"로 저장
    Clazz clazz = clazzService.get(room_no);
    session.removeAttribute("clazzNow");
    session.setAttribute("clazzNow", clazz);
    session.setAttribute("clazzNowNo", clazz.getClassNo());

    ObjectMapper mapper = new ObjectMapper();
    String questionJson = mapper.writeValueAsString(questionService.list(room_no));
    String assignmentJson = mapper.writeValueAsString(assignmentService.list(room_no));

    model.addAttribute("questionJson", questionJson);
    model.addAttribute("assignmentJson", assignmentJson);

    return "/WEB-INF/jsp/room/lesson.jsp";
  }


}
