package az.notfims.service;

import az.notfims.dao.entity.NotificationEntity;
import az.notfims.dao.entity.UserEntity;
import az.notfims.dao.repository.NotificationRepository;
import az.notfims.dao.repository.UserRepository;
import az.notfims.dto.NotificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
  private final NotificationRepository notificationRepository;


  public void sendNotification(UserEntity e,String context){
    var notification = NotificationEntity.builder().context(context).userEntity(e).build();
    notificationRepository.save(notification);
  }
  public List<NotificationDto> showNotification(Long userId,boolean seen){
    var notification = notificationRepository.findByUserEntity_IdAndSeen(userId,seen);
    var dtoNotification =  notification.stream().map(
            (e) -> new NotificationDto("SYSTEM",e.getContext(),e.isSeen(),e.getCreatedAt())
    ).toList();
    for(NotificationEntity e : notification){
      e.setSeen(true);
    }
    notificationRepository.saveAll(notification);
    return dtoNotification;

  }
}
