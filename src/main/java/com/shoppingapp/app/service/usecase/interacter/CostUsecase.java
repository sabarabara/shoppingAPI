package com.shoppingapp.app.service.usecase.interacter;

import java.util.*;

import org.springframework.stereotype.Service;

import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.usecase.SessionUsecase;
import com.shoppingapp.app.service.core.domain.model.factory.Cost.IShoppingMemoFactory;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IShoppingMemoRepository;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IUserCostLimRepository;
import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;
import com.shoppingapp.app.service.core.entity.ShoppingMemoEntiry;
import com.shoppingapp.app.service.core.entity.UserCostLimEntity;
import com.shoppingapp.app.service.framework.DBserver.IdGeneratorImpl;
import com.shoppingapp.app.service.usecase.factory.Cost.DateFactory;

import jakarta.servlet.http.HttpSession;

@Service
public class CostUsecase{

  private final IShoppingMemoRepository shoppingMemoRepository;
  private final IUserCostLimRepository userCostLimRepository;
  //private final IMailServer mailServer;
  private final SessionUsecase sessionUsecase;
  private final DateFactory dateFactory;
  private final IShoppingMemoFactory shoppingMemoFactory;
  private final IdGeneratorImpl idGeneratorImpl;

  public CostUsecase(IShoppingMemoRepository shoppingMemoRepository,IUserCostLimRepository userCostLimRepository,/*IMailServer mailServer,*/ SessionUsecase sessionUsecase,DateFactory dateFactory, IShoppingMemoFactory shoppingMemoFactory,IdGeneratorImpl idGeneratorImpl){

    this.shoppingMemoRepository=shoppingMemoRepository;
    this.userCostLimRepository=userCostLimRepository;
    //this.mailServer=mailServer;
    this.sessionUsecase=sessionUsecase;
    this.dateFactory=dateFactory;
    this.shoppingMemoFactory=shoppingMemoFactory;
    this.idGeneratorImpl=idGeneratorImpl;
  }

  public String sendCostData(HttpSession session,ShoppingMemoDTO shoppingmemodto){

    //sessionからuseridの取得
    final UserSession userSession=sessionUsecase.crateUserSession(session);
    final String userId=userSession.getUserId();

    //今の月と年を取得
    final int year=dateFactory.getYear();
    final int month=dateFactory.getMonth();

    //userIdから今月のuserの使用量を取得
    Optional <ShoppingMemoEntiry> optionalMemo=shoppingMemoRepository.findByUserIdAndMonthAndYear(userId, month, year);

    int groceries=0;
    int clothingCosts=0;
    int commutingCost=0;
    int miscellaneousExpenses=0;
    String shoppingMemoId;


    //見つかったら値を追加
    if(optionalMemo.isPresent()){
      ShoppingMemoEntiry shoppingMemo=optionalMemo.get();

      groceries=shoppingMemo.getGroceries();
      clothingCosts=shoppingMemo.getClothingCosts();
      commutingCost=shoppingMemo.getCommutingCost();
      miscellaneousExpenses=shoppingMemo.getMiscellaneousExpenses();

      shoppingMemoId=shoppingMemo.getShoppingMemoId();
    }else{
      shoppingMemoId=idGeneratorImpl.generate("shoppingmemo");
    }

    //送られてきたdtoをfactoryからパース
    ShoppingMemoEntiry addedShoppingMemoEntiry=shoppingMemoFactory.createShoppingMemoEntiry(session,shoppingMemoId,shoppingmemodto);


    //ここで今月の分の蓄積料金に今きたやつを足すよ。
    groceries+=addedShoppingMemoEntiry.getGroceries();
    clothingCosts+=addedShoppingMemoEntiry.getClothingCosts();
    commutingCost+=addedShoppingMemoEntiry.getCommutingCost();
    miscellaneousExpenses+=addedShoppingMemoEntiry.getMiscellaneousExpenses();

    //dtoに入れる
    ShoppingMemoDTO sendShoppingMemoDTO = new ShoppingMemoDTO(groceries, commutingCost, clothingCosts, miscellaneousExpenses);
    ShoppingMemoEntiry sendingShoppingMemoEntiry=shoppingMemoFactory.createShoppingMemoEntiry(session,shoppingMemoId,sendShoppingMemoDTO);


    //もし合計値が設定値を超えていたらSMS or メールを送る
    //Optional<UserCostLimEntity> optinalUserCostLim=userCostLimRepository.findByuserId(userId);
    //int yourCostLim=optinalUserCostLim.get().getCostLim();
    //int nowSum=sendingShoppingMemoEntiry.getSum();

    /*if(yourCostLim<nowSum){
      String resMailServer=mailServer.sendCostLim();
    }*/

    //データを送るよ
    ShoppingMemoEntiry resShoppingMemoRepository=shoppingMemoRepository.save(sendingShoppingMemoEntiry);

    return "OK";
  }




  public List<ShoppingMemoDTO> recieveCostDataofMonths(HttpSession session){

    //sessionからuseridの取得
    final UserSession userSession=sessionUsecase.crateUserSession(session);
    final String userId=userSession.getUserId();

    //今の月を取得
    final int year=dateFactory.getYear();

    List<Optional<ShoppingMemoEntiry>> resShoppingMemoofMonths = shoppingMemoRepository.findByUserIdAndYear(userId,year);
    List<ShoppingMemoDTO> returnDtoArray = new ArrayList<>();

    //ここでdtoにパース
    for (Optional<ShoppingMemoEntiry> optional : resShoppingMemoofMonths) {
      ShoppingMemoEntiry resShoppingMemoofMonth=optional.get();

      int groceries=resShoppingMemoofMonth.getGroceries();
      int clothingCosts=resShoppingMemoofMonth.getClothingCosts();
      int commutingCost=resShoppingMemoofMonth.getCommutingCost();
      int miscellaneousExpenses=resShoppingMemoofMonth.getMiscellaneousExpenses();

      ShoppingMemoDTO returnDto=new ShoppingMemoDTO(groceries, commutingCost, clothingCosts, miscellaneousExpenses);
      returnDtoArray.add(returnDto);
    }

    return returnDtoArray;
  }


  
  public ShoppingMemoDTO receiveCostDataofMonth(HttpSession session){
    //sessionからuseridの取得
    final UserSession userSession=sessionUsecase.crateUserSession(session);
    final String userId=userSession.getUserId();

    //今の月と年を取得
    final int year=dateFactory.getYear();
    final int month=dateFactory.getMonth();

    Optional <ShoppingMemoEntiry> optionalMemo=shoppingMemoRepository.findByUserIdAndMonthAndYear(userId, month, year);

      ShoppingMemoEntiry resShoppingMemoofMonth=optionalMemo.get();

      int groceries=resShoppingMemoofMonth.getGroceries();
      int clothingCosts=resShoppingMemoofMonth.getClothingCosts();
      int commutingCost=resShoppingMemoofMonth.getCommutingCost();
      int miscellaneousExpenses=resShoppingMemoofMonth.getMiscellaneousExpenses();

      ShoppingMemoDTO returnDto=new ShoppingMemoDTO(groceries, commutingCost, clothingCosts, miscellaneousExpenses);

      return returnDto;
  }
}