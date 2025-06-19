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

import jakarta.servlet.http.HttpSession;

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
            + "highlight significant changes, and suggest any recommendations.\n\n"
            +"日本語で回答してください"
            +"文は100語程度でおねがいします。"
            +"文章のみを生成してください";

            return prompt;
  }

  private String ParsePrompt(HttpSession session){

    //sessionからuseridの取得
    final UserSession userSession=sessionUsecase.crateUserSession(session);
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


    int initializevalue=0;

    int groceries=initializevalue;
    int clothingCosts=initializevalue;
    int commutingCost=initializevalue;
    int miscellaneousExpenses=initializevalue;
    int sum=initializevalue;

    int pregroceries=initializevalue;
    int preclothingCosts=initializevalue;
    int precommutingCost=initializevalue;
    int premiscellaneousExpenses=initializevalue;
    int presum=initializevalue;


    if(optionalNowMemo.isPresent()){
     groceries=optionalNowMemo.get().getGroceries();
     clothingCosts=optionalNowMemo.get().getClothingCosts();
     commutingCost=optionalNowMemo.get().getCommutingCost();
     miscellaneousExpenses=optionalNowMemo.get().getMiscellaneousExpenses();
     sum=optionalNowMemo.get().getSum();
    }

    if(optionalLastMemo.isPresent()){
     pregroceries=optionalNowMemo.get().getGroceries();
     preclothingCosts=optionalNowMemo.get().getClothingCosts();
     precommutingCost=optionalNowMemo.get().getCommutingCost();
     premiscellaneousExpenses=optionalNowMemo.get().getMiscellaneousExpenses();
     presum=optionalLastMemo.get().getSum();
    }else{

    }


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

  public AIAssistantMessage createSendAssistantMessage(HttpSession session){
    String prompt=ParsePrompt(session);
    AIAssistantMessage aiAssistantMessage= new AIAssistantMessage(prompt);

    return aiAssistantMessage;
  }
}