package com.oops.walden.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oops.walden.entity.DomainInfo;
import com.oops.walden.mapper.DomainInfoMapper;
import com.oops.walden.service.DomainInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author ljh
 * @since 2021/9/29 17:04
 */
@Service
public class DomainInfoServiceImpl extends ServiceImpl<DomainInfoMapper, DomainInfo> implements DomainInfoService {

    @Resource
    private DomainInfoMapper domainInfoMapper;

    @Override
    public String getDomainInfo() {
        String[] a = {"a", "b", "c", "d" , "e" , "f",
                "g", "h", "i", "j" , "k" , "l",
                "m", "n", "o", "p" , "q" , "r",
                "s", "t", "u", "v" , "w" , "x",
                "y", "z" };

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    for (int l = 0; l < 26; l++) {
                        String area_domain = a[i] + a[j] + a[k] + a[l] + ".com";
                        try {
                            URL url = new URL("http://panda.www.net.cn/cgi-bin/check.cgi?area_domain=" + area_domain);
                            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setConnectTimeout(10000);  //毫秒
                            connection.setReadTimeout(5000);

                            InputStream inputStream = new BufferedInputStream(connection.getInputStream());

                            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                            String line = "";  //每次读取一行数据
                            String reg = "<original>(.*?)</original>";  //正则
                            while((line = reader.readLine()) != null){
                                if(line.matches(reg)){
//                  System.out.println(line);
                                    //只有两种状态，210表示可用，211表示不可用
                                    String state = line.substring(10, 13);
                                    if("210".equals(state)){
                                        System.out.println(area_domain + ":" + true);
                                        saveDomainInfo(area_domain, true, null);
                                    }else{
                                        System.out.println(area_domain + ":" +false);
                                        saveDomainInfo(area_domain, false, null);
                                    }
                                }
                            }

                        }  catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

    private void saveDomainInfo(String domain, Boolean status, String result){
        DomainInfo domainInfo = DomainInfo.builder()
                .domain(domain)
                .status(status)
                .result(result)
                .build();
        domainInfoMapper.insert(domainInfo);
    }
}
