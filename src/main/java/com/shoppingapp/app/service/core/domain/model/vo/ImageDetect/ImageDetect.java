package com.shoppingapp.app.service.core.domain.model.vo.ImageDetect;

public class ImageDetect{

  private final String detectimage;

  public ImageDetect(String detectimage){
    this.detectimage=detectimage;
  }


  public String getDetectimage(){
    return detectimage;
  }
}