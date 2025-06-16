package com.shoppingapp.app.service.framework.Mailserver;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.usecase.SessionUsecase;
import com.shoppingapp.app.service.core.domain.service.interacter.IMailServer;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SnsEmailSubscribe implements IMailServer {

    private final SessionUsecase sessionUsecase;

    @Value("${aws.accessKeyId}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.sns.topicArn}")
    private String topicArn;

    public SnsEmailSubscribe(SessionUsecase sessionUsecase) {
        this.sessionUsecase = sessionUsecase;
    }

    @Override
    public String sendCostLim(HttpSession session) {
        UserSession userSession = sessionUsecase.crateUserSession(session);
        String email = userSession.getEmail();

        // 認証情報を用意してSNSクライアント作成
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        AmazonSNS snsClient = AmazonSNSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(region)
                .build();

        // サブスクリプションリクエスト作成
        SubscribeRequest request = new SubscribeRequest()
                .withTopicArn(topicArn)
                .withProtocol("email")
                .withEndpoint(email);

        snsClient.subscribe(request);

        System.out.println("✅ SNS subscription requested for: " + email);
        return "Subscription request sent to: " + email;
    }
}
