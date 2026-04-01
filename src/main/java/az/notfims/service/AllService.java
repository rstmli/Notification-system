package az.notfims.service;

import az.notfims.dao.entity.ProductEntity;
import az.notfims.dao.repository.ProductRepository;
import az.notfims.dao.repository.UserRepository;
import az.notfims.dto.ProductRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AllService {
  private final NotificationService notificationService;
  private final ProductRepository productRepository;
  private final UserRepository userRepository;

  /// Product
  @Transactional
  public void addProduct(ProductRequest dto){
    var user = userRepository.findById(dto.getUserId()).get(); // sorgu 1
    var product = ProductEntity.builder()
            .productName(dto.getProductName())
            .productCategory(dto.getProductCategory())
            .userEntity(user)
            .build();
    productRepository.save(product);
    notificationService.sendNotification(user, product.getProductName() + " adli mehsul ugurla elave olundu");
  }
  public void deleteProduct(Long userId,Long productId){
    var user = userRepository.findById(userId).get();
    var product = productRepository.findById(productId).get();
     productRepository.delete(product);
    notificationService.sendNotification(user,product.getProductName() + " adli mehsul silindi");

  }


}
