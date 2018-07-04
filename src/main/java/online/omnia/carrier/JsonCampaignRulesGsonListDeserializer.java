package online.omnia.carrier;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lollipop on 15.02.2018.
 */
public class JsonCampaignRulesGsonListDeserializer implements JsonDeserializer<List<CampaignRule>>{
    @Override
    public List<CampaignRule> deserialize(JsonElement jsonElement, Type type,
                                          JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray array = jsonElement.getAsJsonObject().get("records").getAsJsonArray();
        ArrayList<CampaignRule> campaignRules = new ArrayList<>();
        CampaignRule campaignRule;
        for (JsonElement element : array) {
            campaignRule = new CampaignRule();
            campaignRule.setCampaignId(element.getAsJsonObject().get("campaign_id").getAsInt());
            campaignRule.setType(element.getAsJsonObject().get("type").getAsString());
            if (element.getAsJsonObject().get("device_os_id").isJsonNull()) campaignRule.setDeviceOsId(null);
            else campaignRule.setDeviceOsId(element.getAsJsonObject().get("device_os_id").getAsInt());
            if (element.getAsJsonObject().get("device_os_version_id").isJsonNull()) campaignRule.setDeviceOsVersionId(null);
            else campaignRule.setDeviceOsVersionId(element.getAsJsonObject().get("device_os_version_id").getAsString());
            if (element.getAsJsonObject().get("device_make_id").isJsonNull()) campaignRule.setDeviceMakeId(null);
            else campaignRule.setDeviceMakeId(element.getAsJsonObject().get("device_make_id").getAsInt());
            if (element.getAsJsonObject().get("device_model_id").isJsonNull()) campaignRule.setDeviceModelId(null);
            else campaignRule.setDeviceModelId(element.getAsJsonObject().get("device_model_id").getAsInt());
            if (element.getAsJsonObject().get("carrier_id").isJsonNull()) campaignRule.setCarrierId(null);
            else campaignRule.setCarrierId(element.getAsJsonObject().get("carrier_id").getAsInt());
            if (element.getAsJsonObject().get("placement_id").isJsonNull()) campaignRule.setPlacementId(null);
            else campaignRule.setPlacementId(element.getAsJsonObject().get("placement_id").getAsInt());
            if (element.getAsJsonObject().get("carrier_isp_id").isJsonNull()) campaignRule.setCarrierIspId(null);
            else campaignRule.setCarrierIspId(element.getAsJsonObject().get("carrier_isp_id").getAsInt());
            if (element.getAsJsonObject().get("exchange_id").isJsonNull()) campaignRule.setExchangeId(null);
            else campaignRule.setExchangeId(element.getAsJsonObject().get("exchange_id").getAsInt());
            campaignRules.add(campaignRule);
        }
        return campaignRules;
    }
}
