package az.notfims.controller;

import az.notfims.dto.NotificationDto;
import az.notfims.dto.ProductRequest;
import az.notfims.service.AllService;
import az.notfims.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class AllController {

  private final AllService allService;
  private final NotificationService notificationService;


  @PostMapping("/product/add")
  public void addProduct(@RequestBody ProductRequest dto){
    allService.addProduct(dto);
  }
  @DeleteMapping("/product/delete/{userId}/{productId}")
  public void deleteProduct(
          @PathVariable("userId") Long userId,
          @PathVariable("productId") Long productId
  ){
    allService.deleteProduct(userId,productId);
  }


  @GetMapping("/notification/show/{userId}")
  public List<NotificationDto> getNotification(
          @PathVariable("userId") Long id,
          @RequestParam boolean seen
  ){
    return notificationService.showNotification(id,seen);
  }

}
