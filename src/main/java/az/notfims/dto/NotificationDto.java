package az.notfims.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class NotificationDto {
  String sender;
  String context;
  boolean seen;
  LocalDateTime createdAt;

}
