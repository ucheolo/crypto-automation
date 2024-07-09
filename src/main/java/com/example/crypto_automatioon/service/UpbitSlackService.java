package com.example.crypto_automatioon.service;

import com.example.crypto_automatioon.http.SlackHttpClient;
import com.example.crypto_automatioon.http.UpbitHttpClient;
import com.example.crypto_automatioon.http.UpbitTickerDto;
import com.example.crypto_automatioon.repository.ReportHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
@RequiredArgsConstructor
public class UpbitSlackService {
    private final SlackHttpClient slackHttpClient;
    private final UpbitHttpClient upbitHttpClient;
    private final ReportHistoryRepository repository;

    public void execute(String market) {
        // upbit
        UpbitTickerDto tickerByMarket = upbitHttpClient.getTickerByMarket(market);

        // slack
        StringBuilder sb = new StringBuilder();
        sb.append("[실시간 데이터]");
        sb.append("\n");
        sb.append(market);
        sb.append(" price = ");

        DecimalFormat df = new DecimalFormat("#,###.##"); // 소수점 둘째 자리까지 표시
        String formattedPrice = df.format(tickerByMarket.getTrade_price()) + "원";

        sb.append(formattedPrice);

        slackHttpClient.send(sb.toString());

        repository.save(market, String.valueOf(formattedPrice));
    }
}
