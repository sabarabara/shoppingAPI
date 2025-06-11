package com.shoppingapp.app.service.usecase.factory.AIassistant;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.usecase.SessionUsecase;
import com.shoppingapp.app.service.core.domain.model.factory.AIAssistant.ISendMessageFactory;
import com.shoppingapp.app.service.core.domain.model.vo.AIAssistant.AIAssistantMessage;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IShoppingMemoRepository;
import com.shoppingapp.app.service.core.entity.ShoppingMemoEntiry;
import com.shoppingapp.app.service.usecase.factory.Cost.DateFactory;

@Service
public class SendMessageFactory implements ISendMessageFactory{

  private final IShoppingMemoRepository shoppingMemoRepository;
  private final DateFactory dateFactory;
  private final SessionUsecase sessionUsecase;

  public SendMessageFactory(IShoppingMemoRepository shoppingMemoRepository,DateFactory dateFactory,SessionUsecase sessionUsecase){
    this.shoppingMemoRepository=shoppingMemoRepository;
    this.dateFactory=dateFactory;
    this.sessionUsecase=sessionUsecase;
  }

  private String createPrompt(String gr,String cl,String co,String mi,String sum,String prgr,String prcl,String prco,String prmi,String prsum){
    String prompt = "Please provide a detailed analysis comparing the expenses between last month and this month:\n"
            + "- Groceries: Last month = " + prgr + ", This month = " + gr + "\n"
            + "- Clothing: Last month = " + prcl + ", This month = " + cl + "\n"
            + "- Commuting: Last month = " + prco + ", This month = " + co + "\n"
            + "- Miscellaneous: Last month = " + prmi + ", This month = " + mi + "\n"
            + "- Total: Last month = " + prsum + ", This month = " + sum + "\n\n"
            + "Please explain the possible reasons for any increases or decreases, "
            + "highlight significant changes, and suggest any recommendations.\n\n";

            return prompt;
  }

  private String ParsePrompt(){

    //sessionからuseridの取得
    final UserSession userSession=sessionUsecase.crateUserSession();
    final String userId=userSession.getUserId();

    //今の月と年を取得
    final int year=dateFactory.getYear();
    final int month=dateFactory.getMonth();

    int lastyear=year;
    int lastmonth=month;

    if(month!=1){
      lastmonth--;
    }else{
      lastyear--;
      lastmonth=12;
    }


    Optional <ShoppingMemoEntiry> optionalNowMemo=shoppingMemoRepository.findByUserIdAndMonthAndYear(userId, month, year);
    Optional <ShoppingMemoEntiry> optionalLastMemo=shoppingMemoRepository.findByUserIdAndMonthAndYear(userId, lastmonth, lastyear);

    int groceries=optionalNowMemo.get().getGroceries();
    int clothingCosts=optionalNowMemo.get().getClothingCosts();
    int commutingCost=optionalNowMemo.get().getCommutingCost();
    int miscellaneousExpenses=optionalNowMemo.get().getMiscellaneousExpenses();
    int sum=optionalNowMemo.get().getSum();

    int pregroceries=optionalNowMemo.get().getGroceries();
    int preclothingCosts=optionalNowMemo.get().getClothingCosts();
    int precommutingCost=optionalNowMemo.get().getCommutingCost();
    int premiscellaneousExpenses=optionalNowMemo.get().getMiscellaneousExpenses();
    int presum=optionalLastMemo.get().getSum();


    String groceries_str=String.valueOf(groceries);
    String clothingCosts_str=String.valueOf(clothingCosts);
    String commutingCost_str=String.valueOf(commutingCost);
    String miscellaneousExpenses_str=String.valueOf(miscellaneousExpenses);
    String sum_str=String.valueOf(sum);

    String pregroceries_str=String.valueOf(pregroceries);
    String preclothingCosts_str=String.valueOf(preclothingCosts);
    String precommutingCost_str=String.valueOf(precommutingCost);
    String premiscellaneousExpenses_str=String.valueOf(premiscellaneousExpenses);
    String presum_str=String.valueOf(presum);

    String prompt=createPrompt(groceries_str, clothingCosts_str, commutingCost_str, miscellaneousExpenses_str, sum_str, pregroceries_str, preclothingCosts_str, precommutingCost_str, premiscellaneousExpenses_str, presum_str);
    return prompt;
  }

  public AIAssistantMessage createSendAssistantMessage(){
    String prompt=ParsePrompt();
    AIAssistantMessage aiAssistantMessage= new AIAssistantMessage(prompt);

    return aiAssistantMessage;
  }
}