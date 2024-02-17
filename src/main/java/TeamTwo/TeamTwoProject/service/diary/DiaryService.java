package TeamTwo.TeamTwoProject.service.diary;

import TeamTwo.TeamTwoProject.dto.diary.DiaryDTO;
import TeamTwo.TeamTwoProject.entity.diary.DiaryEntity;
import TeamTwo.TeamTwoProject.repository.diary.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryService {
    @Autowired
    private DiaryRepository diaryRepository;

    public List<DiaryDTO> getCalendar(int userId, String createdAt) {
        List<DiaryEntity> getCalendarData = diaryRepository.findByUserIdAndCreatedAtLike(userId, createdAt);
        List<DiaryDTO> getCalendarResult = new ArrayList<>();

//        DiaryDTO diaryDTO = DiaryDTO.builder()
//                        .diaryId(getCalendarData.get)
//        getCalendarResult.add(diaryDTO);

        for (DiaryEntity CalendarData : getCalendarData) {
            DiaryDTO diaryDTO = DiaryDTO.builder()
                    .diaryId(CalendarData.getDiaryId())
                    .mood(CalendarData.getMood())
                    .createdAt(CalendarData.getCreatedAt())
                    .build();
            getCalendarResult.add(diaryDTO);
        }
        return getCalendarResult;
    }

    public List<DiaryDTO> getMyDiary(int diaryId) {
        List<DiaryEntity> getMyDiaryData = diaryRepository.findByDiaryId(diaryId);
        List<DiaryDTO> getMyDiaryResult = new ArrayList<>();

        for (DiaryEntity DiaryData : getMyDiaryData) {
            // 리더님 여기 유저 테이블(리액션 테이블도)의 정보를 조인해서 가져오고 싶은데 어떤 방식을 사용해야 할까요
            // 1. DiaryRepository 에서 조인하는 기본규칙을 사용한다(그런 기본 규칙이 있는지는 모르겠습니다.)
            // ex) DiaryRepository
            // List<DiaryEntity> id로유저테이블에접근하는기본규칙~~~~(int id, Timestamp createdAt);
            // 1 번이랍니다. 다만 보통 그런 경우 DTO를 따로 만드는 경우도 있다고 하네요
            DiaryDTO diaryDTO = DiaryDTO.builder()
                    .diaryTitle(DiaryData.getDiaryTitle())
                    .diaryContent(DiaryData.getDiaryContent())
                    .mood(DiaryData.getMood())
                    .createdAt(DiaryData.getCreatedAt())
                    .updatedAt(DiaryData.getUpdatedAt())
                    .location(DiaryData.getLocation())
                    .weather(DiaryData.getWeather())
                    .isPublic(DiaryData.isPublic())
                    .build();
            getMyDiaryResult.add(diaryDTO);
        }
        return getMyDiaryResult;
    }

    public List<DiaryDTO> getEveryDiary(boolean isPublic) {
        List<DiaryEntity> getEveryDiaryData = diaryRepository.findByIsPublic(isPublic);
        List<DiaryDTO> getEveryDiaryResult = new ArrayList<>();

        for (DiaryEntity DiaryData : getEveryDiaryData) {
            DiaryDTO diaryDTO = DiaryDTO.builder()
                    .diaryId(DiaryData.getDiaryId())
                    .diaryTitle(DiaryData.getDiaryTitle())
                    .diaryContent(DiaryData.getDiaryContent())
                    .build();
            getEveryDiaryResult.add(diaryDTO);
        }
        return getEveryDiaryResult;
    }

    public List<DiaryDTO> getOneDiary(int diaryId) {
        List<DiaryEntity> getOneDiaryData = diaryRepository.findByDiaryId(diaryId);
        List<DiaryDTO> getOneDiaryResult = new ArrayList<>();

        for (DiaryEntity DiaryData : getOneDiaryData) {
            DiaryDTO diaryDTO = DiaryDTO.builder()
                    .diaryTitle(DiaryData.getDiaryTitle())
                    .diaryContent(DiaryData.getDiaryContent())
                    .build();
            getOneDiaryResult.add(diaryDTO);
        }
        return getOneDiaryResult;
    }

    public List<DiaryDTO> search(String diaryTitle, String diaryContent) {
        List<DiaryEntity> searchData = diaryRepository.findByDiaryTitleLikeOrDiaryContentLike(diaryTitle, diaryContent);
        List<DiaryDTO> searchResult = new ArrayList<>();

        for (DiaryEntity DiaryData : searchData) {
            DiaryDTO diaryDTO = DiaryDTO.builder()
                    .diaryId(DiaryData.getDiaryId())
                    .diaryTitle(DiaryData.getDiaryTitle())
                    .diaryContent(DiaryData.getDiaryContent())
                    .build();
            searchResult.add(diaryDTO);
        }
        return searchResult;
    }

//    public boolean postDiary() {
//    }
//
//    public boolean patchDiary() {
//    }
//
//    public boolean deleteDiary() {
//    }
//
//    public boolean reaction() {
//    }

}