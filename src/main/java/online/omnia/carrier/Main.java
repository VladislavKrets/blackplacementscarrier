package online.omnia.carrier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by lollipop on 15.02.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) return;
        String from = args[0];
        String to = args[1];
        String token = "13d674a58cf43573bff3e59fa7db9d02e42b9a8f13d674a58cf43573bff3e59f";
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(List.class, new JsonCampaignRulesGsonListDeserializer());
        Gson gson = builder.create();
        List<CampaignRule> campaignRules;
        String str;
        HttpURLConnection httpcon;
        OutputStream os;
        BufferedReader reader;
        byte[] outputBytes;
        String line;
        StringBuilder lineBuilder;
        String answer;

        for (int i = 1; true; i++) {
            answer = HttpMethodUtils.getMethod("https://api.go2mobi.com/v1/campaign_rules?campaign="
                    + from + "&page_size=500&page_number=" + i, token);
            System.out.println(answer);
            campaignRules = gson.fromJson(answer, List.class);
            if (campaignRules.isEmpty()) break;
            for (CampaignRule campaignRule : campaignRules) {
                if (campaignRule.getType().equals("black") && campaignRule.getPlacementId() != null) {
                    str = "{\"type\": \"black\"," +
                            (campaignRule.getDeviceOsId() != null ? "\"device_os_id\": \"" + campaignRule.getDeviceOsId() + "\"," : "") +
                            (campaignRule.getDeviceOsVersionId() != null ? "\"device_os_version_id\": \"" + campaignRule.getDeviceOsVersionId() + "\"," : "") +
                            (campaignRule.getDeviceMakeId() != null ? "\"device_make_id\": \"" + campaignRule.getDeviceMakeId() + "\"," : "") +
                            (campaignRule.getDeviceModelId() != null ? "\"device_model_id\": \"" + campaignRule.getDeviceModelId() + "\"," : "") +
                            (campaignRule.getCarrierId() != null ? "\"carrier_id\": \"" + campaignRule.getCarrierId() + "\"," : "") +
                            (campaignRule.getCarrierIspId() != null ? "\"carrier_isp_id\": \"" + campaignRule.getCarrierIspId() + "\"," : "") +
                            (campaignRule.getPlacementId() != null ? "\"placement_id\": \"" + campaignRule.getPlacementId() + "\"," : "") +
                            (campaignRule.getExchangeId() != null ? "\"exchange_id\": \"" + campaignRule.getExchangeId() + "\"," : "");
                    str = str.substring(0, str.length() - 1);
                    str = str + "}";
                    System.out.println(str);
                    httpcon = (HttpURLConnection) ((new URL("https://api.go2mobi.com/v1/campaigns/" + to + "/rules").openConnection()));
                    httpcon.setDoOutput(true);
                    httpcon.setRequestProperty("Content-Type", "application/json");
                    httpcon.setRequestProperty("Authorization", "Token 13d674a58cf43573bff3e59fa7db9d02e42b9a8f13d674a58cf43573bff3e59f");
                    httpcon.setRequestMethod("POST");
                    httpcon.connect();
                    outputBytes = str.getBytes("UTF-8");
                    os = httpcon.getOutputStream();
                    os.write(outputBytes);
                    os.close();
                    reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
                    lineBuilder = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        lineBuilder.append(line);
                    }
                }
            }
        }


    }
}
