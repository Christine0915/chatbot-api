package cn.bugstack.chatbot.api.test;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author chris
 * @description 单元测试
 * @Copyright
 */
public class ApiTest {

    @Test
    public void querry_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient =  HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");


        get.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818524884188142%22%2C%22first_id%22%3A%221897c0694eb15d1-030d10394f6f09e-7e565474-1024000-1897c0694ec1565%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5N2MwNjk0ZWIxNWQxLTAzMGQxMDM5NGY2ZjA5ZS03ZTU2NTQ3NC0xMDI0MDAwLTE4OTdjMDY5NGVjMTU2NSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjgxODUyNDg4NDE4ODE0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818524884188142%22%7D%2C%22%24device_id%22%3A%221897c0694eb15d1-030d10394f6f09e-7e565474-1024000-1897c0694ec1565%22%7D; abtest_env=product; zsxq_access_token=4ADE3EF1-8DF2-D13D-B30E-18250A68B430_E6E7560B475BF585; zsxqsessionid=45fba9300d21a58c0752aece413c0676");
        get.addHeader("Content-Type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("");
        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");
        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");

        String resJson = "{\n}";
        StringEntity stringEntity = new StringEntity(resJson, ContentType.create("application/", "UTF-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse execute =  httpClient.execute(httpPost);

    }
    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 自行申请 https://beta.openai.com/overview");

        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"帮我写一个java冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


}
