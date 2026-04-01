package az.notfims.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "NOTFI_USER")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
  int age;
  @OneToMany(mappedBy = "userEntity")
  List<NotificationEntity> notifications;

  @OneToMany(mappedBy = "userEntity")
  List<ProductEntity> products;

}
