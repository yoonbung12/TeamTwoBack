package TeamTwo.TeamTwoProject.controller.diary;

import TeamTwo.TeamTwoProject.dto.diary.DiaryDTO;
import TeamTwo.TeamTwoProject.service.diary.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController {
    @Autowired
    DiaryService diaryService;

    @GetMapping("/getCalendar")
    public List<DiaryDTO> getCalendar(@RequestParam int userId, @RequestParam String month){
        String createdAt = "-" + month + "-";
        List<DiaryDTO> result = diaryService.getCalendar(userId, createdAt);
        return result;
    }

    @GetMapping("/getMyDiary")
    public List<DiaryDTO> getMyDiary(@RequestParam int diaryId){
        List<DiaryDTO> result = diaryService.getMyDiary(diaryId);
        return result;
    }

    @GetMapping("/getEveryDiary")
    public List<DiaryDTO> getEveryDiary(@RequestParam boolean isPublic){
        List<DiaryDTO> result = diaryService.getEveryDiary(isPublic);
        return result;
    }

    @GetMapping("/getOneDiary")
    public List<DiaryDTO> getOneDiary(@RequestParam int diaryId){
        List<DiaryDTO> result = diaryService.getOneDiary(diaryId);
        return result;
    }

    @GetMapping("/search")
    public List<DiaryDTO> search(String searchWord){
        List<DiaryDTO> result = diaryService.search(searchWord);
        return result;
    }
}
