package com.shoppingapp.app.service.core.dto;

public class ImageDetect{

  private final String base64Image;

  public ImageDetect(String base64Image){
    this.base64Image=base64Image;
  }

  public String getDetectImage(){
    return base64Image;
  }
}