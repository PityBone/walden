package com.oops.walden.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oops.walden.entity.DomainInfo;
import com.oops.walden.mapper.DomainInfoMapper;
import com.oops.walden.service.DomainInfoService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljh
 * @since 2021/9/29 17:04
 */
@Service
public class DomainInfoServiceImpl extends ServiceImpl<DomainInfoMapper, DomainInfo> implements DomainInfoService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static List<DomainInfo> list = new ArrayList<>();

    private static Long domain1 = null;

    private static final String[] PARAMS = {"a", "b", "c", "d" , "e" , "f",
            "g", "h", "i", "j" , "k" , "l",
            "m", "n", "o", "p" , "q" , "r",
            "s", "t", "u", "v" , "w" , "x",
            "y", "z" };

    @Override
    public String getDomainInfo() {
       new Thread(){
           @Override
           public void run(){
               for (int i = 0; i < 26; i++) {
                   for (int j = 0; j < 26; j++) {
                       for (int k = 0; k < 26; k++) {
                           for (int l = 0; l < 26; l++) {
                               for (int m = 0; m < 26; m++) {
                                   String domain = PARAMS[i] + PARAMS[j] + PARAMS[k] + PARAMS[l] + PARAMS[m] + ".com";
                                   checkDomain(domain);
                               }
                           }
                       }
                   }
               }
           }
       }.start();
        return null;
    }

    private void checkDomain(String domain){
        try {
            URL url = new URL("http://panda.www.net.cn/cgi-bin/check.cgi?area_domain=" + domain);
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(5000);

            InputStream inputStream = new BufferedInputStream(connection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String reg = "<original>(.*?)</original>";
            String reg1 = "<title>(.*?)</title>";
            StringBuilder str = new StringBuilder();
            while((line = reader.readLine()) != null){
                str.append(line);
                if(line.matches(reg)){
                    //只有两种状态，210表示可用，211表示不可用
                    String state = line.substring(10, 13);
                    if("210".equals(state)){
                        System.out.println(domain + ":" + true);
                        saveDomainInfo(domain, true, str.toString());
                    }else{
                        System.out.println(domain + ":" + false);
                        saveDomainInfo(domain, false, str.toString());
                    }
                }
                if(line.matches(reg1)){
                    System.out.println(domain + ":" + "again");
                    checkDomain(domain);
                }
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDomainInfoByDomain(String domain) {
        checkDomain(domain);
        return "OK";
    }

    private void saveDomainInfo(String domain, Boolean status, String result){

        String domain2 = stringRedisTemplate.opsForValue().get("domain");
        if(domain2 == null){
            stringRedisTemplate.opsForValue().set("domain", "1");
            pack(domain, status, result);
        }else{
            domain1 = stringRedisTemplate.opsForValue().increment("domain");
            pack(domain, status, result);
        }

        if(Long.valueOf("500").equals(domain1)){
            System.out.println("=================保存=================");
            this.saveBatch(list);
            list.clear();
            domain1 = null;
            stringRedisTemplate.delete("domain");
        }
    }
    private void pack(String domain, Boolean status, String result){
        DomainInfo domainInfo = DomainInfo.builder()
                .domain(domain)
                .status(status)
                .result(result)
                .build();

        list.add(domainInfo);
    }
}
